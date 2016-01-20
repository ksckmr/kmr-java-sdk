package com.kingsoft.services.handlers;

import com.kingsoft.services.RequestMessage;

/**
 * Callback interface for notification on web service requests executed with the
 * asynchronous clients in the KSC SDK for Java.
 */
public interface AsyncHandler<REQUEST extends RequestMessage, RESULT> {

	/**
	 * Invoked after an asynchronous request 
	 * @param exception
	 */
	public void onError(Exception exception);

	/**
	 * Invoked after an asynchronous request has completed successfully. Callers
	 * have access to the original request object and the returned response
	 * object.
	 *
	 * @param request
	 *            The initial request created by the caller
	 * @param result
	 *            The successful result of the executed operation.
	 */
	public void onSuccess(REQUEST request, RESULT result);

}
