package com.kingsoft.services.kmr.model;

/**
 * 
 */
public enum ClusterState {

    STARTING("STARTING"),
    BOOTSTRAPPING("BOOTSTRAPPING"),
    RUNNING("RUNNING"),
    WAITING("WAITING"),
    TERMINATING("TERMINATING"),
    TERMINATED("TERMINATED"),
    TERMINATED_WITH_ERRORS("TERMINATED_WITH_ERRORS");

    private String value;

    private ClusterState(String value) {
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
     * @return ClusterState corresponding to the value
     */
    public static ClusterState fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("STARTING".equals(value)) {
            return STARTING;
        } else if ("BOOTSTRAPPING".equals(value)) {
            return BOOTSTRAPPING;
        } else if ("RUNNING".equals(value)) {
            return RUNNING;
        } else if ("WAITING".equals(value)) {
            return WAITING;
        } else if ("TERMINATING".equals(value)) {
            return TERMINATING;
        } else if ("TERMINATED".equals(value)) {
            return TERMINATED;
        } else if ("TERMINATED_WITH_ERRORS".equals(value)) {
            return TERMINATED_WITH_ERRORS;
        } else {
            throw new IllegalArgumentException("Cannot create enum from "
                    + value + " value!");
        }
    }
}