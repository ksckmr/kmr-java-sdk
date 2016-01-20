package com.kingsoft.services.kmr.transform;


import java.io.StringWriter;
import java.util.ArrayList;
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
 * RunJobFlowRequest Marshaller
 */
public class RunJobFlowRequestMarshaller implements
        Marshaller<RequestMessage<RunJobFlowRequest>, RunJobFlowRequest> {

    public RequestMessage<RunJobFlowRequest> marshall(
            RunJobFlowRequest runJobFlowRequest) {

        if (runJobFlowRequest == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        RequestMessage<RunJobFlowRequest> request = new RequestMessage<RunJobFlowRequest>();
        request.addHeader(HttpHeaders.REQUEST_TARGET, "ElasticMapReduce_V1.RunJobFlow");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (runJobFlowRequest.getName() != null) {
                jsonWriter.key("Name").value(runJobFlowRequest.getName());
            }

            if (runJobFlowRequest.getLogUri() != null) {
                jsonWriter.key("LogUri").value(runJobFlowRequest.getLogUri());
            }

            if (runJobFlowRequest.getHadoopVersion() != null) {
                jsonWriter.key("HadoopVersion").value(runJobFlowRequest.getHadoopVersion());
            }

            if (runJobFlowRequest.getEnableHighAvailability() != null) {
                jsonWriter.key("EnableHighAvailability").value(runJobFlowRequest.getEnableHighAvailability());
            }
            if (runJobFlowRequest.getEnableEip() != null) {
                jsonWriter.key("EnableEIP").value(runJobFlowRequest.getEnableEip());
            }
            if (runJobFlowRequest.getSshKeyIds() != null) {
                jsonWriter.key("SshKeyIds").value(runJobFlowRequest.getSshKeyIds());
            }

            if (runJobFlowRequest.getInstances() != null) {
                jsonWriter.key("Instances");
                JobFlowInstancesConfigJsonMarshaller.getInstance().marshall(
                        runJobFlowRequest.getInstances(), jsonWriter);
            }

            List<StepConfig> stepsList = (List<StepConfig>) runJobFlowRequest
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

            List<String> applicationsList = (ArrayList<String>) runJobFlowRequest
                    .getApplications();
            if (!applicationsList.isEmpty()) {
                jsonWriter.key("Applications");
                jsonWriter.array();
                for (String applicationsListValue : applicationsList) {
                    if (applicationsListValue != null) {
                        jsonWriter.value(applicationsListValue);
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
