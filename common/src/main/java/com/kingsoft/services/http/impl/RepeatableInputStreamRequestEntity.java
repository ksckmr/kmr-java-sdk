package com.kingsoft.services.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.InputStreamEntity;

import com.kingsoft.services.HttpHeaders;
import com.kingsoft.services.RequestMessage;

public class RepeatableInputStreamRequestEntity extends BasicHttpEntity {

	/** True if the request entity hasn't been written out yet */
	private boolean firstAttempt = true;

	/** The underlying InputStreamEntity being delegated to */
	private InputStreamEntity inputStreamRequestEntity;

	/** The InputStream containing the content to write out */
	private InputStream content;

	private static final Log log = LogFactory
			.getLog(RepeatableInputStreamRequestEntity.class);

	/**
	 * Record the original exception if we do attempt a retry, so that if the
	 * retry fails, we can report the original exception. Otherwise, we're most
	 * likely masking the real exception with an error about not being able to
	 * reset far enough back in the input stream.
	 */
	private IOException originalException;

	public RepeatableInputStreamRequestEntity(final RequestMessage<?> request) {
		setChunked(false);

		/*
		 * If we don't specify a content length when we instantiate our
		 * InputStreamRequestEntity, then HttpClient will attempt to buffer the
		 * entire stream contents into memory to determine the content length.
		 * 
		 * TODO: It'd be nice to have easier access to content length and
		 * content type from the request, instead of having to look directly
		 * into the headers.
		 */
		long contentLength = -1;
		try {
			String contentLengthString = request.getHeaders().get(
					HttpHeaders.CONTENT_LENGTH);
			if (contentLengthString != null) {
				contentLength = Long.parseLong(contentLengthString);
			} else {
				throw new IllegalStateException(String.format(
						"can not find %s header", HttpHeaders.CONTENT_LENGTH));
			}
		} catch (NumberFormatException nfe) {
			log.error("Unable to parse content length from request.  "
					+ "Buffering contents in memory.");
			throw nfe;
		}

		String contentType = request.getHeaders().get("Content-Type");

		inputStreamRequestEntity = new InputStreamEntity(request.getContent(),
				contentLength);

		inputStreamRequestEntity.setContentType(contentType);
		content = request.getContent();

		setContent(content);
		setContentType(contentType);
		setContentLength(contentLength);
	}

	@Override
	public boolean isChunked() {
		return false;
	}


	@Override
	public boolean isRepeatable() {
		return content.markSupported()
				|| inputStreamRequestEntity.isRepeatable();
	}


	@Override
	public void writeTo(OutputStream output) throws IOException {
		try {
			if (!firstAttempt && isRepeatable())
				content.reset();

			firstAttempt = false;
			inputStreamRequestEntity.writeTo(output);
		} catch (IOException ioe) {
			if (originalException == null)
				originalException = ioe;
			throw originalException;
		}
	}

}
