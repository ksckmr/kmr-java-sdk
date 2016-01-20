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
 * DescribeStepRequest Marshaller
 */
public class DescribeStepRequestMarshaller implements
        Marshaller<RequestMessage<DescribeStepRequest>, DescribeStepRequest> {

    public RequestMessage<DescribeStepRequest> marshall(
            DescribeStepRequest describeStepRequest) {

        if (describeStepRequest == null) {
            throw new KSCClientException(
                    "Invalid argument passed to marshall(...)");
        }

        RequestMessage<DescribeStepRequest> request = new RequestMessage<DescribeStepRequest>();
        request.addHeader(HttpHeaders.REQUEST_TARGET, "ElasticMapReduce_V1.DescribeStep");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (describeStepRequest.getClusterId() != null) {
                jsonWriter.key("ClusterId").value(
                        describeStepRequest.getClusterId());
            }

            if (describeStepRequest.getStepId() != null) {
                jsonWriter.key("StepId").value(describeStepRequest.getStepId());
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
