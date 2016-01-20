package com.kingsoft.services.internal.http;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonErrorMessageParser {

    private static final List<String> DEFAULT_ERROR_MESSAGE_LOCATIONS = Arrays
            .asList("message", "Message", "errorMessage", "error_message");

    private static final List<String> DEFAULT_ERROR_NAME_LOCATIONS = Arrays
            .asList("errorname",  "error_name");
    /**
     * Standard JSON Error Message Parser that checks for JSON fields in this
     * order: 'message', 'Message', 'errorMessage', "error_message"
     */
    public static final JsonErrorMessageParser DEFAULT_ERROR_MESSAGE_PARSER = new JsonErrorMessageParser(
            DEFAULT_ERROR_MESSAGE_LOCATIONS, DEFAULT_ERROR_NAME_LOCATIONS);

    private final List<String> errorMessageJsonLocations;
    private final List<String> errorNameJsonLocations;


    /**
     * @param errorMessageJsonLocations
     *            JSON field locations where the parser will attempt to extract
     *            the error message from.
     */
    public JsonErrorMessageParser(List<String> errorMessageJsonLocations,
                                  List<String> errorNameJsonLocations) {
        this.errorMessageJsonLocations = new LinkedList<String>(
                errorMessageJsonLocations);
        this.errorNameJsonLocations = new LinkedList<String>(
                errorNameJsonLocations
        );
    }

    /**
     * Parse the error message from the response.
     *
     * @return Error Code of exceptional response or null if it can't be
     *         determined
     */
    public String parseErrorMessage(JsonNode jsonNode) {
        for (String field : errorMessageJsonLocations) {
            JsonNode value = jsonNode.get(field);
            if (value != null && value.isTextual()) {
                return value.asText();
            }
        }
        return null;
    }

    public String parseErrorName(JsonNode jsonNode) {
        for (String field : errorNameJsonLocations) {
            JsonNode value = jsonNode.get(field);
            if (value != null && value.isTextual()) {
                return value.asText();
            }
        }
        return null;
    }

}
