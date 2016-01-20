package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ListInstanceGroupsResult JSON Unmarshaller
 */
public class ListInstanceGroupsResultJsonUnmarshaller implements
        Unmarshaller<ListInstanceGroupsResult, JsonUnmarshallerContext> {

    public ListInstanceGroupsResult unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        ListInstanceGroupsResult listInstanceGroupsResult = new ListInstanceGroupsResult();

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
                if (context.testExpression("InstanceGroups", targetDepth)) {
                    context.nextToken();
                    listInstanceGroupsResult
                            .setInstanceGroups(new ListUnmarshaller<InstanceGroup>(
                                    InstanceGroupJsonUnmarshaller.getInstance())
                                    .unmarshall(context));
                }
                if (context.testExpression("Marker", targetDepth)) {
                    context.nextToken();
                    listInstanceGroupsResult.setMarker(StringJsonUnmarshaller
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

        return listInstanceGroupsResult;
    }

    private static ListInstanceGroupsResultJsonUnmarshaller instance;

    public static ListInstanceGroupsResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ListInstanceGroupsResultJsonUnmarshaller();
        return instance;
    }
}
