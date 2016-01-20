package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ClusterSummary JSON Unmarshaller
 */
public class ClusterSummaryJsonUnmarshaller implements
        Unmarshaller<ClusterSummary, JsonUnmarshallerContext> {

    public ClusterSummary unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        ClusterSummary clusterSummary = new ClusterSummary();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL)
            return null;

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("Id", targetDepth)) {
                    context.nextToken();
                    clusterSummary.setId(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("Name", targetDepth)) {
                    context.nextToken();
                    clusterSummary.setName(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("Status", targetDepth)) {
                    context.nextToken();
                    clusterSummary.setStatus(ClusterStatusJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("NormalizedInstanceMins",
                        targetDepth)) {
                    context.nextToken();
                    clusterSummary
                            .setNormalizedInstanceMins(FloatJsonUnmarshaller
                                    .getInstance().unmarshall(context).intValue());
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null
                        || context.getLastParsedParentElement().equals(
                                currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return clusterSummary;
    }

    private static ClusterSummaryJsonUnmarshaller instance;

    public static ClusterSummaryJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ClusterSummaryJsonUnmarshaller();
        return instance;
    }
}
