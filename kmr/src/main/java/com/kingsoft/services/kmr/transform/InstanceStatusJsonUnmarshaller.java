package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * InstanceStatus JSON Unmarshaller
 */
public class InstanceStatusJsonUnmarshaller implements
        Unmarshaller<InstanceStatus, JsonUnmarshallerContext> {

    public InstanceStatus unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        InstanceStatus instanceStatus = new InstanceStatus();

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
                if (context.testExpression("State", targetDepth)) {
                    context.nextToken();
                    instanceStatus.setState(StringJsonUnmarshaller
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

        return instanceStatus;
    }

    private static InstanceStatusJsonUnmarshaller instance;

    public static InstanceStatusJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new InstanceStatusJsonUnmarshaller();
        return instance;
    }
}
