package com.kingsoft.services.retry;

import java.io.IOException;

import org.apache.http.HttpStatus;

import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.exception.KSCServiceException;

/**
 * 预定义的重试策略, 包括了被SDK使用的默认重试策略
 */
public class PredefinedRetryStrategy {

	/** 不重试策略 **/
	public static final RetryStrategy NO_RETRY_POLICY = new RetryStrategy(
			RetryStrategy.RetryCondition.NO_RETRY_CONDITION,
			RetryStrategy.BackoffStrategy.NO_DELAY, 0, // maxErrorRetry
			false); // honorMaxErrorRetryInClientConfig

	/* SDK默认重试策略 */

	/** 默认的最大重试次数 **/
	public static final int DEFAULT_MAX_ERROR_RETRY = 5;

	/* 可重用的重试策略组件 */

	/**
	 * SDK默认的重试条件, 检查各种条件的顺序如下:
	 * <ul>
	 * <li>对不可重复执行的请求，不能重试;
	 * <li>对于IOException，则需要重试;
	 * <li>对于ServiceException，比如500 internal server errors, 503 service
	 * unavailable errors, service throttling errors or clock skew errors, 需要重试;
	 * </ul>
	 */
	public static final RetryStrategy.RetryCondition DEFAULT_RETRY_CONDITION = new SDKDefaultRetryCondition();

	/**
	 * SDK默认的退避策略, 会根据重试次数指数级退避.
	 */
	public static final RetryStrategy.BackoffStrategy DEFAULT_BACKOFF_STRATEGY = new DefaultBackoffStrategy();

	/** 默认的重试策略 **/
	public static final RetryStrategy DEFAULT = new RetryStrategy(
			DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY,
			DEFAULT_MAX_ERROR_RETRY, true);

	/**
	 * SDK默认的重试条件, 检查各种条件的顺序如下:
	 * <ul>
	 * <li>对不可重复执行的请求，不能重试;
	 * <li>对于IOException，则需要重试;
	 * <li>对于ServiceException，比如500 internal server errors, 503 service
	 * unavailable errors, service throttling errors or clock skew errors, 需要重试;
	 * </ul>
	 */
	public static class SDKDefaultRetryCondition implements
			RetryStrategy.RetryCondition {

		@Override
		public boolean shouldRetry(RequestMessage<?> originalRequest,
				KSCClientException exception, int retriesAttempted) {

			if (exception == null)
				return false;

			// Always retry on client exceptions caused by IOException
			if (exception.getCause() != null
					&& exception.getCause() instanceof IOException)
				return true;

			// Only retry on a subset of service exceptions
			if (exception instanceof KSCServiceException) {
				KSCServiceException ase = (KSCServiceException) exception;

				/*
				 * For 500 internal server errors and 503 service unavailable
				 * errors, we want to retry, but we need to use an exponential
				 * back-off strategy so that we don't overload a server with a
				 * flood of retries.
				 */
				if (ase.getHttpCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR
						|| ase.getHttpCode() == HttpStatus.SC_SERVICE_UNAVAILABLE) {
					return true;
				}

			}

			return false;
		}

	}

	/**
	 * 
	 * SDK默认的退避策略, 会根据重试次数指数级退避
	 * 
	 **/
	private static class DefaultBackoffStrategy implements
			RetryStrategy.BackoffStrategy {

		/** 基本sleep time (毫秒) **/
		private static final int SCALE_FACTOR = 300;

		/** 最大的指数级退避时间(毫秒) */
		private static final int MAX_BACKOFF_IN_MILLISECONDS = 20 * 1000;

		/**
		 * 最大的退避次数 = log_2(MAX_BACKOFF_IN_MILLISECONDS / SCALE_FACTOR)
		 * 
		 */
		private static final int MAX_RETRIES_BEFORE_MAX_BACKOFF = 9;

		@Override
		public final long delayBeforeNextRetry(
				RequestMessage<?> originalRequest,
				KSCClientException exception, int retriesAttempted) {
			if (retriesAttempted < 0)
				return 0;
			if (retriesAttempted > MAX_RETRIES_BEFORE_MAX_BACKOFF)
				return MAX_BACKOFF_IN_MILLISECONDS;

			long delay = (1L << retriesAttempted) * SCALE_FACTOR;
			delay = Math.min(delay, MAX_BACKOFF_IN_MILLISECONDS);

			return delay;
		}
	}
}
