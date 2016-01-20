package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * InstanceGroupConfig JSON Unmarshaller
 */
public class InstanceGroupConfigJsonUnmarshaller implements
        Unmarshaller<InstanceGroupConfig, JsonUnmarshallerContext> {

    public InstanceGroupConfig unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        InstanceGroupConfig instanceGroupConfig = new InstanceGroupConfig();

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

                if (context.testExpression("InstanceRole", targetDepth)) {
                    context.nextToken();
                    instanceGroupConfig.setInstanceRole(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }

                if (context.testExpression("InstanceType", targetDepth)) {
                    context.nextToken();
                    instanceGroupConfig.setInstanceType(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("InstanceCount", targetDepth)) {
                    context.nextToken();
                    instanceGroupConfig
                            .setInstanceCount(IntegerJsonUnmarshaller
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

        return instanceGroupConfig;
    }

    private static InstanceGroupConfigJsonUnmarshaller instance;

    public static InstanceGroupConfigJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new InstanceGroupConfigJsonUnmarshaller();
        return instance;
    }
}
