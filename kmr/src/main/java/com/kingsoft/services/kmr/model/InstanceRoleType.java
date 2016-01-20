package com.kingsoft.services.kmr.model;

public enum InstanceRoleType {

    MASTER("MASTER"),
    CORE("CORE"),
    TASK("TASK");

    private String value;

    private InstanceRoleType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    public static InstanceRoleType fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("MASTER".equals(value)) {
            return MASTER;
        } else if ("CORE".equals(value)) {
            return CORE;
        } else if ("TASK".equals(value)) {
            return TASK;
        } else {
            throw new IllegalArgumentException("Cannot create enum from "
                    + value + " value!");
        }
    }
}
