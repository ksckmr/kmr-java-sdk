package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.exception.*;
import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.util.json.JSONWriter;

import java.util.List;

/**
 * HadoopJarStepConfigMarshaller
 */
public class HadoopJarStepConfigJsonMarshaller {

    /**
     * Marshall the given parameter object, and output to a JSONWriter
     */
    public void marshall(HadoopJarStepConfig hadoopJarStepConfig,
            JSONWriter jsonWriter) {
        if (hadoopJarStepConfig == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonWriter.object();

            List<KeyValue> propertiesList = (List<KeyValue>) hadoopJarStepConfig
                    .getProperties();
            if (!propertiesList.isEmpty()) {
                jsonWriter.key("Properties");
                jsonWriter.array();
                for (KeyValue propertiesListValue : propertiesList) {
                    if (propertiesListValue != null) {

                        KeyValueJsonMarshaller.getInstance().marshall(
                                propertiesListValue, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }

            if (hadoopJarStepConfig.getJar() != null) {
                jsonWriter.key("Jar").value(hadoopJarStepConfig.getJar());
            }

            if (hadoopJarStepConfig.getMainJar() != null) {
                jsonWriter.key("MainJar").value(hadoopJarStepConfig.getMainJar());
            }

            if (hadoopJarStepConfig.getMainClass() != null) {
                jsonWriter.key("MainClass").value(
                        hadoopJarStepConfig.getMainClass());
            }

            if (hadoopJarStepConfig.getAdditional() != null) {
                jsonWriter.key("Additional");
                AdditionalMarshaller.getInstance().marshall(
                        hadoopJarStepConfig.getAdditional(), jsonWriter);
            }

            List<String> argsList = (List<String>) hadoopJarStepConfig
                    .getArgs();
            if (!argsList.isEmpty()) {
                jsonWriter.key("Args");
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

    private static HadoopJarStepConfigJsonMarshaller instance;

    public static HadoopJarStepConfigJsonMarshaller getInstance() {
        if (instance == null)
            instance = new HadoopJarStepConfigJsonMarshaller();
        return instance;
    }

}
