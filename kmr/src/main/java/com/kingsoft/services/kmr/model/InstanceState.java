package com.kingsoft.services.kmr.model;

/**
 * 
 */
public enum InstanceState {

    AWAITING_FULFILLMENT("AWAITING_FULFILLMENT"),
    PROVISIONING("PROVISIONING"),
    BOOTSTRAPPING("BOOTSTRAPPING"),
    RUNNING("RUNNING"),
    TERMINATED("TERMINATED");

    private String value;

    private InstanceState(String value) {
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
     * @return InstanceState corresponding to the value
     */
    public static InstanceState fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("AWAITING_FULFILLMENT".equals(value)) {
            return AWAITING_FULFILLMENT;
        } else if ("PROVISIONING".equals(value)) {
            return PROVISIONING;
        } else if ("BOOTSTRAPPING".equals(value)) {
            return BOOTSTRAPPING;
        } else if ("RUNNING".equals(value)) {
            return RUNNING;
        } else if ("TERMINATED".equals(value)) {
            return TERMINATED;
        } else {
            throw new IllegalArgumentException("Cannot create enum from "
                    + value + " value!");
        }
    }
}