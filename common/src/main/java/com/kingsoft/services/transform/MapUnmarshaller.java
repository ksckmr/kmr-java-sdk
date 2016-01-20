package com.kingsoft.services.transform;

import static com.fasterxml.jackson.core.JsonToken.END_ARRAY;
import static com.fasterxml.jackson.core.JsonToken.END_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.FIELD_NAME;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonToken;


public class MapUnmarshaller<K, V> implements Unmarshaller<Map<K, V>, JsonUnmarshallerContext> {

    private final Unmarshaller<K, JsonUnmarshallerContext> keyUnmarshaller;
    private final Unmarshaller<V, JsonUnmarshallerContext> valueUnmarshaller;

    public MapUnmarshaller(Unmarshaller<K, JsonUnmarshallerContext> keyUnmarshaller, Unmarshaller<V, JsonUnmarshallerContext> valueUnmarshaller) {
        this.keyUnmarshaller = keyUnmarshaller;
        this.valueUnmarshaller = valueUnmarshaller;
    }

    public Map<K, V> unmarshall(JsonUnmarshallerContext context) throws Exception {
        Map<K, V> map = new HashMap<K, V>();
        int originalDepth = context.getCurrentDepth();

        if (context.getCurrentToken() == JsonToken.VALUE_NULL) {
            return null;
        }

        while (true) {
            JsonToken token = context.nextToken();
            if (token == null) return map;

            if (token == FIELD_NAME) {
                K k = keyUnmarshaller.unmarshall(context);
                token = context.nextToken();
                V v = valueUnmarshaller.unmarshall(context);
                map.put(k, v);
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getCurrentDepth() <= originalDepth) return map;
            }
        }
    }

}
