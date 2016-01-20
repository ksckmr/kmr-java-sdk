package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * HadoopStepConfig JSON Unmarshaller
 */
public class HadoopStepConfigJsonUnmarshaller implements
        Unmarshaller<HadoopStepConfig, JsonUnmarshallerContext> {

    public HadoopStepConfig unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        HadoopStepConfig hadoopStepConfig = new HadoopStepConfig();

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
                if (context.testExpression("Jar", targetDepth)) {
                    context.nextToken();
                    hadoopStepConfig.setJar(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("Properties", targetDepth)) {
                    context.nextToken();
                    hadoopStepConfig
                            .setProperties(new MapUnmarshaller<String, String>(
                                    StringJsonUnmarshaller.getInstance(),
                                    StringJsonUnmarshaller.getInstance())
                                    .unmarshall(context));
                }
                if (context.testExpression("MainClass", targetDepth)) {
                    context.nextToken();
                    hadoopStepConfig.setMainClass(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("Args", targetDepth)) {
                    context.nextToken();
                    hadoopStepConfig.setArgs(new ListUnmarshaller<String>(
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

        return hadoopStepConfig;
    }

    private static HadoopStepConfigJsonUnmarshaller instance;

    public static HadoopStepConfigJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new HadoopStepConfigJsonUnmarshaller();
        return instance;
    }
}
