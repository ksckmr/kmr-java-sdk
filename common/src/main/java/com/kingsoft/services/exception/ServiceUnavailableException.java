package com.kingsoft.services.exception;

public class ServiceUnavailableException extends KSCClientException {
  private static final long serialVersionUID = 1L;

  public ServiceUnavailableException(String message, Throwable t) {
    super(message, t);
  }

  public ServiceUnavailableException(String message) {
    super(message);
  }
}
