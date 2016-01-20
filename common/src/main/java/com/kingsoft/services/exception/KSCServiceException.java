package com.kingsoft.services.exception;

/**
 * 继承自 KSCClientException，我们会根据服务器端返回的错误码来生成对应的KSCServiceExceptions。
 * 如果是服务器不可达或者无响应，将返回KSCClientException。
 */
public class KSCServiceException extends KSCClientException {
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMsg;
	private String errorName;

	private int httpCode;

	public KSCServiceException(String errorMessage) {
		super(errorMessage);
	}

	public KSCServiceException(String errorMessage, Exception cause) {
		super(errorMessage, cause);

	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setHttpCode(int httpcode) {
		this.httpCode = httpcode;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("ErrorMsg: "
				+ (this.getErrorMsg() == null ? "null" : this.getErrorMsg())
				+ ",");
		sb.append("ErrorCode: " + this.getErrorCode() + ",");

		sb.append("ErrorName: " + this.getErrorName());
		sb.append("}");

		return sb.toString();
	}

}
