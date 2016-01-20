package com.kingsoft.services.http;

import java.io.IOException;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import com.kingsoft.services.ClientOptions;

/** Responsible for creating and configuring instances of Apache HttpClient4. */
class HttpClientFactory {
  public static class HttpRequestNoRetryHandler extends
      DefaultHttpRequestRetryHandler {
    public static final HttpRequestNoRetryHandler Singleton = new HttpRequestNoRetryHandler();

    private HttpRequestNoRetryHandler() {
    }

    @Override
    public boolean retryRequest(final IOException exception,
        int executionCount, final HttpContext context) {
      return false;
    }
  }

  public HttpClient createHttpClient(ClientOptions config) {
    /* Set HTTP client parameters */
    HttpParams httpClientParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(httpClientParams,
        config.getConnectionTimeout());
    HttpConnectionParams.setSoTimeout(httpClientParams,
        config.getSocketTimeout());
    HttpConnectionParams.setStaleCheckingEnabled(httpClientParams, true);
    HttpConnectionParams.setTcpNoDelay(httpClientParams, true);
    HttpConnectionParams.setSoKeepalive(httpClientParams,
        config.useTcpKeepAlive());

    PoolingClientConnectionManager connectionManager = ConnectionManagerFactory
        .createPoolingClientConnManager(config, httpClientParams);
    DefaultHttpClient httpClient = new DefaultHttpClient(connectionManager,
        httpClientParams);
    httpClient.setHttpRequestRetryHandler(HttpRequestNoRetryHandler.Singleton);
    httpClient.setRedirectStrategy(new NeverFollowRedirectStrategy());

    return httpClient;
  }

  /**
   * Disable http redirect inside Apache HttpClient.
   */
  private static final class NeverFollowRedirectStrategy implements
      RedirectStrategy {

    @Override
    public boolean isRedirected(HttpRequest request, HttpResponse response,
        HttpContext context) throws ProtocolException {
      return false;
    }

    @Override
    public HttpUriRequest getRedirect(HttpRequest request,
        HttpResponse response, HttpContext context) throws ProtocolException {
      return null;
    }

  }

}
