package com.kingsoft.services.kmr.exception;

import com.kingsoft.services.exception.KSCServiceException;

/**
 * <p>
 * The operation tried to access a nonexistent table or index. The resource
 * might not be specified correctly, or its status might not be
 * <code>ACTIVE</code> .
 * </p>
 */
public class NotFoundException extends KSCServiceException {
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new ResourceNotFoundException with the specified error
   * message.
   * 
   * @param message
   *          Describes the error encountered.
   */
  public NotFoundException(String message) {
    super(message);
  }

}
