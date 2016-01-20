package com.kingsoft.services.http; 

import java.io.IOException;


import com.kingsoft.services.ResponseMessage;
import com.kingsoft.services.transform.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;

import com.kingsoft.services.handlers.HttpResponseHandler;


/**
 * Default implementation of HttpResponseHandler that handles a successful
 * response from an KMR service and unmarshalls the result using a JSON
 * unmarshaller.
 *
 * @param <T>
 *            Indicates the type being unmarshalled by this response handler.
 */
public class JsonResponseHandler<T> implements HttpResponseHandler<ResponseMessage<T>> {

    /** The JSON unmarshaller to use when handling the response */
    private Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller;

    /** Shared logger for profiling information */
    private static final Log log = LogFactory.getLog("com.kmr.request");

    private static JsonFactory jsonFactory = new JsonFactory();

    public boolean needsConnectionLeftOpen = false;

    private boolean isPayloadJson = true;

    /**
     * Constructs a new response handler that will use the specified JSON
     * unmarshaller to unmarshall the service response and uses the specified
     * response element path to find the root of the business data in the
     * service's response.
     *
     * @param responseUnmarshaller
     *            The JSON unmarshaller to use on the response.
     */
    public JsonResponseHandler(Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller) {
        this.responseUnmarshaller = responseUnmarshaller;

        /*
         * Even if the invoked operation just returns null, we still need an
         * unmarshaller to run so we can pull out response metadata.
         *
         * We might want to pass this in through the client class so that we
         * don't have to do this check here.
         */
        if (this.responseUnmarshaller == null) {
            this.responseUnmarshaller = new VoidJsonUnmarshaller<T>();
        }
    }



    public ResponseMessage<T> handle(HttpResponse response) throws Exception {
        log.trace("Parsing service response JSON");

        JsonParser jsonParser = null;

        if (shouldParsePayloadAsJson()) {
            jsonParser = jsonFactory.createParser(response.getContent());
        }

        try {
            ResponseMessage<T> kscResponse = new ResponseMessage<T>();
            JsonUnmarshallerContext unmarshallerContext = new JsonUnmarshallerContextImpl(
                    jsonParser, response);
            registerAdditionalMetadataExpressions(unmarshallerContext);

            T result = responseUnmarshaller.unmarshall(unmarshallerContext);

            kscResponse.setContent(result);

            log.trace("Done parsing service response");
            return kscResponse;
        } finally {
            if (shouldParsePayloadAsJson()) {
                try {
                    jsonParser.close();
                } catch (IOException e) {
                    log.warn("Error closing json parser", e);
                }
            }
        }
    }

    /**
     * Hook for subclasses to override in order to collect additional metadata
     * from service responses.
     *
     * @param unmarshallerContext
     *            The unmarshaller context used to process a service's response
     *            data.
     */
    protected void registerAdditionalMetadataExpressions(JsonUnmarshallerContext unmarshallerContext) {}

    public boolean needsConnectionLeftOpen() {
        return needsConnectionLeftOpen;
    }

    public void setNeedsConnectionLeftOpen(boolean needsConnectionLeftOpen) {
        this.needsConnectionLeftOpen = needsConnectionLeftOpen;
    }

    /**
     * Sets whether the payload contains JSON.
     */
    public void setIsPayloadJson(boolean parsePayloadAsJson) {
        this.isPayloadJson = parsePayloadAsJson;
    }

    /**
     * @return True if the payload will be parsed as JSON, false otherwise.
     */
    private boolean shouldParsePayloadAsJson() {
        return !needsConnectionLeftOpen && isPayloadJson;
    }

}
