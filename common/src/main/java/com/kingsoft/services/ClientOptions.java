/*
 * Copyright (c) 2015 KingSoft.com, Inc. All Rights Reserved
 *
 */
package com.kingsoft.services;

import org.apache.http.annotation.NotThreadSafe;

import com.kingsoft.services.retry.PredefinedRetryStrategy;
import com.kingsoft.services.retry.RetryStrategy;

/**
 * <p>
 * 访问金山云服务的客户端配置.
 * </p>
 */
@NotThreadSafe
public class ClientOptions {
	/** 默认的建立HTTP连接的超时时间，单位（豪秒） */
	public static final int DEFAULT_CONNECTION_TIMEOUT = 1 * 1000;

	/** 连接上默认的数据传输时间，单位（豪秒） */
	public static final int DEFAULT_SOCKET_TIMEOUT = 60 * 1000;

	/** 默认的最大连接数。 */
	public static final int DEFAULT_MAX_CONNECTIONS = 50;

	/** 默认的user agent header */
	public static final String DEFAULT_USER_AGENT = "IE";

	/** 默认的重试策略：最多3次重试，默认的重试条件和默认的退避策略 */
	public static final RetryStrategy DEFAULT_RETRY_POLICY = PredefinedRetryStrategy.DEFAULT;

	/** 默认是否开启TCP KeepAlive。 */
	public static final boolean DEFAULT_TCP_KEEP_ALIVE = true;

	/** HTTP请求的用户代理。 */
	private String userAgent = DEFAULT_USER_AGENT;

	/** 可重试的请求失败后的最大重试次数 不设置的化，默认值就是－1，就会使用配置的重试策略中的最大重试次数 */
	private int maxErrorRetry = -1;

	/** 重试策略 */
	private RetryStrategy retryStrategy = DEFAULT_RETRY_POLICY;

	/** 最大允许打开的HTTP连接数。 */
	private int maxConnections = DEFAULT_MAX_CONNECTIONS;

	/** 连接上的数据传输超时时间（单位：毫秒），0表示无限，不推荐使用。 */
	private int socketTimeout = DEFAULT_SOCKET_TIMEOUT;

	/** 建立连接的超时时间（单位：毫秒），0表示无限，不推荐使用。 */
	private int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;

	/** 是否开启TCP KeepAlive。 */
	private boolean tcpKeepAlive = DEFAULT_TCP_KEEP_ALIVE;

	/** http协议，目前只支持http */
	private String protocol = "http";

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * 返回允许打开的最大HTTP连接数。
	 * 
	 * @return 最大HTTP连接数。
	 */
	public int getMaxConnections() {
		return maxConnections;
	}

	/**
	 * 设置允许打开的最大HTTP连接数。
	 * 
	 * @param maxConnections
	 *            最大HTTP连接数。
	 */
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	/**
	 * 设置允许打开的最大HTTP连接数。
	 * 
	 * @param maxConnections
	 *            最大HTTP连接数。
	 * @return 更新后的ClientOptions对象。
	 */
	public ClientOptions withMaxConnections(int maxConnections) {
		setMaxConnections(maxConnections);
		return this;
	}

	/**
	 * 返回用户代理。
	 * 
	 * @return 用户代理。
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * 设置用户代理。
	 * 
	 * @param userAgent
	 *            用户代理。
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * 设置用户代理，然后返回更新后的ClientOptions。
	 * 
	 * @param userAgent
	 *            。
	 * @return 更新后的ClientOptions。
	 */
	public ClientOptions withUserAgent(String userAgent) {
		setUserAgent(userAgent);
		return this;
	}

	/**
	 * 获取请求失败后的最大重试次数。
	 * 
	 * @return 请求失败后最大的重试的次数。
	 */
	public int getMaxErrorRetry() {
		return maxErrorRetry;
	}

	/**
	 * 设置请求失败后的最大重试次数。
	 * 
	 * @param maxErrorRetry
	 *            请求失败后最大的重试次数。
	 */
	public void setMaxErrorRetry(int maxErrorRetry) {
		if (maxErrorRetry < 0) {
			throw new IllegalArgumentException(
					"maxErrorRetry shoud be non-negative");
		}
		this.maxErrorRetry = maxErrorRetry;
	}

	/**
	 * 设置请求失败后的最大重试次数。
	 * 
	 * @param maxErrorRetry
	 *            请求失败后最大的重试次数。
	 * @return 更新后的ClientOptions。
	 */
	public ClientOptions withMaxRetryTimes(int maxErrorRetry) {
		this.setMaxErrorRetry(maxErrorRetry);
		return this;
	}

	/**
	 * 获取通过打开的连接传输数据的超时时间（单位：毫秒）， 0 表示无限等待。
	 * 
	 * @return 通过打开的连接传输数据的超时时间（单位：毫秒）。
	 */
	public int getSocketTimeout() {
		return socketTimeout;
	}

	/**
	 * 设置通过打开的连接传输数据的超时时间（单位：毫秒），0表示无限等待。
	 * 
	 * @param socketTimeout
	 *            通过打开的连接传输数据的超时时间（单位：毫秒）
	 */
	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	/**
	 * 设置通过打开的连接传输数据的超时时间（单位：毫秒），0表示无限等待。
	 * 
	 * @param socketTimeout
	 *            通过打开的连接传输数据的超时时间（单位：毫秒）
	 * @return 更新后的ClientOptions。
	 */
	public ClientOptions withSocketTimeout(int socketTimeout) {
		setSocketTimeout(socketTimeout);
		return this;
	}

	/**
	 * 获取建立连接的超时时间（单位：毫秒）。
	 * 
	 * @return 建立连接的超时时间（单位：毫秒）。
	 */
	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * 设置建立连接的超时时间（单位：毫秒）。
	 * 
	 * @param connectionTimeout
	 *            建立连接的超时时间（单位：毫秒）。
	 */
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * 设置建立连接的超时时间（单位：毫秒）。
	 * 
	 * @param connectionTimeout
	 *            建立连接的超时时间（单位：毫秒）。
	 * @return 更新后的ClientOptions。
	 */
	public ClientOptions withConnectionTimeout(int connectionTimeout) {
		setConnectionTimeout(connectionTimeout);
		return this;
	}

	/**
	 * 获取是否支持TCP KeepAlive。
	 * 
	 * @return 是否支持TCP KeepAlive。
	 */
	public boolean useTcpKeepAlive() {
		return tcpKeepAlive;
	}

	/**
	 * 设置是否开启TCP KeepAlive。
	 * 
	 * @param use
	 *            是否开启TCP KeepAlive。
	 */
	public void setUseTcpKeepAlive(boolean use) {
		this.tcpKeepAlive = use;
	}

	/**
	 * 设置是否开启TCP KeepAlive。
	 * 
	 * @param use
	 *            是否开启TCP KeepAlive。
	 * @return 更新后的ClientOptions。
	 */
	public ClientOptions withTcpKeepAlive(boolean use) {
		setUseTcpKeepAlive(use);
		return this;
	}

	/**
	 * 获取重试策略
	 * 
	 * @return 重试策略
	 */
	public RetryStrategy getRetryStrategy() {
		return retryStrategy;
	}

	/**
	 * 设置重试策略
	 * 
	 * @param retryStrategy
	 *            重试策略
	 */
	public void setRetryStrategy(RetryStrategy retryStrategy) {
		this.retryStrategy = retryStrategy;
	}

	/**
	 * 设置重试策略
	 * 
	 * @param retryStrategy
	 *            重试策略
	 * @return 更新后的ClientOptions
	 */
	public ClientOptions withRetryStrategy(RetryStrategy retryStrategy) {
		setRetryStrategy(retryStrategy);
		return this;
	}
}
