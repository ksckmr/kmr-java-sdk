package com.kingsoft.services.retry;

import org.apache.http.annotation.Immutable;

import com.kingsoft.services.ClientOptions;
import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.exception.KSCClientException;

/**
 * 客户端可以配置的错误重试策略 {@link ClientOptions}。 这个类是Immutable，因此是线程安全的，可以被多个client同时使用。
 * 
 * @see ClientOptions
 * @see PredefinedRetryStrategy
 */
@Immutable
public final class RetryStrategy {

	/**
	 * 重试条件
	 */
	private final RetryCondition retryCondition;

	/**
	 * 退避策略
	 */
	private final BackoffStrategy backoffStrategy;

	/**
	 * 最大重试次数
	 */
	private final int maxErrorRetry;

	/**
	 * 是否优先使用<i>ClientOptions</i>中的maxErrorRetry配置
	 * 
	 * @see ClientOptions#setMaxErrorRetry(int)
	 */
	private final boolean honorMaxErrorRetryInClientOptions;

	/**
	 * 构造新的重试策略. 参考 {@link PredefinedRetryStrategy} 预定义的重试策略，默认的重试策略
	 * 
	 * @param retryCondition
	 *            重试条件，如果为null,则使用默认的重试条件
	 * @param backoffStrategy
	 *            退避策略，如果为null，则使用默认的退避策略
	 * @param maxErrorRetry
	 *            最大重试次数
	 * @param honorMaxErrorRetryInClientConfig
	 *            是否优先使用<i>ClientOptions</i>中的maxErrorRetry配置
	 * 
	 * @see ClientOptions
	 * @see PredefinedRetryStrategy
	 */
	public RetryStrategy(RetryCondition retryCondition,
			BackoffStrategy backoffStrategy, int maxErrorRetry,
			boolean honorMaxErrorRetryInClientConfig) {
		if (retryCondition == null) {
			retryCondition = PredefinedRetryStrategy.DEFAULT_RETRY_CONDITION;
		}
		if (backoffStrategy == null) {
			backoffStrategy = PredefinedRetryStrategy.DEFAULT_BACKOFF_STRATEGY;
		}
		if (maxErrorRetry < 0) {
			throw new IllegalArgumentException(
					"Please provide a non-negative value for maxErrorRetry.");
		}

		this.retryCondition = retryCondition;
		this.backoffStrategy = backoffStrategy;
		this.maxErrorRetry = maxErrorRetry;
		this.honorMaxErrorRetryInClientOptions = honorMaxErrorRetryInClientConfig;
	};

	/**
	 * 获取当前重试策略中的重试条件
	 * 
	 * @return 重试条件
	 */
	public RetryCondition getRetryCondition() {
		return retryCondition;
	}

	/**
	 * 获取当前重试策略中的退避策略
	 * 
	 * @return 退避策略
	 */
	public BackoffStrategy getBackoffStrategy() {
		return backoffStrategy;
	}

	/**
	 * 获取最大重试次数
	 * 
	 * @return 最大重试次数
	 */
	public int getMaxErrorRetry() {
		return maxErrorRetry;
	}

	/**
	 * 是否优先使用<i>ClientOptions</i>中的最大重试次数
	 * 
	 * @return 是否优先使用<i>ClientOptions</i>中的最大重试次数
	 * @see ClientOptions#setMaxErrorRetry(int)
	 */
	public boolean isMaxErrorRetryInClientConfigHonored() {
		return honorMaxErrorRetryInClientOptions;
	}

	/**
	 * 重试条件
	 */
	public static interface RetryCondition {
		public static final RetryCondition NO_RETRY_CONDITION = new RetryCondition() {
			@Override
			public boolean shouldRetry(RequestMessage<?> originalRequest,
					KSCClientException exception, int retriesAttempted) {
				return false;
			}

		};

		/**
		 * 返回当前请求是否需要重试. 在以下集中情况下，请求不需要重试:
		 * <ul>
		 * <li>达到最大重试次数
		 * <li>请求是不可重复执行的
		 * <li>执行请求时，发生了RuntimeException或者Error
		 * </ul>
		 * 
		 * @param originalRequest
		 *            当前请求
		 * @param exception
		 * @param retriesAttempted
		 *            当前请求已经尝试的次数
		 * 
		 * @return 如果需要重试，则返回True，否则False
		 */
		public boolean shouldRetry(RequestMessage<?> originalRequest,
				KSCClientException exception, int retriesAttempted);
	}

	/**
	 * 退避策略
	 */
	public static interface BackoffStrategy {
		public static final BackoffStrategy NO_DELAY = new BackoffStrategy() {
			@Override
			public long delayBeforeNextRetry(RequestMessage<?> originalRequest,
					KSCClientException exception, int retriesAttempted) {
				return 0;
			}
		};

		/**
		 * 返回进行下一次重试之前的延迟时间(毫秒)
		 * 
		 * @param originalRequest
		 *            当前请求
		 * @param exception
		 * @param retriesAttempted
		 *            当前请求已经尝试的次数
		 * 
		 * @return 进行下一次重试之前的延迟时间(毫秒)
		 */
		public long delayBeforeNextRetry(RequestMessage<?> originalRequest,
				KSCClientException exception, int retriesAttempted);
	}
}
