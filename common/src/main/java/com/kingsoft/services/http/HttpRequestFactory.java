package com.kingsoft.services.http;

import java.net.URI;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;

import com.kingsoft.services.ClientOptions;
import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.http.impl.RepeatableInputStreamRequestEntity;
import com.kingsoft.services.util.SdkHttpUtils;

/** Responsible for creating Apache HttpClient 4 request objects. */
class HttpRequestFactory {

  private static final String DEFAULT_ENCODING = "UTF-8";

  /**
   * Creates an HttpClient method object based on the specified request and
   * populates any parameters, headers, etc. from the original request.
   *
   * @param request
   *          The request to convert to an HttpClient method object.
   * @param clientConfiguration
   *          The client options of the HTTP client
   *
   * @return The converted HttpClient method object with any parameters,
   *         headers, etc. from the original request set. only for test
   *         simulation
   */
  HttpRequestBase createHttpRequest(RequestMessage<?> request,
      ClientOptions clientConfiguration) {
    URI endpoint = request.getEndpoint();

    /*
     * HttpClient cannot handle url in pattern of "http://host//path", so we
     * have to escape the double-slash between endpoint and resource-path into
     * "/%2F"
     */
    String uri = SdkHttpUtils.appendUri(endpoint.toString(),
        //request.getServiceName() + "." + request.getResourcePath(), true);
          "", true);


    /*
     * For all non-POST requests, and any POST requests that already have a
     * payload, we put the encoded params directly in the URI, otherwise, we'll
     * put them in the POST request's payload.
     */
    HttpRequestBase httpRequest;
    if (request.getHttpMethod() == HttpMethodName.POST) {
      HttpPost postMethod = new HttpPost(uri);

      /*
       * If there isn't any payload content to include in this request, then try
       * to include the POST parameters in the query body, otherwise, just use
       * the query string.
       */
      if (request.getContent() != null) {
        HttpEntity entity = new RepeatableInputStreamRequestEntity(request);
        postMethod.setEntity(entity);

      }
      httpRequest = postMethod;
    } else {
      throw new KSCClientException("We only support post method");
    }

    configureHeaders(httpRequest, request, clientConfiguration);

    return httpRequest;
  }

  /** Configures the headers in the specified Apache HTTP request. */
  private void configureHeaders(HttpRequestBase httpRequest,
      RequestMessage<?> request, ClientOptions clientConfiguration) {
    /*
     * Apache HttpClient omits the port number in the Host header (even if we
     * explicitly specify it) if it's the default port for the protocol in use.
     * To ensure that we use the same Host header in the request and in the
     * calculated string to sign (even if Apache HttpClient changed and started
     * honoring our explicit host with endpoint), we follow this same behavior
     * here and in the QueryString signer.
     */
    URI endpoint = request.getEndpoint();
    String hostHeader = endpoint.getHost();

    hostHeader += ":" + endpoint.getPort();
    httpRequest.addHeader("Host", hostHeader);

    // Copy over any other headers already in our request
    for (Entry<String, String> entry : request.getHeaders().entrySet()) {
      /*
       * HttpClient4 fills in the Content-Length header and complains if it's
       * already present, so we skip it here. We also skip the Host header to
       * avoid sending it twice, which will interfere with some signing schemes.
       */
      if (entry.getKey().equalsIgnoreCase("Content-Length")
          || entry.getKey().equalsIgnoreCase("Host"))
        continue;

      httpRequest.addHeader(entry.getKey(), entry.getValue());
    }

    /* Set content type and encoding */
    if (httpRequest.getHeaders("Content-Type") == null
        || httpRequest.getHeaders("Content-Type").length == 0) {
      httpRequest.addHeader(
          "Content-Type",
          "application/x-www-form-urlencoded; " + "charset="
              + DEFAULT_ENCODING.toLowerCase());
    }

    if (clientConfiguration.getUserAgent() != null)
      httpRequest.addHeader("User-Agent", clientConfiguration.getUserAgent());

  }
}
