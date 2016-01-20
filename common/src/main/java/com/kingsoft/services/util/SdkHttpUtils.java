package com.kingsoft.services.util;

import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.http.HttpMethodName;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SdkHttpUtils {

  private static final String DEFAULT_ENCODING = "UTF-8";

  /**
   * Regex which matches any of the sequences that we need to fix up after
   * URLEncoder.encode().
   */
  private static final Pattern ENCODED_CHARACTERS_PATTERN;
  static {
    StringBuilder pattern = new StringBuilder();

    pattern.append(Pattern.quote("+")).append("|").append(Pattern.quote("*"))
        .append("|").append(Pattern.quote("%7E")).append("|")
        .append(Pattern.quote("%2F"));

    ENCODED_CHARACTERS_PATTERN = Pattern.compile(pattern.toString());
  }

  public static boolean usePayloadForQueryParameters(RequestMessage<?> request) {
    boolean requestIsPOST = HttpMethodName.POST.equals(request.getHttpMethod());
    boolean requestHasNoPayload = (request.getContent() == null);

    return requestIsPOST && requestHasNoPayload;
  }


  public static String encodeParameters(RequestMessage<?> request) {

    return null;
  }
  /**
   * Encode a string for use in the path of a URL; uses URLEncoder.encode,
   * (which encodes a string for use in the query portion of a URL), then
   * applies some postfilters to fix things up per the RFC. Can optionally
   * handle strings which are meant to encode a path (ie include '/'es which
   * should NOT be escaped).
   *
   * @param value
   *          the value to encode
   * @param path
   *          true if the value is intended to represent a path
   * @return the encoded value
   */
  public static String urlEncode(final String value, final boolean path) {
    if (value == null) {
      return "";
    }

    try {
      String encoded = URLEncoder.encode(value, DEFAULT_ENCODING);

      Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(encoded);
      StringBuffer buffer = new StringBuffer(encoded.length());

      while (matcher.find()) {
        String replacement = matcher.group(0);

        if ("+".equals(replacement)) {
          replacement = "%20";
        } else if ("*".equals(replacement)) {
          replacement = "%2A";
        } else if ("%7E".equals(replacement)) {
          replacement = "~";
        } else if (path && "%2F".equals(replacement)) {
          replacement = "/";
        }

        matcher.appendReplacement(buffer, replacement);
      }

      matcher.appendTail(buffer);
      return buffer.toString();

    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException(ex);
    }
  }

  /**
   * Append the given path to the given baseUri. By default, all slash
   * characters in path will not be url-encoded.
   */
  public static String appendUri(String baseUri, String path) {
    return appendUri(baseUri, path, false);
  }

  /**
   * Append the given path to the given baseUri.
   *
   * <p>
   * This method will encode the given path but not the given baseUri.
   * </p>
   *
   * @param baseUri
   *          The URI to append to (required, may be relative)
   * @param path
   *          The path to append (may be null or empty)
   * @param escapeDoubleSlash
   *          Whether double-slash in the path should be escaped to "/%2F"
   * @return The baseUri with the (encoded) path appended
   */
  public static String appendUri(final String baseUri, String path,
      final boolean escapeDoubleSlash) {
    String resultUri = baseUri;
    if (path != null && path.length() > 0) {
      if (path.startsWith("/")) {
        // trim the trailing slash in baseUri, since the path already starts
        // with a slash
        if (resultUri.endsWith("/")) {
          resultUri = resultUri.substring(0, resultUri.length() - 1);
        }
      } else if (!resultUri.endsWith("/")) {
        resultUri += "/";
      }
      String encodedPath = SdkHttpUtils.urlEncode(path, true);
      if (escapeDoubleSlash) {
        encodedPath = encodedPath.replace("//", "/%2F");
      }
      resultUri += encodedPath;
    } else if (!resultUri.endsWith("/")) {
      resultUri += "/";
    }

    return resultUri;
  }
}