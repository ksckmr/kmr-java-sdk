package com.kingsoft.services.internal.http;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

public class JsonErrorCodeParser {

    /**
     * Standard Error Code Parser for JSON based services.
     */
    public static final JsonErrorCodeParser DEFAULT_ERROR_CODE_PARSER = new JsonErrorCodeParser("error_code");

    /**
     * Services using JSON 1.1 protocol with HTTP binding send the error code information in the
     * response headers, instead of the content. Package private for tests.
     */
    static final String X_KSC_ERROR_TYPE = "Status";

    private final String errorCodeFieldName;

    public JsonErrorCodeParser(String errorCodeFieldName) {
        this.errorCodeFieldName = errorCodeFieldName;
    }

    /**
     * Parse the error code from the response.
     *
     * @return Error Code of exceptional response or null if it can't be determined
     */
    public String parseErrorCode(Map<String, String> httpHeaders, JsonNode jsonContents) {
        String errorCodeFromHeader = parseErrorCodeFromHeader(httpHeaders);
        if (errorCodeFromHeader != null) {
            return errorCodeFromHeader;
        } else {
            return parseErrorCodeFromContents(jsonContents);
        }
    }

    /**
     * Attempt to parse the error code from the response headers. Returns null if information is not
     * present in the header.
     */
    private String parseErrorCodeFromHeader(Map<String, String> httpHeaders) {
        String headerValue = httpHeaders.get(X_KSC_ERROR_TYPE);
        if (headerValue != null) {
            int separator = headerValue.indexOf(':');
            if (separator != -1) {
                headerValue = headerValue.substring(0, separator);
            }
        }
        return headerValue;
    }

    /**
     * Attempt to parse the error code from the response content. Returns null if information is not
     * present in the content. Codes are expected to be in the form <b>"typeName"</b> or
     * <b>"prefix#typeName"</b> 
     */
    private String parseErrorCodeFromContents(JsonNode jsonContents) {
        if (jsonContents == null || !jsonContents.has(errorCodeFieldName)) {
            return null;
        }
        String code = jsonContents.findValue(errorCodeFieldName).asText();
        int separator = code.lastIndexOf("#");
        return code.substring(separator + 1);
    }
}
