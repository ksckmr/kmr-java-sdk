package com.kingsoft.services.kmr.transform;


import java.io.StringWriter;
import java.util.List;


import com.kingsoft.services.HttpHeaders;
import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.http.HttpMethodName;
import com.kingsoft.services.kmr.model.AddJobFlowStepsRequest;
import com.kingsoft.services.kmr.model.StepConfig;
import com.kingsoft.services.transform.Marshaller;
import com.kingsoft.services.util.json.JSONWriter;
import static com.kingsoft.services.util.StringUtils.UTF8;
import com.kingsoft.services.util.*;


/**
 * AddJobFlowStepsRequest Marshaller
 */
public class AddJobFlowStepsRequestMarshaller implements
        Marshaller<RequestMessage<AddJobFlowStepsRequest>, AddJobFlowStepsRequest> {

    public RequestMessage<AddJobFlowStepsRequest> marshall(
            AddJobFlowStepsRequest addJobFlowStepsRequest) {

        if (addJobFlowStepsRequest == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        RequestMessage<AddJobFlowStepsRequest> request = new RequestMessage<AddJobFlowStepsRequest>();
        request.addHeader(HttpHeaders.REQUEST_TARGET, "ElasticMapReduce_V1.AddJobFlowSteps");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (addJobFlowStepsRequest.getJobFlowId() != null) {
                jsonWriter.key("JobFlowId").value(
                        addJobFlowStepsRequest.getJobFlowId());
            }

            List<StepConfig> stepsList = (List<StepConfig>) addJobFlowStepsRequest
                    .getSteps();
            if (!stepsList.isEmpty()) {
                jsonWriter.key("Steps");
                jsonWriter.array();
                for (StepConfig stepsListValue : stepsList) {
                    if (stepsListValue != null) {

                        StepConfigJsonMarshaller.getInstance().marshall(
                                stepsListValue, jsonWriter);
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
