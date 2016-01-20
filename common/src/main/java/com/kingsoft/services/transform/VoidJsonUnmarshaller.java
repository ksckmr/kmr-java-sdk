package com.kingsoft.services.transform;


/**
 * Simple unmarshaller that iterates through the JSON events but always
 * returns null.
 */
public class VoidJsonUnmarshaller<T> implements Unmarshaller<T, JsonUnmarshallerContext> {
    public T unmarshall(JsonUnmarshallerContext context) throws Exception {
        return null;
    }
}
