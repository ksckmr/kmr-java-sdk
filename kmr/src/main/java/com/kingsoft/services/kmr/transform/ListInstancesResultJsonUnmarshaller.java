package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ListInstancesResult JSON Unmarshaller
 */
public class ListInstancesResultJsonUnmarshaller implements
        Unmarshaller<ListInstancesResult, JsonUnmarshallerContext> {

    public ListInstancesResult unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        ListInstancesResult listInstancesResult = new ListInstancesResult();

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
                if (context.testExpression("Instances", targetDepth)) {
                    context.nextToken();
                    listInstancesResult
                            .setInstances(new ListUnmarshaller<Instance>(
                                    InstanceJsonUnmarshaller.getInstance())
                                    .unmarshall(context));
                }
                if (context.testExpression("Marker", targetDepth)) {
                    context.nextToken();
                    listInstancesResult.setMarker(StringJsonUnmarshaller
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

        return listInstancesResult;
    }

    private static ListInstancesResultJsonUnmarshaller instance;

    public static ListInstancesResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ListInstancesResultJsonUnmarshaller();
        return instance;
    }
}
