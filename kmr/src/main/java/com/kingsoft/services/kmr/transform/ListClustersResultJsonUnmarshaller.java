package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ListClustersResult JSON Unmarshaller
 */
public class ListClustersResultJsonUnmarshaller implements
        Unmarshaller<ListClustersResult, JsonUnmarshallerContext> {

    public ListClustersResult unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        ListClustersResult listClustersResult = new ListClustersResult();

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
                if (context.testExpression("Clusters", targetDepth)) {
                    context.nextToken();
                    listClustersResult
                            .setClusters(new ListUnmarshaller<ClusterSummary>(
                                    ClusterSummaryJsonUnmarshaller
                                            .getInstance()).unmarshall(context));
                }
                if (context.testExpression("Marker", targetDepth)) {
                    context.nextToken();
                    listClustersResult.setMarker(StringJsonUnmarshaller
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

        return listClustersResult;
    }

    private static ListClustersResultJsonUnmarshaller instance;

    public static ListClustersResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ListClustersResultJsonUnmarshaller();
        return instance;
    }
}
