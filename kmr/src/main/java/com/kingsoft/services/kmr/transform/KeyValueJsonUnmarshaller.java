
package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * KeyValue JSON Unmarshaller
 */
public class KeyValueJsonUnmarshaller implements
        Unmarshaller<KeyValue, JsonUnmarshallerContext> {

    public KeyValue unmarshall(JsonUnmarshallerContext context)
            throws Exception {
        KeyValue keyValue = new KeyValue();

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
                if (context.testExpression("Key", targetDepth)) {
                    context.nextToken();
                    keyValue.setKey(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("Value", targetDepth)) {
                    context.nextToken();
                    keyValue.setValue(StringJsonUnmarshaller.getInstance()
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

        return keyValue;
    }

    private static KeyValueJsonUnmarshaller instance;

    public static KeyValueJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new KeyValueJsonUnmarshaller();
        return instance;
    }
}
