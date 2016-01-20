package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.exception.*;
import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.util.json.JSONWriter;

import java.util.List;

/**
 * AddtionalMarshaller
 */
public class AdditionalMarshaller {

    /**
     * Marshall the given parameter object, and output to a JSONWriter
     */
    public void marshall(Additional addtional,
            JSONWriter jsonWriter) {
        if (addtional == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonWriter.object();


            List<String> argsList = (List<String>) addtional
                    .getArgs();
            if (!argsList.isEmpty()) {
                jsonWriter.key("SparkSubmitArgs");
                jsonWriter.array();
                for (String argsListValue : argsList) {
                    if (argsListValue != null) {
                        jsonWriter.value(argsListValue);
                    }
                }
                jsonWriter.endArray();
            }

            jsonWriter.endObject();
        } catch (Throwable t) {
            throw new KSCClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
    }

    private static AdditionalMarshaller instance;

    public static AdditionalMarshaller getInstance() {
        if (instance == null)
            instance = new AdditionalMarshaller();
        return instance;
    }

}
