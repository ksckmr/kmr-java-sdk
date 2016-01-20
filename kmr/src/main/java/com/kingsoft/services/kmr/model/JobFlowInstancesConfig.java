package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import java.util.*;

/**
 * instance配置
 */
public class JobFlowInstancesConfig implements Serializable, Cloneable {

    /**
     * instance groups配置.
     */
    private List<InstanceGroupConfig> instanceGroups;

    /**
     * Specifies whether the job flow should be kept alive after completing all
     * steps.
     */
    private Boolean keepJobFlowAliveWhenNoSteps;

    /**
     * Specifies whether to lock the job flow to prevent the
     * instances from being terminated by API call, user intervention, or in the
     * event of a job flow error.
     */
    private Boolean terminationProtected;

    public java.util.List<InstanceGroupConfig> getInstanceGroups() {
        if (instanceGroups == null) {
            instanceGroups = new ArrayList<InstanceGroupConfig>();
        }
        return instanceGroups;
    }


    public void setInstanceGroups(
            java.util.Collection<InstanceGroupConfig> instanceGroups) {
        if (instanceGroups == null) {
            this.instanceGroups = null;
            return;
        }

        this.instanceGroups = new ArrayList<InstanceGroupConfig>(
                instanceGroups);
    }

    public JobFlowInstancesConfig withInstanceGroups(
            InstanceGroupConfig... instanceGroups) {
        if (this.instanceGroups == null) {
            setInstanceGroups(new ArrayList<InstanceGroupConfig>(
                    instanceGroups.length));
        }
        for (InstanceGroupConfig ele : instanceGroups) {
            this.instanceGroups.add(ele);
        }
        return this;
    }

    public JobFlowInstancesConfig withInstanceGroups(
            java.util.Collection<InstanceGroupConfig> instanceGroups) {
        setInstanceGroups(instanceGroups);
        return this;
    }


    public void setKeepJobFlowAliveWhenNoSteps(
            Boolean keepJobFlowAliveWhenNoSteps) {
        this.keepJobFlowAliveWhenNoSteps = keepJobFlowAliveWhenNoSteps;
    }

    public Boolean getKeepJobFlowAliveWhenNoSteps() {
        return this.keepJobFlowAliveWhenNoSteps;
    }

    public JobFlowInstancesConfig withKeepJobFlowAliveWhenNoSteps(
            Boolean keepJobFlowAliveWhenNoSteps) {
        setKeepJobFlowAliveWhenNoSteps(keepJobFlowAliveWhenNoSteps);
        return this;
    }

    public Boolean isKeepJobFlowAliveWhenNoSteps() {
        return this.keepJobFlowAliveWhenNoSteps;
    }

    public void setTerminationProtected(Boolean terminationProtected) {
        this.terminationProtected = terminationProtected;
    }

    public Boolean getTerminationProtected() {
        return this.terminationProtected;
    }

    public JobFlowInstancesConfig withTerminationProtected(
            Boolean terminationProtected) {
        setTerminationProtected(terminationProtected);
        return this;
    }

    public Boolean isTerminationProtected() {
        return this.terminationProtected;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getInstanceGroups() != null)
            sb.append("InstanceGroups: " + getInstanceGroups() + ",");
        if (getKeepJobFlowAliveWhenNoSteps() != null)
            sb.append("KeepJobFlowAliveWhenNoSteps: "
                    + getKeepJobFlowAliveWhenNoSteps() + ",");
        if (getTerminationProtected() != null)
            sb.append("TerminationProtected: " + getTerminationProtected());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof JobFlowInstancesConfig == false)
            return false;
        JobFlowInstancesConfig other = (JobFlowInstancesConfig) obj;
        if (other.getInstanceGroups() == null
                ^ this.getInstanceGroups() == null)
            return false;
        if (other.getInstanceGroups() != null
                && other.getInstanceGroups().equals(this.getInstanceGroups()) == false)
            return false;
        if (other.getKeepJobFlowAliveWhenNoSteps() == null
                ^ this.getKeepJobFlowAliveWhenNoSteps() == null)
            return false;
        if (other.getKeepJobFlowAliveWhenNoSteps() != null
                && other.getKeepJobFlowAliveWhenNoSteps().equals(
                        this.getKeepJobFlowAliveWhenNoSteps()) == false)
            return false;
        if (other.getTerminationProtected() == null
                ^ this.getTerminationProtected() == null)
            return false;
        if (other.getTerminationProtected() != null
                && other.getTerminationProtected().equals(
                        this.getTerminationProtected()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime
                * hashCode
                + ((getInstanceGroups() == null) ? 0 : getInstanceGroups()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getKeepJobFlowAliveWhenNoSteps() == null) ? 0
                        : getKeepJobFlowAliveWhenNoSteps().hashCode());
        hashCode = prime
                * hashCode
                + ((getTerminationProtected() == null) ? 0
                        : getTerminationProtected().hashCode());
        return hashCode;
    }

    @Override
    public JobFlowInstancesConfig clone() {
        try {
            return (JobFlowInstancesConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
