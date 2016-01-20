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
 * ListStepsRequest Marshaller
 */
public class ListStepsRequestMarshaller implements
        Marshaller<RequestMessage<ListStepsRequest>, ListStepsRequest> {

    public RequestMessage<ListStepsRequest> marshall(ListStepsRequest listStepsRequest) {

        if (listStepsRequest == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        RequestMessage<ListStepsRequest> request = new RequestMessage<ListStepsRequest>();
        request.addHeader(HttpHeaders.REQUEST_TARGET, "ElasticMapReduce_V1.ListSteps");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (listStepsRequest.getClusterId() != null) {
                jsonWriter.key("ClusterId").value(
                        listStepsRequest.getClusterId());
            }

            List<String> stepStatesList = (List<String>) listStepsRequest
                    .getStepStates();
            if (!stepStatesList.isEmpty()) {
                jsonWriter.key("StepStates");
                jsonWriter.array();
                for (String stepStatesListValue : stepStatesList) {
                    if (stepStatesListValue != null) {
                        jsonWriter.value(stepStatesListValue);
                    }
                }
                jsonWriter.endArray();
            }

            List<String> stepIdsList = (List<String>) listStepsRequest
                    .getStepIds();
            if (!stepIdsList.isEmpty()) {
                jsonWriter.key("StepIds");
                jsonWriter.array();
                for (String stepIdsListValue : stepIdsList) {
                    if (stepIdsListValue != null) {
                        jsonWriter.value(stepIdsListValue);
                    }
                }
                jsonWriter.endArray();
            }

            if (listStepsRequest.getMarker() != null) {
                jsonWriter.key("Marker").value(listStepsRequest.getMarker());
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
