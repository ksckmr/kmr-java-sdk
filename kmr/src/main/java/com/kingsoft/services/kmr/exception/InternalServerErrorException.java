package com.kingsoft.services.kmr.exception;

import com.kingsoft.services.exception.KSCServiceException;

/**
 * <p>
 * An error occurred on the server side.
 * </p>
 */
public class InternalServerErrorException extends KSCServiceException {
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new InternalServerErrorException with the specified error
   * message.
   * 
   * @param message
   *          Describes the error encountered.
   */
  public InternalServerErrorException(String message) {
    super(message);
  }

}
