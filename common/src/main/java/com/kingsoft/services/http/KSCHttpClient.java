package com.kingsoft.services.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpStatus;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.protocol.BasicHttpContext;

import com.kingsoft.services.ClientOptions;
import com.kingsoft.services.HttpHeaders;
import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.ResponseMessage;
import com.kingsoft.services.auth.Signer;
import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.exception.KSCServiceException;
import com.kingsoft.services.exception.ServiceUnavailableException;
import com.kingsoft.services.handlers.HttpResponseHandler;
import com.kingsoft.services.retry.RetryStrategy;

@ThreadSafe
public class KSCHttpClient implements IKSCHttpClient {

  static final Log log = LogFactory.getLog(KSCHttpClient.class);

  private final ClientOptions options;

  /** Internal client for sending HTTP requests */
  private final HttpClient httpClient;

  private static final HttpRequestFactory httpRequestFactory = new HttpRequestFactory();
  private static final HttpClientFactory httpClientFactory = new HttpClientFactory();

  public KSCHttpClient(ClientOptions options) {
    this(options, httpClientFactory.createHttpClient(options));
  }

  protected KSCHttpClient(ClientOptions options, HttpClient httpClient) {
    this.options = options;
    this.httpClient = httpClient;
  }

  @Override
  public <T> ResponseMessage<T> execute(RequestMessage<?> requestMsg,
      HttpResponseHandler<ResponseMessage<T>> responseHandler,
      HttpResponseHandler<KSCServiceException> errorResponseHandler)
      throws KSCServiceException, KSCClientException {
    final ExecOneRequestParams params = new ExecOneRequestParams();
    while (true) {
      params.initPerRetry();

      try {
        ResponseMessage<T> response = executeOneRequest(requestMsg,
            responseHandler, errorResponseHandler, params);
        if (response != null) {
          return response;
        }
        if (!shouldRetry(requestMsg, params.apacheRequest,
            params.retriedException, params.tryTimes,
            options.getRetryStrategy())) {
          assert (params.retriedException != null);
          throw params.retriedException;
        }
      } catch (IOException e) {
        KSCClientException exp = new ServiceUnavailableException(
            "Unable to execute HTTP request: " + e.getMessage(), e);
        if (!shouldRetry(requestMsg, params.apacheRequest, exp,
            params.tryTimes, options.getRetryStrategy())) {
          throw exp;
        }
        params.retriedException = exp;
      } finally {
        if (params.apacheResponse != null) {
          HttpEntity entity = params.apacheResponse.getEntity();
          if (entity != null) {
            try {
              if (entity.getContent() != null) {
                entity.getContent().close();
              }
            } catch (IOException e) {
              log.warn("Cannot close the response content.", e);
            }
          }
        }
      }
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public void shutdown() {
    IdleConnectionReaper.removeConnectionManager(httpClient
        .getConnectionManager());
    httpClient.getConnectionManager().shutdown();
  }

  /**
   * Stateful parameters that are used for executing a single http request.
   */
  private static class ExecOneRequestParams {
    int tryTimes; // monotonic increasing
    KSCClientException retriedException; // last retryable exception
    HttpRequestBase apacheRequest;
    org.apache.http.HttpResponse apacheResponse;

    public int getTryTimes() {
      return tryTimes;
    }

    boolean isRetry() {
      return tryTimes > 1;
    }

    void initPerRetry() {
      tryTimes++;
      apacheRequest = null;
      apacheResponse = null;
    }

    void resetBeforeHttpRequest() {
      retriedException = null;
    }
  }

  /**
   * Creates and initializes an HttpResponse object suitable to be passed to an
   * HTTP response handler object.
   *
   * @param method
   *          The HTTP method that was invoked to get the response.
   * @param request
   *          The HTTP request associated with the response.
   *
   * @return The new, initialized HttpResponse object ready to be passed to an
   *         HTTP response handler object.
   *
   * @throws IOException
   *           If there were any problems getting any response information from
   *           the HttpClient method object.
   */
  private HttpResponse createResponse(HttpRequestBase method,
      RequestMessage<?> request, org.apache.http.HttpResponse apacheHttpResponse)
      throws IOException {
    HttpResponse httpResponse = new HttpResponse(request, method);

    if (apacheHttpResponse.getEntity() != null) {
      httpResponse.setContent(apacheHttpResponse.getEntity().getContent());
    }

    httpResponse.setStatusCode(apacheHttpResponse.getStatusLine()
        .getStatusCode());
    httpResponse.setStatusText(apacheHttpResponse.getStatusLine()
        .getReasonPhrase());

    for (Header header : apacheHttpResponse.getAllHeaders()) {
      httpResponse.addHeader(header.getName(), header.getValue());
    }

    if (apacheHttpResponse.containsHeader(HttpHeaders.RESPONSE_CODE)) {
      httpResponse.setResponseCode(Integer.parseInt(apacheHttpResponse
          .getFirstHeader(HttpHeaders.RESPONSE_CODE).getValue()));
    }

    return httpResponse;
  }

  /**
   * Returns the response from executing one http request; or null for retry.
   * 
   * @throws IOException
   */
  private <T> ResponseMessage<T> executeOneRequest(
      final RequestMessage<?> request, HttpResponseHandler<ResponseMessage<T>> responseHandler,
      HttpResponseHandler<KSCServiceException> errorResponseHandler,
      ExecOneRequestParams execParams) throws KSCServiceException, IOException {
    if (execParams.isRetry()) {
      // reset input stream for readable
      InputStream requestInputStream = request.getContent();
      if (requestInputStream != null) {
        if (requestInputStream.markSupported()) {
          requestInputStream.reset();
        }
      }

      // back off if needed
      if (execParams.retriedException != null) {
        pauseBeforeNextRetry(request, execParams.retriedException,
            execParams.tryTimes, options.getRetryStrategy());
      }
    }

    Signer.sign(request);
    execParams.apacheRequest = httpRequestFactory.createHttpRequest(request,
        options);
    execParams.resetBeforeHttpRequest();

    // ///////// Send HTTP request ////////////
    long startTime = Calendar.getInstance().getTimeInMillis();

    try {
      execParams.apacheResponse = httpClient.execute(execParams.apacheRequest,
          new BasicHttpContext());
    } catch (IOException e) {
      long endTime = Calendar.getInstance().getTimeInMillis();
      log.warn(String
          .format(
              "http io error:%s, logid:%s, server:%s:%d, try_times:%d, cost:%dms",
              e.getMessage(), request.getRequestId(), execParams.apacheRequest
                  .getURI().getHost(), execParams.apacheRequest.getURI()
                  .getPort(), execParams
                  .getTryTimes(), endTime - startTime));
      throw e;
    }
    HttpResponse httpResponse = createResponse(execParams.apacheRequest,
        request, execParams.apacheResponse);

    long ioEndTime = Calendar.getInstance().getTimeInMillis();

    try {
        if (isRequestSuccessful(execParams.apacheResponse)) {
            try {
                ResponseMessage<T> response = new ResponseMessage<T>();
                response.setRequestId(request.getRequestId());
                for (Header header : execParams.apacheResponse.getAllHeaders()) {
                    response.addMetadata(header.getName(), header.getValue());
                }

                ResponseMessage<T> content = responseHandler.handle(httpResponse);
                response.setContent(content.getContent());
                return response;
            } catch (KSCClientException e) {
                execParams.retriedException = e;
                return null;
            } catch (Exception e) {
              String errorMessage = "Unable to unmarshall response (" + e.getMessage() + "). Response Code: " +
                      httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText();
              throw new KSCClientException(errorMessage, e);
            }
        }

        final KSCServiceException kse = handleErrorResponse(request,
                errorResponseHandler, execParams.apacheRequest, httpResponse,
                execParams.apacheResponse);

        execParams.retriedException = kse;
        return null;
    } finally {
        long handleEndTime = Calendar.getInstance().getTimeInMillis();
        log.info(String
                .format(
                    "http io ok, logid:%s, cmd:%s, server:%s:%d, try_times:%d, code:(%d), msg:%s, io cost:%dms, handle response cost:%dms",
                    request.getRequestId(), request.getResourcePath(),
                    execParams.apacheRequest.getURI().getHost(),
                    execParams.apacheRequest.getURI().getPort(),
                    execParams.getTryTimes(),
                    //errorResponseHandler.stringOfCode(httpResponse.getResponseCode()),
                    httpResponse.getStatusCode(), httpResponse.getStatusText(),
                    ioEndTime - startTime, handleEndTime - ioEndTime));
    }
  }

  /**
   * Sleep for a period of time on failed request to avoid flooding a service
   * with retries.
   *
   * @param originalRequest
   *          The original service request that is being executed.
   * @param previousException
   *          Exception information for the previous attempt, if any.
   * @param requestCount
   *          current request count (including the next attempt after the delay)
   * @param retryPolicy
   *          The retry policy configured in this http client.
   */
  private void pauseBeforeNextRetry(RequestMessage<?> originalRequest,
      KSCClientException previousException, int requestCount,
      RetryStrategy retryPolicy) {
    final int retries = requestCount // including next attempt
    - 1 // number of attempted requests
    - 1; // number of attempted retries

    long delay = retryPolicy.getBackoffStrategy().delayBeforeNextRetry(
        originalRequest, previousException, retries);

    if (log.isDebugEnabled()) {
      log.debug("Retriable error detected, " + "will retry in " + delay
          + "ms, attempt number: " + retries);
    }

    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new KSCClientException(e.getMessage(), e);
    }
  }

  /**
   * Returns true if a failed request should be retried.
   *
   * @param request
   *          The original service request that is being executed.
   * @param method
   *          The current HTTP method being executed.
   * @param exception
   *          The client/service exception from the failed request.
   * @param requestCount
   *          The number of times the current request has been attempted.
   *
   * @return True if the failed request should be retried.
   */
  private boolean shouldRetry(RequestMessage<?> request,
      HttpRequestBase method, KSCClientException exception, int requestCount,
      RetryStrategy retryPolicy) {
    final int retries = requestCount - 1;

    int maxErrorRetry = options.getMaxErrorRetry();

    // We should use the maxErrorRetry in
    // the RetryPolicy if either the user has not explicitly set it in
    // ClientConfiguration, or the RetryPolicy is configured to take
    // higher precedence
    if (maxErrorRetry < 0
        || !retryPolicy.isMaxErrorRetryInClientConfigHonored()) {
      maxErrorRetry = retryPolicy.getMaxErrorRetry();
    }

    // Immediately fails when it has exceeds the max retry count.
    if (retries >= maxErrorRetry)
      return false;

    // Never retry on requests containing non-repeatable entity
    if (method instanceof HttpEntityEnclosingRequest) {
      HttpEntity entity = ((HttpEntityEnclosingRequest) method).getEntity();
      if (entity != null && !entity.isRepeatable()) {
        if (log.isDebugEnabled()) {
          log.debug("Entity not repeatable");
        }
        return false;
      }
    }

    // Pass all the context information to the RetryCondition and let it
    // decide whether it should be retried.
    return retryPolicy.getRetryCondition().shouldRetry(request, exception,
        retries);
  }

  private boolean isRequestSuccessful(org.apache.http.HttpResponse response) {
    int status = response.getStatusLine().getStatusCode();
    return status / 100 == HttpStatus.SC_OK / 100;
  }

  private KSCServiceException handleErrorResponse(RequestMessage<?> request,
      HttpResponseHandler<KSCServiceException> errorResponseHandler,
      HttpRequestBase method, HttpResponse httpResponse,
      final org.apache.http.HttpResponse apacheHttpResponse)
      throws KSCClientException {

    try {
      KSCServiceException exception = errorResponseHandler.handle(httpResponse);
      return exception;
    } catch (Exception e) {
        String errorMessage = "Unable to unmarshall error response ("
                + e.getMessage() + "). Response Code: ";
        throw new KSCClientException(errorMessage, e);
    }
  }
}
