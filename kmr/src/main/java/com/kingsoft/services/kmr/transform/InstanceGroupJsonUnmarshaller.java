package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * InstanceGroup JSON Unmarshaller
 */
public class InstanceGroupJsonUnmarshaller implements
        Unmarshaller<InstanceGroup, JsonUnmarshallerContext> {

    public InstanceGroup unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        InstanceGroup instanceGroup = new InstanceGroup();

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
                    instanceGroup.setId(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("Name", targetDepth)) {
                    context.nextToken();
                    instanceGroup.setName(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }

                if (context.testExpression("InstanceGroupType", targetDepth)) {
                    context.nextToken();
                    instanceGroup.setInstanceGroupType(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }

                if (context.testExpression("InstanceType", targetDepth)) {
                    context.nextToken();
                    instanceGroup.setInstanceType(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("InstanceCount",
                        targetDepth)) {
                    context.nextToken();
                    instanceGroup
                            .setRequestedInstanceCount(IntegerJsonUnmarshaller
                                    .getInstance().unmarshall(context));
                }

                if (context.testExpression("Status", targetDepth)) {
                    context.nextToken();
                    instanceGroup.setStatus(InstanceGroupStatusJsonUnmarshaller
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

        return instanceGroup;
    }

    private static InstanceGroupJsonUnmarshaller instance;

    public static InstanceGroupJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new InstanceGroupJsonUnmarshaller();
        return instance;
    }
}
