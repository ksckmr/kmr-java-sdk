package com.kingsoft.services.kmr.model;

/**
 * 
 */
public enum StepState {

    PENDING("PENDING"),
    RUNNING("RUNNING"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED"),
    FAILED("FAILED"),
    INTERRUPTED("INTERRUPTED");

    private String value;

    private StepState(String value) {
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
     * @return StepState corresponding to the value
     */
    public static StepState fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("PENDING".equals(value)) {
            return PENDING;
        } else if ("RUNNING".equals(value)) {
            return RUNNING;
        } else if ("COMPLETED".equals(value)) {
            return COMPLETED;
        } else if ("CANCELLED".equals(value)) {
            return CANCELLED;
        } else if ("FAILED".equals(value)) {
            return FAILED;
        } else if ("INTERRUPTED".equals(value)) {
            return INTERRUPTED;
        } else {
            throw new IllegalArgumentException("Cannot create enum from "
                    + value + " value!");
        }
    }
}