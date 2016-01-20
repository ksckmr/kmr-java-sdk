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
 * SetTerminationProtectionRequest Marshaller
 */
public class SetTerminationProtectionRequestMarshaller
        implements
        Marshaller<RequestMessage<SetTerminationProtectionRequest>, SetTerminationProtectionRequest> {

    public RequestMessage<SetTerminationProtectionRequest> marshall(
            SetTerminationProtectionRequest setTerminationProtectionRequest) {

        if (setTerminationProtectionRequest == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        RequestMessage<SetTerminationProtectionRequest> request = new RequestMessage<SetTerminationProtectionRequest>();
        request.addHeader(HttpHeaders.REQUEST_TARGET,
                "ElasticMapReduce_V1.SetTerminationProtection");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            List<String> jobFlowIdsList = (List<String>) setTerminationProtectionRequest
                    .getJobFlowIds();
            if (!jobFlowIdsList.isEmpty()) {
                jsonWriter.key("JobFlowIds");
                jsonWriter.array();
                for (String jobFlowIdsListValue : jobFlowIdsList) {
                    if (jobFlowIdsListValue != null) {
                        jsonWriter.value(jobFlowIdsListValue);
                    }
                }
                jsonWriter.endArray();
            }

            if (setTerminationProtectionRequest.getTerminationProtected() != null) {
                jsonWriter.key("TerminationProtected").value(
                        setTerminationProtectionRequest
                                .getTerminationProtected());
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
