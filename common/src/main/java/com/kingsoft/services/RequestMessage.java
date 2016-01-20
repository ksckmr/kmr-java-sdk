package com.kingsoft.services;

import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.annotation.NotThreadSafe;

import com.kingsoft.services.auth.KSCCredentials;
import com.kingsoft.services.http.HttpMethodName;

@NotThreadSafe
public class RequestMessage<T> implements  Cloneable {

	/** The resource path being requested */
	private String resourcePath;

	/** Map of the headers included in this request */
	private Map<String, String> headers = new HashMap<String, String>();

	/** The service endpoint to which this request should be sent */
	private URI endpoint;

	private long requestId;

	private KSCCredentials credentials;

	//private Class<?> responseMessageType;

	/** The name of the service to which this request is being sent */
	private String serviceName;

	/** The HTTP method to use when sending this request. */
	private HttpMethodName httpMethod = HttpMethodName.POST;

	private InputStream content;
/*
	public Class<?> getResponseMeesageType() {
		return responseMessageType;
	}

	public void setResponseMeesageType(Class<?> responseMessageType) {
		this.responseMessageType = responseMessageType;
	}
*/
	public KSCCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(KSCCredentials credentials) {
		this.credentials = credentials;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void addHeader(String name, String value) {
		headers.put(name, value);
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers.clear();
		this.headers.putAll(headers);
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public HttpMethodName getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(HttpMethodName httpMethod) {
		this.httpMethod = httpMethod;
	}

	public URI getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(URI endpoint) {
		this.endpoint = endpoint;
	}

	public String getServiceName() {
		return serviceName;
	}

	public InputStream getContent() {
		return content;
	}

	public void setContent(InputStream content) {
		this.content = content;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	@Override
	public RequestMessage clone() {
		try {
			RequestMessage cloned = (RequestMessage) super.clone();
			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(
					"Got a CloneNotSupportedException from Object.clone() "
							+ "even though we're Cloneable!",
					e);
		}
	}
}
