package com.kingsoft.services.transform;


public interface Marshaller<T, R> {

  public T marshall(R in) throws Exception;

}
