package com.kingsoft.services.kmr.model;


/**
 * 
 */
public enum InstanceGroupState {

    PROVISIONING("PROVISIONING"),
    BOOTSTRAPPING("BOOTSTRAPPING"),
    RUNNING("RUNNING"),
    RESIZING("RESIZING"),
    SUSPENDED("SUSPENDED"),
    TERMINATING("TERMINATING"),
    TERMINATED("TERMINATED"),
    ARRESTED("ARRESTED"),
    SHUTTING_DOWN("SHUTTING_DOWN"),
    ENDED("ENDED");

    private String value;

    private InstanceGroupState(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Use this in place of valueOf.
     *
     * @param value
     *        real value
     * @return InstanceGroupState corresponding to the value
     */
    public static InstanceGroupState fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("PROVISIONING".equals(value)) {
            return PROVISIONING;
        } else if ("BOOTSTRAPPING".equals(value)) {
            return BOOTSTRAPPING;
        } else if ("RUNNING".equals(value)) {
            return RUNNING;
        } else if ("RESIZING".equals(value)) {
            return RESIZING;
        } else if ("SUSPENDED".equals(value)) {
            return SUSPENDED;
        } else if ("TERMINATING".equals(value)) {
            return TERMINATING;
        } else if ("TERMINATED".equals(value)) {
            return TERMINATED;
        } else if ("ARRESTED".equals(value)) {
            return ARRESTED;
        } else if ("SHUTTING_DOWN".equals(value)) {
            return SHUTTING_DOWN;
        } else if ("ENDED".equals(value)) {
            return ENDED;
        } else {
            throw new IllegalArgumentException("Cannot create enum from "
                    + value + " value!");
        }
    }
}