package com.kingsoft.services.kmr.transform;


import java.util.Map;
import java.util.Map.Entry;


import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;


/**
 * AddJobFlowStepsResult JSON Unmarshaller
 */
public class AddJobFlowStepsResultJsonUnmarshaller implements
        Unmarshaller<AddJobFlowStepsResult, JsonUnmarshallerContext> {

    public AddJobFlowStepsResult unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        AddJobFlowStepsResult addJobFlowStepsResult = new AddJobFlowStepsResult();

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
                if (context.testExpression("StepIds", targetDepth)) {
                    context.nextToken();
                    addJobFlowStepsResult
                            .setStepIds(new ListUnmarshaller<String>(
                                    StringJsonUnmarshaller.getInstance())
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

        return addJobFlowStepsResult;
    }

    private static AddJobFlowStepsResultJsonUnmarshaller instance;

    public static AddJobFlowStepsResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new AddJobFlowStepsResultJsonUnmarshaller();
        return instance;
    }
}
