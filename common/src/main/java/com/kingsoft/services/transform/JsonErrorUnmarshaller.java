
package com.kingsoft.services.transform;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;
import com.kingsoft.services.exception.KSCServiceException;

/**
 * Unmarshaller for JSON error responses from KMR services.
 */
public class JsonErrorUnmarshaller extends AbstractErrorUnmarshaller<JsonNode> {

    public static final JsonErrorUnmarshaller DEFAULT_UNMARSHALLER = new JsonErrorUnmarshaller(
            KSCServiceException.class, null);

    private static final ObjectMapper MAPPER = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).setPropertyNamingStrategy(
            new PascalCaseStrategy());

    private final String handledErrorCode;

    /**
     * @param exceptionClass
     *            Exception class this unmarshaller will attempt to deserialize error response into
     * @param handledErrorCode
     *            KSC error code that this unmarshaller handles. Pass null to handle all exceptions
     */
    public JsonErrorUnmarshaller(Class<? extends KSCServiceException> exceptionClass, String handledErrorCode) {
        super(exceptionClass);
        this.handledErrorCode = handledErrorCode;
    }

    @Override
    public KSCServiceException unmarshall(JsonNode jsonContent) throws Exception {
        return MAPPER.treeToValue(jsonContent, exceptionClass);
    }

    /**
     * @param actualErrorCode
     *            Actual KSC error code found in the error response.
     * @return True if the actualErrorCode can be handled by this unmarshaller, false otherwise
     */
    public boolean matchErrorCode(String actualErrorCode) {
        if (handledErrorCode == null) {
            return true;
        }
        return handledErrorCode.equals(actualErrorCode);
    }

}
