package com.kingsoft.services.kmr.exception;

import com.kingsoft.services.exception.KSCServiceException;

public class AccessDeniedException extends KSCServiceException {
  private static final long serialVersionUID = 1L;

  public AccessDeniedException(String message) {
    super(message);
  }
}
