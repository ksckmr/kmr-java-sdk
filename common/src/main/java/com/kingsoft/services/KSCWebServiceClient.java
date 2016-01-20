package com.kingsoft.services;

import java.net.URI;
import java.net.URISyntaxException;

import com.kingsoft.services.http.IKSCHttpClient;


public abstract class KSCWebServiceClient {
	protected volatile URI endpoint;

	protected ClientOptions clientConfiguration;

	protected IKSCHttpClient client;
	
	protected KSCWebServiceClient(String endpoint, ClientOptions clientConfiguration, IKSCHttpClient client) {
		this.clientConfiguration = clientConfiguration;
		this.client = client;
		setEndpoint(endpoint);
	}
	
	public void shutdown() {
		client.shutdown();
	}

	private void setEndpoint(String endpoint) throws IllegalArgumentException {
		URI uri = toURI(endpoint);
		synchronized (this) {
			this.endpoint = uri;
		}
	}

	private URI toURI(String endpoint) throws IllegalArgumentException {
		/*
		 * If the endpoint doesn't explicitly specify a protocol to use, then
		 * we'll defer to the default protocol specified in the client
		 * configuration.
		 */
		if (endpoint.contains("://") == false) {
			endpoint = clientConfiguration.getProtocol().toString() + "://"
					+ endpoint;
		}

		try {
			return new URI(endpoint);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
