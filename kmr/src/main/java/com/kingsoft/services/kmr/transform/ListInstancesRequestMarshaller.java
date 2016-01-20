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
 * ListInstancesRequest Marshaller
 */
public class ListInstancesRequestMarshaller implements
        Marshaller<RequestMessage<ListInstancesRequest>, ListInstancesRequest> {

    public RequestMessage<ListInstancesRequest> marshall(
            ListInstancesRequest listInstancesRequest) {

        if (listInstancesRequest == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        RequestMessage<ListInstancesRequest> request = new RequestMessage<ListInstancesRequest>();
        request.addHeader(HttpHeaders.REQUEST_TARGET, "ElasticMapReduce_V1.ListInstances");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (listInstancesRequest.getClusterId() != null) {
                jsonWriter.key("ClusterId").value(
                        listInstancesRequest.getClusterId());
            }

            if (listInstancesRequest.getInstanceGroupId() != null) {
                jsonWriter.key("InstanceGroupId").value(
                        listInstancesRequest.getInstanceGroupId());
            }

            List<String> instanceGroupTypesList = (List<String>) listInstancesRequest
                    .getInstanceGroupTypes();
            if (!instanceGroupTypesList.isEmpty()) {
                jsonWriter.key("InstanceGroupTypes");
                jsonWriter.array();
                for (String instanceGroupTypesListValue : instanceGroupTypesList) {
                    if (instanceGroupTypesListValue != null) {
                        jsonWriter.value(instanceGroupTypesListValue);
                    }
                }
                jsonWriter.endArray();
            }

            if (listInstancesRequest.getMarker() != null) {
                jsonWriter.key("Marker")
                        .value(listInstancesRequest.getMarker());
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
