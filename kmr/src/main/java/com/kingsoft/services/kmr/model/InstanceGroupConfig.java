package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class InstanceGroupConfig implements Serializable, Cloneable {

    private String instanceRole;

    private String instanceType;
    private Integer instanceCount;
    
    public InstanceGroupConfig() {
    }

   
    public InstanceGroupConfig(String instanceRole, String instanceType,
            Integer instanceCount) {
        setInstanceRole(instanceRole);
        setInstanceType(instanceType);
        setInstanceCount(instanceCount);
    }

    public InstanceGroupConfig(InstanceRoleType instanceRole,
            String instanceType, Integer instanceCount) {
        setInstanceRole(instanceRole.toString());
        setInstanceType(instanceType);
        setInstanceCount(instanceCount);
    }

    public void setInstanceRole(String instanceRole) {
        this.instanceRole = instanceRole;
    }


    public String getInstanceRole() {
        return this.instanceRole;
    }

    public InstanceGroupConfig withInstanceRole(String instanceRole) {
        setInstanceRole(instanceRole);
        return this;
    }

    public void setInstanceRole(InstanceRoleType instanceRole) {
        this.instanceRole = instanceRole.toString();
    }

    public InstanceGroupConfig withInstanceRole(InstanceRoleType instanceRole) {
        setInstanceRole(instanceRole);
        return this;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public InstanceGroupConfig withInstanceType(String instanceType) {
        setInstanceType(instanceType);
        return this;
    }

    public void setInstanceCount(Integer instanceCount) {
        this.instanceCount = instanceCount;
    }

    public Integer getInstanceCount() {
        return this.instanceCount;
    }

    public InstanceGroupConfig withInstanceCount(Integer instanceCount) {
        setInstanceCount(instanceCount);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getInstanceRole() != null)
            sb.append("InstanceRole: " + getInstanceRole() + ",");
        if (getInstanceType() != null)
            sb.append("InstanceType: " + getInstanceType() + ",");
        if (getInstanceCount() != null)
            sb.append("InstanceCount: " + getInstanceCount());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof InstanceGroupConfig == false)
            return false;
        InstanceGroupConfig other = (InstanceGroupConfig) obj;
        if (other.getInstanceRole() == null ^ this.getInstanceRole() == null)
            return false;
        if (other.getInstanceRole() != null
                && other.getInstanceRole().equals(this.getInstanceRole()) == false)
            return false;
        if (other.getInstanceType() == null ^ this.getInstanceType() == null)
            return false;
        if (other.getInstanceType() != null
                && other.getInstanceType().equals(this.getInstanceType()) == false)
            return false;
        if (other.getInstanceCount() == null ^ this.getInstanceCount() == null)
            return false;
        if (other.getInstanceCount() != null
                && other.getInstanceCount().equals(this.getInstanceCount()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime
                * hashCode
                + ((getInstanceRole() == null) ? 0 : getInstanceRole()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getInstanceType() == null) ? 0 : getInstanceType()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getInstanceCount() == null) ? 0 : getInstanceCount()
                        .hashCode());
        return hashCode;
    }

    @Override
    public InstanceGroupConfig clone() {
        try {
            return (InstanceGroupConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
