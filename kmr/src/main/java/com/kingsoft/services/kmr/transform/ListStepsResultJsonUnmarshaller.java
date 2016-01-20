package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ListStepsResult JSON Unmarshaller
 */
public class ListStepsResultJsonUnmarshaller implements
        Unmarshaller<ListStepsResult, JsonUnmarshallerContext> {

    public ListStepsResult unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        ListStepsResult listStepsResult = new ListStepsResult();

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
                if (context.testExpression("Steps", targetDepth)) {
                    context.nextToken();
                    listStepsResult.setSteps(new ListUnmarshaller<StepSummary>(
                            StepSummaryJsonUnmarshaller.getInstance())
                            .unmarshall(context));
                }
                if (context.testExpression("Marker", targetDepth)) {
                    context.nextToken();
                    listStepsResult.setMarker(StringJsonUnmarshaller
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

        return listStepsResult;
    }

    private static ListStepsResultJsonUnmarshaller instance;

    public static ListStepsResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ListStepsResultJsonUnmarshaller();
        return instance;
    }
}
