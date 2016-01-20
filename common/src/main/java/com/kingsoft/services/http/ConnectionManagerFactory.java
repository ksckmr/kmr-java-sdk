package com.kingsoft.services.http;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;

import com.kingsoft.services.ClientOptions;

/**
 * Responsible for creating and configuring instances of Apache HttpClient4's
 * Connection Manager.
 */
class ConnectionManagerFactory {

  public static PoolingClientConnectionManager createPoolingClientConnManager(
      ClientOptions config, HttpParams httpClientParams) {
    PoolingClientConnectionManager connectionManager = new PoolingClientConnectionManager(
        SchemeRegistryFactory.createDefault(), -1,
        TimeUnit.MILLISECONDS);
    connectionManager.setDefaultMaxPerRoute(config.getMaxConnections());
    connectionManager.setMaxTotal(config.getMaxConnections());
    IdleConnectionReaper.registerConnectionManager(connectionManager);
    return connectionManager;
  }
}
