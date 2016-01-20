package com.kingsoft.services.transform;


public interface Unmarshaller<T, R> {

  public T unmarshall(R in) throws Exception;
}
