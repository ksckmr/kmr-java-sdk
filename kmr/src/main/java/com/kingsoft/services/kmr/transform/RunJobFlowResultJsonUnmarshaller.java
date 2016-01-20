package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * RunJobFlowResult JSON Unmarshaller
 */
public class RunJobFlowResultJsonUnmarshaller implements
        Unmarshaller<RunJobFlowResult, JsonUnmarshallerContext> {

    public RunJobFlowResult unmarshall(JsonUnmarshallerContext context)
    throws Exception {
        RunJobFlowResult runJobFlowResult = new RunJobFlowResult();

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
                if (context.testExpression("JobFlowId", targetDepth)) {
                    context.nextToken();
                    runJobFlowResult.setJobFlowId(StringJsonUnmarshaller
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

        return runJobFlowResult;
    }

    private static RunJobFlowResultJsonUnmarshaller instance;

    public static RunJobFlowResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new RunJobFlowResultJsonUnmarshaller();
        return instance;
    }
}
