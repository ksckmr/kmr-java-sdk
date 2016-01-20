package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.exception.*;
import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.util.json.JSONWriter;


/**
 * KeyValueMarshaller
 */
public class KeyValueJsonMarshaller {

    /**
     * Marshall the given parameter object, and output to a JSONWriter
     */
    public void marshall(KeyValue keyValue, JSONWriter jsonWriter) {
        if (keyValue == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonWriter.object();

            if (keyValue.getKey() != null) {
                jsonWriter.key("Key").value(keyValue.getKey());
            }

            if (keyValue.getValue() != null) {
                jsonWriter.key("Value").value(keyValue.getValue());
            }

            jsonWriter.endObject();
        } catch (Throwable t) {
            throw new KSCClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
    }

    private static KeyValueJsonMarshaller instance;

    public static KeyValueJsonMarshaller getInstance() {
        if (instance == null)
            instance = new KeyValueJsonMarshaller();
        return instance;
    }

}
