package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.exception.*;
import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.util.json.JSONWriter;

/**
 * StepConfigMarshaller
 */
public class StepConfigJsonMarshaller {

    /**
     * Marshall the given parameter object, and output to a JSONWriter
     */
    public void marshall(StepConfig stepConfig, JSONWriter jsonWriter) {
        if (stepConfig == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonWriter.object();

            if (stepConfig.getName() != null) {
                jsonWriter.key("Name").value(stepConfig.getName());
            }

            if (stepConfig.getActionOnFailure() != null) {
                jsonWriter.key("ActionOnFailure").value(
                        stepConfig.getActionOnFailure());
            }

            if (stepConfig.getHadoopJarStep() != null) {
                jsonWriter.key("HadoopJarStep");
                HadoopJarStepConfigJsonMarshaller.getInstance().marshall(
                        stepConfig.getHadoopJarStep(), jsonWriter);
            }

            jsonWriter.endObject();
        } catch (Throwable t) {
            throw new KSCClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
    }

    private static StepConfigJsonMarshaller instance;

    public static StepConfigJsonMarshaller getInstance() {
        if (instance == null)
            instance = new StepConfigJsonMarshaller();
        return instance;
    }

}
