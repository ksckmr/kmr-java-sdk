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
 * InstanceGroupConfigMarshaller
 */
public class InstanceGroupConfigJsonMarshaller {

    /**
     * Marshall the given parameter object, and output to a JSONWriter
     */
    public void marshall(InstanceGroupConfig instanceGroupConfig,
            JSONWriter jsonWriter) {
        if (instanceGroupConfig == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonWriter.object();


            if (instanceGroupConfig.getInstanceRole() != null) {
                jsonWriter.key("InstanceRole").value(
                        instanceGroupConfig.getInstanceRole());
            }


            if (instanceGroupConfig.getInstanceType() != null) {
                jsonWriter.key("InstanceType").value(
                        instanceGroupConfig.getInstanceType());
            }

            if (instanceGroupConfig.getInstanceCount() != null) {
                jsonWriter.key("InstanceCount").value(
                        instanceGroupConfig.getInstanceCount());
            }


            jsonWriter.endObject();
        } catch (Throwable t) {
            throw new KSCClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
    }

    private static InstanceGroupConfigJsonMarshaller instance;

    public static InstanceGroupConfigJsonMarshaller getInstance() {
        if (instance == null)
            instance = new InstanceGroupConfigJsonMarshaller();
        return instance;
    }

}
