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
 * ListClustersRequest Marshaller
 */
public class ListClustersRequestMarshaller implements
        Marshaller<RequestMessage<ListClustersRequest>, ListClustersRequest> {

    public RequestMessage<ListClustersRequest> marshall(
            ListClustersRequest listClustersRequest) {

        if (listClustersRequest == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        RequestMessage<ListClustersRequest> request = new RequestMessage<ListClustersRequest>();
        request.addHeader(HttpHeaders.REQUEST_TARGET, "ElasticMapReduce_V1.ListClusters");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (listClustersRequest.getCreatedAfter() != null) {
                String createdAfter = DateUtils.format(listClustersRequest.getCreatedAfter());
                jsonWriter.key("CreatedAfter").value(
                        createdAfter);
            }

            if (listClustersRequest.getCreatedBefore() != null) {
                String createdBefore = DateUtils.format(listClustersRequest.getCreatedBefore());
                jsonWriter.key("CreatedBefore").value(
                        createdBefore);
            }

            List<String> clusterStatesList = (List<String>) listClustersRequest
                    .getClusterStates();
            if (!clusterStatesList.isEmpty()) {
                jsonWriter.key("ClusterStates");
                jsonWriter.array();
                for (String clusterStatesListValue : clusterStatesList) {
                    if (clusterStatesListValue != null) {
                        jsonWriter.value(clusterStatesListValue);
                    }
                }
                jsonWriter.endArray();
            }

            if (listClustersRequest.getMarker() != null) {
                jsonWriter.key("Marker").value(listClustersRequest.getMarker());
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
