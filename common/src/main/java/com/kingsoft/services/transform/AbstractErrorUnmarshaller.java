
package com.kingsoft.services.transform;

import java.lang.reflect.Constructor;

import com.kingsoft.services.exception.KSCServiceException;

public abstract class AbstractErrorUnmarshaller<T> implements Unmarshaller<KSCServiceException, T> {

    /**
     * The type of KSCServiceException that will be instantiated. Subclasses
     * specialized for a specific type of exception can control this through the
     * protected constructor.
     */
    protected final Class<? extends KSCServiceException> exceptionClass;

    /**
     * Constructs a new error unmarshaller that will unmarshall error responses
     * into KSCServiceException objects.
     */
    public AbstractErrorUnmarshaller() {
        this(KSCServiceException.class);
    }

    /**
     * Constructs a new error unmarshaller that will unmarshall error responses
     * into objects of the specified class, extending KSCServiceException.
     * 
     * @param exceptionClass
     *            The subclass of KSCServiceException which will be
     *            instantiated and populated by this class.
     */
    public AbstractErrorUnmarshaller(Class<? extends KSCServiceException> exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    /**
     * Constructs a new exception object of the type specified in this class's
     * constructor and sets the specified error message.
     * 
     * @param message
     *            The error message to set in the new exception object.
     * 
     * @return A new exception object of the type specified in this class's
     *         constructor and sets the specified error message.
     * 
     * @throws Exception
     *             If there are any problems using reflection to invoke the
     *             exception class's constructor.
     */
    protected KSCServiceException newException(String message) throws Exception {
        Constructor<? extends KSCServiceException> constructor = exceptionClass.getConstructor(String.class);
        return constructor.newInstance(message);
    }

}
