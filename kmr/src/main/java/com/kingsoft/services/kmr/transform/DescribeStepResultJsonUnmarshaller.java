package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * DescribeStepResult JSON Unmarshaller
 */
public class DescribeStepResultJsonUnmarshaller implements
        Unmarshaller<DescribeStepResult, JsonUnmarshallerContext> {

    public DescribeStepResult unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        DescribeStepResult describeStepResult = new DescribeStepResult();

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
                if (context.testExpression("Step", targetDepth)) {
                    context.nextToken();
                    describeStepResult.setStep(StepJsonUnmarshaller
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

        return describeStepResult;
    }

    private static DescribeStepResultJsonUnmarshaller instance;

    public static DescribeStepResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new DescribeStepResultJsonUnmarshaller();
        return instance;
    }
}
