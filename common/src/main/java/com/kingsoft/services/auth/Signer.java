package com.kingsoft.services.auth;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.kingsoft.services.HttpHeaders;
import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.internal.SdkDigestInputStream;
import com.kingsoft.services.util.BinaryUtils;
import com.kingsoft.services.util.DateUtils;
import static com.kingsoft.services.util.StringUtils.UTF8;

public class Signer {

	public static final String KSC_SIGNING_ALGORITHM = "KSC4-HMAC-SHA256";
	public static final String LINE_SEPARATOR = "\n";

	private static String SERVICENAME = "KMR";
	private static String REQTYPE = "KMR_REQ";
	private static String HASHKEYWORD = "KSC4";

	private static Map<String, String> hostToRegionMap = new HashMap<String, String>(){
		{
			put("kmr-cn-beijing.ksyun.com ", "cn-beijing");
		}
	};

	public static void sign(RequestMessage<?> request) {
		String host = request.getEndpoint().getHost();
		int port = request.getEndpoint().getPort();
		request.addHeader(HttpHeaders.HOST, host + ":" + port);

		long signingDateTimeMilli = getSigningDate();
		String formattedSigningDateTime = DateUtils.formatTimestamp(signingDateTimeMilli);
		request.addHeader(HttpHeaders.REQUEST_DATE, formattedSigningDateTime);

		String timestamp = DateUtils.formatDateStamp(signingDateTimeMilli);
		String regionName = parseRegionName(host);
		String scope = generateScope(timestamp, SERVICENAME, regionName, REQTYPE);

		String signedHeaders = getSignedHeadersString(request);

		final String canonicalRequest = createCanonicalRequest(request);

		final String stringToSign = createStringToSign(request,
				canonicalRequest, scope);

		byte[] signKey = newSigningKey(request.getCredentials(), timestamp, regionName);
		byte[] signature_byte = sign(stringToSign.getBytes(Charset.forName("UTF-8")), signKey,
				SigningAlgorithm.HmacSHA256);

		String signature = BinaryUtils.toHex(signature_byte);

		request.addHeader(
				HttpHeaders.AUTHORIZATION,
				buildAuthorizationHeader(signedHeaders, signature,
						request.getCredentials(), scope));
	}

	public static byte[] sign(String stringData, byte[] key,
					   SigningAlgorithm algorithm) throws KSCClientException {
		try {
			byte[] data = stringData.getBytes(UTF8);
			return sign(data, key, algorithm);
		} catch (Exception e) {
			throw new KSCClientException(
					"Unable to calculate a request signature: "
							+ e.getMessage(), e);
		}
	}

	protected static byte[] sign(byte[] data, byte[] key,
						  SigningAlgorithm algorithm) throws KSCClientException {
		try {
			Mac mac = Mac.getInstance(algorithm.toString());
			mac.init(new SecretKeySpec(key, algorithm.toString()));
			return mac.doFinal(data);
		} catch (Exception e) {
			throw new KSCClientException(
					"Unable to calculate a request signature: "
							+ e.getMessage(), e);
		}
	}

	private static byte[] newSigningKey(KSCCredentials credentials,
										String timestamp, String regionName) {
		byte[] kSecret = (HASHKEYWORD + credentials.getSecretKey())
				.getBytes(Charset.forName("UTF-8"));
		byte[] kDate = sign(timestamp, kSecret, SigningAlgorithm.HmacSHA256);
		byte[] kRegion = sign(regionName, kDate, SigningAlgorithm.HmacSHA256);
		byte[] kService = sign(SERVICENAME, kRegion,
				SigningAlgorithm.HmacSHA256);
		return sign(REQTYPE, kService, SigningAlgorithm.HmacSHA256);
	}

	/**
	 * Creates the authorization header to be included in the request.
	 */
	private static String buildAuthorizationHeader(String signedHeaders,
			String signature, KSCCredentials credentials, String scope) {
		final String signingCredentials = credentials.getAccessKeyId()
				+ "/" + scope;

		final String credential = "Credential=" + signingCredentials;
		final String signerHeaders = "SignedHeaders=" + signedHeaders;
		final String signatureHeader = "Signature="
				+ signature;

		final StringBuilder authHeaderBuilder = new StringBuilder();

		authHeaderBuilder.append(KSC_SIGNING_ALGORITHM).append(" ")
				.append(credential).append(", ").append(signerHeaders)
				.append(", ").append(signatureHeader);

		return authHeaderBuilder.toString();
	}


	private static String createStringToSign(RequestMessage<?> request,
			String canonicalRequest, String scope) {
		StringBuilder str = new StringBuilder();

		str.append(KSC_SIGNING_ALGORITHM);
		str.append(LINE_SEPARATOR);

		String date = request.getHeaders().get(HttpHeaders.REQUEST_DATE);
		str.append(date);
		str.append(LINE_SEPARATOR);

		str.append(scope);
		str.append(LINE_SEPARATOR);

		str.append(BinaryUtils.toHex(hash(canonicalRequest)));

		return str.toString();
	}

	private static final long getSigningDate() {
		return System.currentTimeMillis();
	}



	private static String createCanonicalRequest(RequestMessage<?> request) {
		StringBuilder canonicalRequest = new StringBuilder();

		// HTTPRequestMethod
		canonicalRequest.append(request.getHttpMethod());
		canonicalRequest.append(LINE_SEPARATOR);

		// CanonicalURI
		canonicalRequest.append("/");
		canonicalRequest.append(LINE_SEPARATOR);

		// CanonicalQueryString
		canonicalRequest.append("");

		canonicalRequest.append(LINE_SEPARATOR);

		// CanonicalHeaders
		canonicalRequest.append(getCanonicalizedHeaderString(request));
		canonicalRequest.append(LINE_SEPARATOR);

		// SignedHeaders
		canonicalRequest.append(getSignedHeadersString(request));
		canonicalRequest.append(LINE_SEPARATOR);

		canonicalRequest.append(calculateContentHash(request));

		return canonicalRequest.toString();
	}


	public static String parseRegionName(final String host) {

		if (host == null) {
			throw new IllegalArgumentException("hostname cannot be null");
		}

		for (String mapping : hostToRegionMap.keySet()) {
			if (host.matches(mapping)) {
				return hostToRegionMap.get(host);
			}
		}

		// Endpoint is totally non-standard; guess cn-beijing for lack of a
		// better option.

		return "cn-beijing";
	}


	private static String generateScope(String dateStamp, String serviceName,
										String regionName, String reqType) {
		final StringBuilder scopeBuilder = new StringBuilder();
		return scopeBuilder.append(dateStamp).append("/").append(regionName)
				.append("/").append(serviceName).append("/")
				.append(reqType).toString();
	}

	protected static String calculateContentHash(RequestMessage<?> request) {
		InputStream payloadStream = request.getContent();
		payloadStream.mark(-1);

		String contentSha256 = BinaryUtils.toHex(hash(payloadStream));
		try {
			payloadStream.reset();
		} catch (IOException e) {
			throw new KSCClientException(
					"Unable to reset stream after calculating signature",
					e);
		}
		return contentSha256;
	}

	protected static byte[] hash(InputStream input) throws KSCClientException {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			@SuppressWarnings("resource")
			DigestInputStream digestInputStream = new SdkDigestInputStream(
					input, md);
			byte[] buffer = new byte[1024];
			while (digestInputStream.read(buffer) > -1)
				;
			return digestInputStream.getMessageDigest().digest();
		} catch (Exception e) {
			throw new KSCClientException(
					"Unable to compute hash while signing request: "
							+ e.getMessage(), e);
		}
	}


	private static byte[] hash(byte[] data) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			return md.digest(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static byte[] hash(String data) {
		try {
			return hash(data.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	protected static String getCanonicalizedHeaderString(
			RequestMessage<?> request) {
		final List<String> sortedHeaders = new ArrayList<String>(request
				.getHeaders().keySet());
		Collections.sort(sortedHeaders, String.CASE_INSENSITIVE_ORDER);

		final Map<String, String> requestHeaders = request.getHeaders();
		StringBuilder buffer = new StringBuilder();
		for (String header : sortedHeaders) {
			String key = header.toLowerCase().replaceAll("\\s+", " ");
			String value = requestHeaders.get(header);

			buffer.append(key).append(":");
			if (value != null) {
				buffer.append(value.replaceAll("\\s+", " "));
			}

			buffer.append("\n");
		}

		return buffer.toString();
	}

	protected static String getSignedHeadersString(RequestMessage<?> request) {
		final List<String> sortedHeaders = new ArrayList<String>(request
				.getHeaders().keySet());
		Collections.sort(sortedHeaders, String.CASE_INSENSITIVE_ORDER);

		StringBuilder buffer = new StringBuilder();
		for (String header : sortedHeaders) {
			if (buffer.length() > 0)
				buffer.append(";");
			buffer.append(header.toLowerCase());
		}
		return buffer.toString();
	}

	public enum SigningAlgorithm {
		HmacSHA256;
	}
}
