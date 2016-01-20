package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;
/**
 * Step JSON Unmarshaller
 */
public class StepJsonUnmarshaller implements
        Unmarshaller<Step, JsonUnmarshallerContext> {

    public Step unmarshall(JsonUnmarshallerContext context) throws Exception {
        Step step = new Step();

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
                    step.setId(StringJsonUnmarshaller.getInstance().unmarshall(
                            context));
                }
                if (context.testExpression("Name", targetDepth)) {
                    context.nextToken();
                    step.setName(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("HadoopJarStep", targetDepth)) {
                    context.nextToken();
                    step.setConfig(HadoopStepConfigJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("ActionOnFailure", targetDepth)) {
                    context.nextToken();
                    step.setActionOnFailure(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("Status", targetDepth)) {
                    context.nextToken();
                    step.setStatus(StepStatusJsonUnmarshaller.getInstance()
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

        return step;
    }

    private static StepJsonUnmarshaller instance;

    public static StepJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new StepJsonUnmarshaller();
        return instance;
    }
}
