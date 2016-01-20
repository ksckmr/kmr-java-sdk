package com.kingsoft.services.exception;


/**
 * KSC Exception基类，调用服务过程中抛出的任何exception都将继承此类
 * 
 * 其有一个子类KSCServiceExceptions，
 * 我们会根据服务器端返回的错误码来生成对应的KSCServiceExceptions。
 * 如果是服务器不可达或者无响应，将返回KSCClientException。
 * 
 * @see KSCServiceException
 */
public class KSCClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public KSCClientException(String message, Throwable t) {
		super(message + " Inner Exception:" + t == null ? "" : t.getMessage(),
				t);
	}
	
	public KSCClientException(String message) {
		super(message);
	}

	public KSCClientException(Throwable t) {
		super(t);
	}

	public boolean isRetryable() {
		return true;
	}
}
