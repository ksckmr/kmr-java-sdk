package com.kingsoft.services;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage<T> {

	private Map<String, String> metadata;

	/** The result contained by this response */
	private T content;

	private long requestId;

	public ResponseMessage() {
		metadata = new HashMap<String, String>();
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata.clear();
		this.metadata.putAll(metadata);
	}

	public void addMetadata(String name, String value) {
		this.metadata.put(name, value);
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
}
