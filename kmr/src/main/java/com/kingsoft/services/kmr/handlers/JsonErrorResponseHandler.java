package com.kingsoft.services.kmr.handlers;

import java.util.List;

import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.exception.KSCServiceException;
import com.kingsoft.services.handlers.HttpResponseHandler;
import com.kingsoft.services.http.HttpResponse;
import com.kingsoft.services.internal.http.*;
import com.kingsoft.services.kmr.exception.AccessDeniedException;
import com.kingsoft.services.kmr.exception.BadRequestException;
import com.kingsoft.services.kmr.exception.InternalServerErrorException;
import com.kingsoft.services.kmr.exception.NotFoundException;
import com.kingsoft.services.transform.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.kingsoft.services.util.IOUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonErrorResponseHandler implements HttpResponseHandler<KSCServiceException> {

    private static final Log LOG = LogFactory.getLog(JsonErrorResponseHandler.class);

    private final List<JsonErrorUnmarshaller> unmarshallers;
    private final JsonErrorCodeParser errorCodeParser;
    private final JsonErrorMessageParser errorMessageParser;

    public JsonErrorResponseHandler(
            List<JsonErrorUnmarshaller> errorUnmarshallers) {
        this(errorUnmarshallers, JsonErrorCodeParser.DEFAULT_ERROR_CODE_PARSER,
                JsonErrorMessageParser.DEFAULT_ERROR_MESSAGE_PARSER);
    }

    public JsonErrorResponseHandler(
            List<JsonErrorUnmarshaller> errorUnmarshallers,
            JsonErrorCodeParser errorCodeParser) {
        this(errorUnmarshallers, errorCodeParser,
                JsonErrorMessageParser.DEFAULT_ERROR_MESSAGE_PARSER);
    }

    public JsonErrorResponseHandler(
            List<JsonErrorUnmarshaller> errorUnmarshallers,
            JsonErrorCodeParser errorCodeParser,
            JsonErrorMessageParser errorMessageParser) {
        this.unmarshallers = errorUnmarshallers;
        this.errorCodeParser = errorCodeParser;
        this.errorMessageParser = errorMessageParser;
    }


    @Override
    public KSCServiceException handle(HttpResponse response) throws Exception {
        JsonContent jsonContent = JsonContent.createJsonContent(response);
        String errorCode = errorCodeParser.parseErrorCode(response.getHeaders(), jsonContent.jsonNode);

        KSCServiceException ase = null;

        String errorMsg = errorMessageParser
                .parseErrorMessage(jsonContent.jsonNode);
        String errorName = errorMessageParser
                .parseErrorName(jsonContent.jsonNode);


        if(errorCode.equals("403")) {
            ase = new AccessDeniedException(errorMsg);
        } else if(errorCode.equals("404")){
            ase = new NotFoundException(errorMsg);
        } else if (errorCode.equals("400")) {
            ase = new BadRequestException(errorMsg);
        } else if (errorCode.equals("500")) {
            ase = new InternalServerErrorException(errorMsg);
        } else {
            throw new KSCClientException("unsupported response code:" + errorCode);
        }

        ase.setErrorCode(errorCode);
        ase.setErrorName(errorName);
        ase.setErrorMsg(errorMsg);
        ase.setHttpCode(response.getStatusCode());

        return ase;
    }

    private static class JsonContent {

        private static final ObjectMapper MAPPER = new ObjectMapper()
                .configure(JsonParser.Feature.ALLOW_COMMENTS, true);

        public final String rawJsonContent;
        public final JsonNode jsonNode;

        /**
         * Static factory method to create a JsonContent object from the contents of the
         * HttpResponse provided
         */
        public static JsonContent createJsonContent(HttpResponse httpResponse) {
            String rawJsonContent = null;
            try {
                rawJsonContent = IOUtils.toString(httpResponse.getContent());
            } catch (Exception e) {
                LOG.info("Unable to read HTTP response content", e);
            }
            return new JsonContent(rawJsonContent);

        }

        private JsonContent(String rawJsonContent) {
            this.rawJsonContent = rawJsonContent;
            this.jsonNode = parseJsonContent(rawJsonContent);
        }

        private static JsonNode parseJsonContent(String rawJsonContent) {
            if (rawJsonContent == null) {
                return null;
            }
            try {
                return MAPPER.readTree(rawJsonContent);
            } catch (Exception e) {
                LOG.info("Unable to parse HTTP response content", e);
                return null;
            }
        }

        public boolean isJsonValid() {
            return jsonNode != null;
        }

    }
}
