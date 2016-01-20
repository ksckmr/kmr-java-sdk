package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * DescribeClusterResult JSON Unmarshaller
 */
public class DescribeClusterResultJsonUnmarshaller implements
        Unmarshaller<DescribeClusterResult, JsonUnmarshallerContext> {

    public DescribeClusterResult unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        DescribeClusterResult describeClusterResult = new DescribeClusterResult();

        describeClusterResult.setCluster(ClusterJsonUnmarshaller
                .getInstance().unmarshall(context));
        /*
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
                if (context.testExpression("Cluster", targetDepth)) {
                    context.nextToken();
                    describeClusterResult.setCluster(ClusterJsonUnmarshaller
                            .getInstance().unmarshall(context));
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
        */
        return describeClusterResult;
    }

    private static DescribeClusterResultJsonUnmarshaller instance;

    public static DescribeClusterResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new DescribeClusterResultJsonUnmarshaller();
        return instance;
    }
}
