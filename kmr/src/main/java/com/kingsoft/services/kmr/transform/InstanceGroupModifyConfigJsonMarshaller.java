package com.kingsoft.services.kmr.transform;


import java.io.StringWriter;
import java.util.List;


import com.kingsoft.services.*;
import com.kingsoft.services.exception.*;
import com.kingsoft.services.http.*;
import static com.kingsoft.services.util.StringUtils.UTF8;
import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.*;
import com.kingsoft.services.util.json.JSONWriter;
import com.kingsoft.services.util.*;

/**
 * InstanceGroupModifyConfigMarshaller
 */
public class InstanceGroupModifyConfigJsonMarshaller {

    /**
     * Marshall the given parameter object, and output to a JSONWriter
     */
    public void marshall(InstanceGroupModifyConfig instanceGroupModifyConfig,
            JSONWriter jsonWriter) {
        if (instanceGroupModifyConfig == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonWriter.object();

            if (instanceGroupModifyConfig.getInstanceGroupId() != null) {
                jsonWriter.key("InstanceGroupId").value(
                        instanceGroupModifyConfig.getInstanceGroupId());
            }

            if (instanceGroupModifyConfig.getInstanceCount() != null) {
                jsonWriter.key("InstanceCount").value(
                        instanceGroupModifyConfig.getInstanceCount());
            }

            List<String> InstanceIdsToTerminateList = (List<String>) instanceGroupModifyConfig
                    .getInstanceIdsToTerminate();
            if (!InstanceIdsToTerminateList.isEmpty()) {
                jsonWriter.key("InstanceIdsToTerminate");
                jsonWriter.array();
                for (String InstanceIdsToTerminateListValue : InstanceIdsToTerminateList) {
                    if (InstanceIdsToTerminateListValue != null) {
                        jsonWriter.value(InstanceIdsToTerminateListValue);
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

    private static InstanceGroupModifyConfigJsonMarshaller instance;

    public static InstanceGroupModifyConfigJsonMarshaller getInstance() {
        if (instance == null)
            instance = new InstanceGroupModifyConfigJsonMarshaller();
        return instance;
    }

}
