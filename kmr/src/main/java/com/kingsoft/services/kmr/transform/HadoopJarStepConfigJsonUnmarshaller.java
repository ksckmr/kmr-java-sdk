

package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;


import com.fasterxml.jackson.core.JsonToken;
import com.kingsoft.services.transform.JsonUnmarshallerContext;

import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * HadoopJarStepConfig JSON Unmarshaller
 */
public class HadoopJarStepConfigJsonUnmarshaller implements
        Unmarshaller<HadoopJarStepConfig, JsonUnmarshallerContext> {

    public HadoopJarStepConfig unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        HadoopJarStepConfig hadoopJarStepConfig = new HadoopJarStepConfig();

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
                if (context.testExpression("Properties", targetDepth)) {
                    context.nextToken();
                    hadoopJarStepConfig
                            .setProperties(new ListUnmarshaller<KeyValue>(
                                    KeyValueJsonUnmarshaller.getInstance())
                                    .unmarshall(context));
                }
                if (context.testExpression("Jar", targetDepth)) {
                    context.nextToken();
                    hadoopJarStepConfig.setJar(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("MainClass", targetDepth)) {
                    context.nextToken();
                    hadoopJarStepConfig.setMainClass(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("Args", targetDepth)) {
                    context.nextToken();
                    hadoopJarStepConfig.setArgs(new ListUnmarshaller<String>(
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

        return hadoopJarStepConfig;
    }

    private static HadoopJarStepConfigJsonUnmarshaller instance;

    public static HadoopJarStepConfigJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new HadoopJarStepConfigJsonUnmarshaller();
        return instance;
    }
}
