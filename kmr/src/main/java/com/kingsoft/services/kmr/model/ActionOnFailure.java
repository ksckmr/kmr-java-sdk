package com.kingsoft.services.kmr.model;


public enum ActionOnFailure {

    TERMINATE_JOB_FLOW("TERMINATE_JOB_FLOW"),
    TERMINATE_CLUSTER("TERMINATE_CLUSTER"),
    CANCEL_AND_WAIT("CANCEL_AND_WAIT"),
    CONTINUE("CONTINUE");

    private String value;

    private ActionOnFailure(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static ActionOnFailure fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("TERMINATE_JOB_FLOW".equals(value)) {
            return TERMINATE_JOB_FLOW;
        } else if ("TERMINATE_CLUSTER".equals(value)) {
            return TERMINATE_CLUSTER;
        } else if ("CANCEL_AND_WAIT".equals(value)) {
            return CANCEL_AND_WAIT;
        } else if ("CONTINUE".equals(value)) {
            return CONTINUE;
        } else {
            throw new IllegalArgumentException("Cannot create enum from "
                    + value + " value!");
        }
    }
}
