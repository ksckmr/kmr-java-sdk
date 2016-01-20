package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * Modify an instance group size.
 * </p>
 */
public class InstanceGroupModifyConfig implements Serializable, Cloneable {

    /**
     * <p>
     * Unique ID of the instance group to expand or shrink.
     * </p>
     */
    private String instanceGroupId;
    /**
     * <p>
     * Target size for the instance group.
     * </p>
     */
    private Integer instanceCount;
    /**
     * <p>
     * The InstanceIds to terminate. For advanced users only. Once you
     * terminate the instances, the instance group will not return to its
     * original requested size.
     * </p>
     */
    private List<String> InstanceIdsToTerminate;

    /**
     * Default constructor for InstanceGroupModifyConfig object. Callers should
     * use the setter or fluent setter (with...) methods to initialize the
     * object after creating it.
     */
    public InstanceGroupModifyConfig() {
    }

    /**
     * Constructs a new InstanceGroupModifyConfig object. Callers should use the
     * setter or fluent setter (with...) methods to initialize any additional
     * object members.
     * 
     * @param instanceGroupId
     *        Unique ID of the instance group to expand or shrink.
     * @param instanceCount
     *        Target size for the instance group.
     */
    public InstanceGroupModifyConfig(String instanceGroupId,
            Integer instanceCount) {
        setInstanceGroupId(instanceGroupId);
        setInstanceCount(instanceCount);
    }

    /**
     * <p>
     * Unique ID of the instance group to expand or shrink.
     * </p>
     * 
     * @param instanceGroupId
     *        Unique ID of the instance group to expand or shrink.
     */
    public void setInstanceGroupId(String instanceGroupId) {
        this.instanceGroupId = instanceGroupId;
    }

    /**
     * <p>
     * Unique ID of the instance group to expand or shrink.
     * </p>
     * 
     * @return Unique ID of the instance group to expand or shrink.
     */
    public String getInstanceGroupId() {
        return this.instanceGroupId;
    }

    /**
     * <p>
     * Unique ID of the instance group to expand or shrink.
     * </p>
     * 
     * @param instanceGroupId
     *        Unique ID of the instance group to expand or shrink.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroupModifyConfig withInstanceGroupId(String instanceGroupId) {
        setInstanceGroupId(instanceGroupId);
        return this;
    }

    /**
     * <p>
     * Target size for the instance group.
     * </p>
     * 
     * @param instanceCount
     *        Target size for the instance group.
     */
    public void setInstanceCount(Integer instanceCount) {
        this.instanceCount = instanceCount;
    }

    /**
     * <p>
     * Target size for the instance group.
     * </p>
     * 
     * @return Target size for the instance group.
     */
    public Integer getInstanceCount() {
        return this.instanceCount;
    }

    /**
     * <p>
     * Target size for the instance group.
     * </p>
     * 
     * @param instanceCount
     *        Target size for the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroupModifyConfig withInstanceCount(Integer instanceCount) {
        setInstanceCount(instanceCount);
        return this;
    }

    /**
     * <p>
     * The  InstanceIds to terminate. For advanced users only. Once you
     * terminate the instances, the instance group will not return to its
     * original requested size.
     * </p>
     * 
     * @return The  InstanceIds to terminate. For advanced users only. Once
     *         you terminate the instances, the instance group will not return
     *         to its original requested size.
     */
    public java.util.List<String> getInstanceIdsToTerminate() {
        if (InstanceIdsToTerminate == null) {
            InstanceIdsToTerminate = new ArrayList<String>();
        }
        return InstanceIdsToTerminate;
    }

    /**
     * <p>
     * The  InstanceIds to terminate. For advanced users only. Once you
     * terminate the instances, the instance group will not return to its
     * original requested size.
     * </p>
     * 
     * @param InstanceIdsToTerminate
     *        The  InstanceIds to terminate. For advanced users only. Once
     *        you terminate the instances, the instance group will not return to
     *        its original requested size.
     */
    public void setInstanceIdsToTerminate(
            java.util.Collection<String> InstanceIdsToTerminate) {
        if (InstanceIdsToTerminate == null) {
            this.InstanceIdsToTerminate = null;
            return;
        }

        this.InstanceIdsToTerminate = new ArrayList<String>(
                InstanceIdsToTerminate);
    }

    /**
     * <p>
     * The  InstanceIds to terminate. For advanced users only. Once you
     * terminate the instances, the instance group will not return to its
     * original requested size.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setInstanceIdsToTerminate(java.util.Collection)} or
     * {@link #withInstanceIdsToTerminate(java.util.Collection)} if you want
     * to override the existing values.
     * </p>
     * 
     * @param InstanceIdsToTerminate
     *        The  InstanceIds to terminate. For advanced users only. Once
     *        you terminate the instances, the instance group will not return to
     *        its original requested size.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroupModifyConfig withInstanceIdsToTerminate(
            String... InstanceIdsToTerminate) {
        if (this.InstanceIdsToTerminate == null) {
            setInstanceIdsToTerminate(new ArrayList<String>(
                    InstanceIdsToTerminate.length));
        }
        for (String ele : InstanceIdsToTerminate) {
            this.InstanceIdsToTerminate.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The  InstanceIds to terminate. For advanced users only. Once you
     * terminate the instances, the instance group will not return to its
     * original requested size.
     * </p>
     * 
     * @param InstanceIdsToTerminate
     *        The  InstanceIds to terminate. For advanced users only. Once
     *        you terminate the instances, the instance group will not return to
     *        its original requested size.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroupModifyConfig withInstanceIdsToTerminate(
            java.util.Collection<String> InstanceIdsToTerminate) {
        setInstanceIdsToTerminate(InstanceIdsToTerminate);
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
        if (getInstanceGroupId() != null)
            sb.append("InstanceGroupId: " + getInstanceGroupId() + ",");
        if (getInstanceCount() != null)
            sb.append("InstanceCount: " + getInstanceCount() + ",");
        if (getInstanceIdsToTerminate() != null)
            sb.append("InstanceIdsToTerminate: "
                    + getInstanceIdsToTerminate());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof InstanceGroupModifyConfig == false)
            return false;
        InstanceGroupModifyConfig other = (InstanceGroupModifyConfig) obj;
        if (other.getInstanceGroupId() == null
                ^ this.getInstanceGroupId() == null)
            return false;
        if (other.getInstanceGroupId() != null
                && other.getInstanceGroupId().equals(this.getInstanceGroupId()) == false)
            return false;
        if (other.getInstanceCount() == null ^ this.getInstanceCount() == null)
            return false;
        if (other.getInstanceCount() != null
                && other.getInstanceCount().equals(this.getInstanceCount()) == false)
            return false;
        if (other.getInstanceIdsToTerminate() == null
                ^ this.getInstanceIdsToTerminate() == null)
            return false;
        if (other.getInstanceIdsToTerminate() != null
                && other.getInstanceIdsToTerminate().equals(
                        this.getInstanceIdsToTerminate()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime
                * hashCode
                + ((getInstanceGroupId() == null) ? 0 : getInstanceGroupId()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getInstanceCount() == null) ? 0 : getInstanceCount()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getInstanceIdsToTerminate() == null) ? 0
                        : getInstanceIdsToTerminate().hashCode());
        return hashCode;
    }

    @Override
    public InstanceGroupModifyConfig clone() {
        try {
            return (InstanceGroupModifyConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
