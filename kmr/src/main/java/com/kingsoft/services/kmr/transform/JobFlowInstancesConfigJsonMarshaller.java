package com.kingsoft.services.kmr.transform;

import java.util.List;

import com.kingsoft.services.exception.*;
import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.util.json.JSONWriter;

public class JobFlowInstancesConfigJsonMarshaller {

    /**
     * Marshall the given parameter object, and output to a JSONWriter
     */
    public void marshall(JobFlowInstancesConfig jobFlowInstancesConfig,
            JSONWriter jsonWriter) {
        if (jobFlowInstancesConfig == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonWriter.object();

            List<InstanceGroupConfig> instanceGroupsList = (List<InstanceGroupConfig>) jobFlowInstancesConfig
                    .getInstanceGroups();
            if (!instanceGroupsList.isEmpty()) {
                jsonWriter.key("InstanceGroups");
                jsonWriter.array();
                for (InstanceGroupConfig instanceGroupsListValue : instanceGroupsList) {
                    if (instanceGroupsListValue != null) {

                        InstanceGroupConfigJsonMarshaller.getInstance()
                                .marshall(instanceGroupsListValue, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }

            if (jobFlowInstancesConfig.getKeepJobFlowAliveWhenNoSteps() != null) {
                jsonWriter.key("KeepJobFlowAliveWhenNoSteps")
                        .value(jobFlowInstancesConfig
                                .getKeepJobFlowAliveWhenNoSteps());
            }

            if (jobFlowInstancesConfig.getTerminationProtected() != null) {
                jsonWriter.key("TerminationProtected").value(
                        jobFlowInstancesConfig.getTerminationProtected());
            }


            jsonWriter.endObject();
        } catch (Throwable t) {
            throw new KSCClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
    }

    private static JobFlowInstancesConfigJsonMarshaller instance;

    public static JobFlowInstancesConfigJsonMarshaller getInstance() {
        if (instance == null)
            instance = new JobFlowInstancesConfigJsonMarshaller();
        return instance;
    }

}
