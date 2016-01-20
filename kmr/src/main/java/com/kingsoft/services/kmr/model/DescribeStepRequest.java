package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import com.kingsoft.services.RequestMessage;

/**
 * <p>
 * This input determines which step to describe.
 * </p>
 */
public class DescribeStepRequest extends RequestMessage implements
        Serializable, Cloneable {

    /**
     * <p>
     * The identifier of the cluster with steps to describe.
     * </p>
     */
    private String clusterId;
    /**
     * <p>
     * The identifier of the step to describe.
     * </p>
     */
    private String stepId;

    /**
     * <p>
     * The identifier of the cluster with steps to describe.
     * </p>
     * 
     * @param clusterId
     *        The identifier of the cluster with steps to describe.
     */
    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    /**
     * <p>
     * The identifier of the cluster with steps to describe.
     * </p>
     * 
     * @return The identifier of the cluster with steps to describe.
     */
    public String getClusterId() {
        return this.clusterId;
    }

    /**
     * <p>
     * The identifier of the cluster with steps to describe.
     * </p>
     * 
     * @param clusterId
     *        The identifier of the cluster with steps to describe.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public DescribeStepRequest withClusterId(String clusterId) {
        setClusterId(clusterId);
        return this;
    }

    /**
     * <p>
     * The identifier of the step to describe.
     * </p>
     * 
     * @param stepId
     *        The identifier of the step to describe.
     */
    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    /**
     * <p>
     * The identifier of the step to describe.
     * </p>
     * 
     * @return The identifier of the step to describe.
     */
    public String getStepId() {
        return this.stepId;
    }

    /**
     * <p>
     * The identifier of the step to describe.
     * </p>
     * 
     * @param stepId
     *        The identifier of the step to describe.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public DescribeStepRequest withStepId(String stepId) {
        setStepId(stepId);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClusterId() != null)
            sb.append("ClusterId: " + getClusterId() + ",");
        if (getStepId() != null)
            sb.append("StepId: " + getStepId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DescribeStepRequest == false)
            return false;
        DescribeStepRequest other = (DescribeStepRequest) obj;
        if (other.getClusterId() == null ^ this.getClusterId() == null)
            return false;
        if (other.getClusterId() != null
                && other.getClusterId().equals(this.getClusterId()) == false)
            return false;
        if (other.getStepId() == null ^ this.getStepId() == null)
            return false;
        if (other.getStepId() != null
                && other.getStepId().equals(this.getStepId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getClusterId() == null) ? 0 : getClusterId().hashCode());
        hashCode = prime * hashCode
                + ((getStepId() == null) ? 0 : getStepId().hashCode());
        return hashCode;
    }

    @Override
    public DescribeStepRequest clone() {
        return (DescribeStepRequest) super.clone();
    }
}