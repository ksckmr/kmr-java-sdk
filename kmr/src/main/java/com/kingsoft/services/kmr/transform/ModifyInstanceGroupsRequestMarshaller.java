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
 * ModifyInstanceGroupsRequest Marshaller
 */
public class ModifyInstanceGroupsRequestMarshaller
        implements
        Marshaller<RequestMessage<ModifyInstanceGroupsRequest>, ModifyInstanceGroupsRequest> {

    public RequestMessage<ModifyInstanceGroupsRequest> marshall(
            ModifyInstanceGroupsRequest modifyInstanceGroupsRequest) {

        if (modifyInstanceGroupsRequest == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        RequestMessage<ModifyInstanceGroupsRequest> request = new RequestMessage<ModifyInstanceGroupsRequest>();
        request.addHeader(HttpHeaders.REQUEST_TARGET,
                "ElasticMapReduce_V1.ModifyInstanceGroups");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();


            if (modifyInstanceGroupsRequest.getClusterId() != null) {
                jsonWriter.key("ClusterId").value(
                        modifyInstanceGroupsRequest.getClusterId());
            }

            List<InstanceGroupModifyConfig> instanceGroupsList = (List<InstanceGroupModifyConfig>) modifyInstanceGroupsRequest
                    .getInstanceGroups();
            if (!instanceGroupsList.isEmpty()) {
                jsonWriter.key("InstanceGroups");
                jsonWriter.array();
                for (InstanceGroupModifyConfig instanceGroupsListValue : instanceGroupsList) {
                    if (instanceGroupsListValue != null) {

                        InstanceGroupModifyConfigJsonMarshaller.getInstance()
                                .marshall(instanceGroupsListValue, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }

            jsonWriter.endObject();

            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader(HttpHeaders.CONTENT_LENGTH,
                    Integer.toString(content.length));
            request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        } catch (Throwable t) {
            throw new KSCClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
