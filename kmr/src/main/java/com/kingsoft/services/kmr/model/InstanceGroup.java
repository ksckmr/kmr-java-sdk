package com.kingsoft.services.kmr.model;

import java.io.Serializable;

/**
 * <p>
 * This entity represents an instance group, which is a group of instances that
 * have common purpose. For example, CORE instance group is used for HDFS.
 * </p>
 */
public class InstanceGroup implements Serializable, Cloneable {

    /**
     * <p>
     * The identifier of the instance group.
     * </p>
     */
    private String id;
    /**
     * <p>
     * The name of the instance group.
     * </p>
     */
    private String name;

    /**
     * <p>
     * The type of the instance group. Valid values are MASTER, CORE or TASK.
     * </p>
     */
    private String instanceGroupType;

    /**
     * <p>
     * The instance type for all instances in the instance group.
     * </p>
     */
    private String instanceType;
    /**
     * <p>
     * The target number of instances for the instance group.
     * </p>
     */
    private Integer requestedInstanceCount;

    /**
     * <p>
     * The current status of the instance group.
     * </p>
     */
    private InstanceGroupStatus status;


    /**
     * <p>
     * The identifier of the instance group.
     * </p>
     * 
     * @param id
     *        The identifier of the instance group.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>
     * The identifier of the instance group.
     * </p>
     * 
     * @return The identifier of the instance group.
     */
    public String getId() {
        return this.id;
    }

    /**
     * <p>
     * The identifier of the instance group.
     * </p>
     * 
     * @param id
     *        The identifier of the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroup withId(String id) {
        setId(id);
        return this;
    }

    /**
     * <p>
     * The name of the instance group.
     * </p>
     * 
     * @param name
     *        The name of the instance group.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>
     * The name of the instance group.
     * </p>
     * 
     * @return The name of the instance group.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>
     * The name of the instance group.
     * </p>
     * 
     * @param name
     *        The name of the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroup withName(String name) {
        setName(name);
        return this;
    }


    /**
     * <p>
     * The type of the instance group. Valid values are MASTER, CORE or TASK.
     * </p>
     * 
     * @param instanceGroupType
     *        The type of the instance group. Valid values are MASTER, CORE or
     *        TASK.
     * @see InstanceGroupType
     */
    public void setInstanceGroupType(String instanceGroupType) {
        this.instanceGroupType = instanceGroupType;
    }

    /**
     * <p>
     * The type of the instance group. Valid values are MASTER, CORE or TASK.
     * </p>
     * 
     * @return The type of the instance group. Valid values are MASTER, CORE or
     *         TASK.
     * @see InstanceGroupType
     */
    public String getInstanceGroupType() {
        return this.instanceGroupType;
    }

    /**
     * <p>
     * The type of the instance group. Valid values are MASTER, CORE or TASK.
     * </p>
     * 
     * @param instanceGroupType
     *        The type of the instance group. Valid values are MASTER, CORE or
     *        TASK.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceGroupType
     */
    public InstanceGroup withInstanceGroupType(String instanceGroupType) {
        setInstanceGroupType(instanceGroupType);
        return this;
    }

    /**
     * <p>
     * The type of the instance group. Valid values are MASTER, CORE or TASK.
     * </p>
     * 
     * @param instanceGroupType
     *        The type of the instance group. Valid values are MASTER, CORE or
     *        TASK.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceGroupType
     */
    public void setInstanceGroupType(InstanceGroupType instanceGroupType) {
        this.instanceGroupType = instanceGroupType.toString();
    }

    /**
     * <p>
     * The type of the instance group. Valid values are MASTER, CORE or TASK.
     * </p>
     * 
     * @param instanceGroupType
     *        The type of the instance group. Valid values are MASTER, CORE or
     *        TASK.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceGroupType
     */
    public InstanceGroup withInstanceGroupType(
            InstanceGroupType instanceGroupType) {
        setInstanceGroupType(instanceGroupType);
        return this;
    }

    /**
     * <p>
     * The instance type for all instances in the instance group.
     * </p>
     * 
     * @param instanceType
     *        The instance type for all instances in the instance group.
     */
    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    /**
     * <p>
     * The instance type for all instances in the instance group.
     * </p>
     * 
     * @return The instance type for all instances in the instance group.
     */
    public String getInstanceType() {
        return this.instanceType;
    }

    /**
     * <p>
     * The instance type for all instances in the instance group.
     * </p>
     * 
     * @param instanceType
     *        The instance type for all instances in the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroup withInstanceType(String instanceType) {
        setInstanceType(instanceType);
        return this;
    }

    /**
     * <p>
     * The target number of instances for the instance group.
     * </p>
     * 
     * @param requestedInstanceCount
     *        The target number of instances for the instance group.
     */
    public void setRequestedInstanceCount(Integer requestedInstanceCount) {
        this.requestedInstanceCount = requestedInstanceCount;
    }

    /**
     * <p>
     * The target number of instances for the instance group.
     * </p>
     * 
     * @return The target number of instances for the instance group.
     */
    public Integer getRequestedInstanceCount() {
        return this.requestedInstanceCount;
    }

    /**
     * <p>
     * The target number of instances for the instance group.
     * </p>
     * 
     * @param requestedInstanceCount
     *        The target number of instances for the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroup withRequestedInstanceCount(
            Integer requestedInstanceCount) {
        setRequestedInstanceCount(requestedInstanceCount);
        return this;
    }


    /**
     * <p>
     * The current status of the instance group.
     * </p>
     * 
     * @param status
     *        The current status of the instance group.
     */
    public void setStatus(InstanceGroupStatus status) {
        this.status = status;
    }

    /**
     * <p>
     * The current status of the instance group.
     * </p>
     * 
     * @return The current status of the instance group.
     */
    public InstanceGroupStatus getStatus() {
        return this.status;
    }

    /**
     * <p>
     * The current status of the instance group.
     * </p>
     * 
     * @param status
     *        The current status of the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InstanceGroup withStatus(InstanceGroupStatus status) {
        setStatus(status);
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
        if (getId() != null)
            sb.append("Id: " + getId() + ",");
        if (getName() != null)
            sb.append("Name: " + getName() + ",");
        if (getInstanceGroupType() != null)
            sb.append("InstanceGroupType: " + getInstanceGroupType() + ",");
        if (getInstanceType() != null)
            sb.append("InstanceType: " + getInstanceType() + ",");
        if (getRequestedInstanceCount() != null)
            sb.append("InstanceCount: " + getRequestedInstanceCount()
                    + ",");
        if (getStatus() != null)
            sb.append("Status: " + getStatus() );
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof InstanceGroup == false)
            return false;
        InstanceGroup other = (InstanceGroup) obj;
        if (other.getId() == null ^ this.getId() == null)
            return false;
        if (other.getId() != null
                && other.getId().equals(this.getId()) == false)
            return false;
        if (other.getName() == null ^ this.getName() == null)
            return false;
        if (other.getName() != null
                && other.getName().equals(this.getName()) == false)
            return false;

        if (other.getInstanceGroupType() == null
                ^ this.getInstanceGroupType() == null)
            return false;
        if (other.getInstanceGroupType() != null
                && other.getInstanceGroupType().equals(
                        this.getInstanceGroupType()) == false)
            return false;

        if (other.getInstanceType() == null ^ this.getInstanceType() == null)
            return false;
        if (other.getInstanceType() != null
                && other.getInstanceType().equals(this.getInstanceType()) == false)
            return false;
        if (other.getRequestedInstanceCount() == null
                ^ this.getRequestedInstanceCount() == null)
            return false;
        if (other.getRequestedInstanceCount() != null
                && other.getRequestedInstanceCount().equals(
                        this.getRequestedInstanceCount()) == false)
            return false;

        if (other.getStatus() == null ^ this.getStatus() == null)
            return false;
        if (other.getStatus() != null
                && other.getStatus().equals(this.getStatus()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getId() == null) ? 0 : getId().hashCode());
        hashCode = prime * hashCode
                + ((getName() == null) ? 0 : getName().hashCode());

        hashCode = prime
                * hashCode
                + ((getInstanceGroupType() == null) ? 0
                        : getInstanceGroupType().hashCode());
        hashCode = prime
                * hashCode
                + ((getInstanceType() == null) ? 0 : getInstanceType()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getRequestedInstanceCount() == null) ? 0
                        : getRequestedInstanceCount().hashCode());
        hashCode = prime * hashCode
                + ((getStatus() == null) ? 0 : getStatus().hashCode());

        return hashCode;
    }

    @Override
    public InstanceGroup clone() {
        try {
            return (InstanceGroup) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
