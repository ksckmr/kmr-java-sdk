package com.kingsoft.services.http;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpRequestBase;

import com.kingsoft.services.RequestMessage;

/**
 * Represents an HTTP response returned by an KSC service in response to a
 * service request.
 */
public class HttpResponse {

	private final RequestMessage<?> request;
	private final HttpRequestBase httpRequest;

	private int statusCode;
	private String statusText;
	private int responseCode;

	private InputStream content;
	private Map<String, String> headers = new HashMap<String, String>();

	/**
	 * Constructs a new HttpResponse associated with the specified request.
	 * 
	 * @param request
	 *            The associated request that generated this response.
	 * @param httpRequest
	 *            The underlying http request that generated this response.
	 */
	public HttpResponse(RequestMessage<?> request, HttpRequestBase httpRequest) {
		this.request = request;
		this.httpRequest = httpRequest;
	}

	/**
	 * Returns the original request associated with this response.
	 *
	 * @return The original request associated with this response.
	 */
	public RequestMessage<?> getRequest() {
		return request;
	}

	/**
	 * Returns the original http request associated with this response.
	 *
	 * @return The original http request associated with this response.
	 */
	public HttpRequestBase getHttpRequest() {
		return httpRequest;
	}

	/**
	 * Returns the HTTP headers returned with this response.
	 *
	 * @return The set of HTTP headers returned with this HTTP response.
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * Adds an HTTP header to the set associated with this response.
	 *
	 * @param name
	 *            The name of the HTTP header.
	 * @param value
	 *            The value of the HTTP header.
	 */
	public void addHeader(String name, String value) {
		headers.put(name, value);
	}

	/**
	 * Sets the input stream containing the response content.
	 *
	 * @param content
	 *            The input stream containing the response content.
	 */
	public void setContent(InputStream content) {
		this.content = content;
	}

	/**
	 * Returns the input stream containing the response content.
	 *
	 * @return The input stream containing the response content.
	 */
	public InputStream getContent() {
		return content;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public int getResponseCode() {
		return this.responseCode;
	}

	/**
	 * Sets the HTTP status code that was returned with this response.
	 *
	 * @param statusCode
	 *            The HTTP status code (ex: 200, 404, etc) associated with this
	 *            response.
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Returns the HTTP status code (ex: 200, 404, etc) associated with this
	 * response.
	 *
	 * @return The HTTP status code associated with this response.
	 */
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getStatusText() {
		return statusText;
	}

	public long getRequestId() {
		return request.getRequestId();
	}
}
