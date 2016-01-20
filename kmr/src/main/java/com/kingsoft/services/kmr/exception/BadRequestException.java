package com.kingsoft.services.kmr.exception;

import com.kingsoft.services.exception.KSCServiceException;

/**
 * <p>
 * A condition specified in the operation could not be evaluated.
 * </p>
 */
public class BadRequestException extends KSCServiceException {
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new ConditionalCheckFailedException with the specified error
   * message.
   * 
   * @param message
   *          Describes the error encountered.
   */
  public BadRequestException(String message) {
    super(message);
  }

}
