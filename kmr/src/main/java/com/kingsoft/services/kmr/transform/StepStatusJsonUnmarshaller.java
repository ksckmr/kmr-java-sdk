package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * StepStatus JSON Unmarshaller
 */
public class StepStatusJsonUnmarshaller implements
        Unmarshaller<StepStatus, JsonUnmarshallerContext> {

    public StepStatus unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        StepStatus stepStatus = new StepStatus();

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
                    stepStatus.setState(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
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

        return stepStatus;
    }

    private static StepStatusJsonUnmarshaller instance;

    public static StepStatusJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new StepStatusJsonUnmarshaller();
        return instance;
    }
}
