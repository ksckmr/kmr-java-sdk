package com.kingsoft.services.auth;

/**
 * Provides access to the KSC credentials used for accessing KSC services: KSC
 * access key ID and secret access key. These credentials are used to securely
 * sign requests to KSC services.
 */
public interface KSCCredentials {

  /**
   * Returns the KSC access key ID for this credentials object.
   * 
   * @return The KSC access key ID for this credentials object.
   */
  public String getAccessKeyId();

  /**
   * Returns the KSC secret access key for this credentials object.
   * 
   * @return The KSC secret access key for this credentials object.
   */
  public String getSecretKey();

}
