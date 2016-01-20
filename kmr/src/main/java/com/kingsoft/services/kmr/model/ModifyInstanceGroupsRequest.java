package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import com.kingsoft.services.RequestMessage;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * Change the size of some instance groups.
 * </p>
 */
public class ModifyInstanceGroupsRequest extends RequestMessage
        implements Serializable, Cloneable {

    /**
     * <p>
     * Instance groups to change.
     * </p>
     */
    private String clusterId;
    private List<InstanceGroupModifyConfig> instanceGroups;

    /**
     * Default constructor for ModifyInstanceGroupsRequest object. Callers
     * should use the setter or fluent setter (with...) methods to initialize
     * the object after creating it.
     */
    public ModifyInstanceGroupsRequest() {
    }

    /**
     * Constructs a new ModifyInstanceGroupsRequest object. Callers should use
     * the setter or fluent setter (with...) methods to initialize any
     * additional object members.
     * 
     * @param instanceGroups
     *        Instance groups to change.
     */
    public ModifyInstanceGroupsRequest(
            java.util.List<InstanceGroupModifyConfig> instanceGroups) {
        setInstanceGroups(instanceGroups);
    }

    /**
     * <p>
     * The identifier of the cluster to describe.
     * </p>
     *
     * @param clusterId
     *        The identifier of the cluster to describe.
     */
    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    /**
     * <p>
     * The identifier of the cluster to describe.
     * </p>
     *
     * @return The identifier of the cluster to describe.
     */
    public String getClusterId() {
        return this.clusterId;
    }

    /**
     * <p>
     * The identifier of the cluster to describe.
     * </p>
     *
     * @param clusterId
     *        The identifier of the cluster to describe.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ModifyInstanceGroupsRequest withClusterId(String clusterId) {
        setClusterId(clusterId);
        return this;
    }
    /**
     * <p>
     * Instance groups to change.
     * </p>
     * 
     * @return Instance groups to change.
     */
    public java.util.List<InstanceGroupModifyConfig> getInstanceGroups() {
        if (instanceGroups == null) {
            instanceGroups = new ArrayList<InstanceGroupModifyConfig>();
        }
        return instanceGroups;
    }

    /**
     * <p>
     * Instance groups to change.
     * </p>
     * 
     * @param instanceGroups
     *        Instance groups to change.
     */
    public void setInstanceGroups(
            java.util.Collection<InstanceGroupModifyConfig> instanceGroups) {
        if (instanceGroups == null) {
            this.instanceGroups = null;
            return;
        }

        this.instanceGroups = new ArrayList<InstanceGroupModifyConfig>(
                instanceGroups);
    }

    /**
     * <p>
     * Instance groups to change.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setInstanceGroups(java.util.Collection)} or
     * {@link #withInstanceGroups(java.util.Collection)} if you want to override
     * the existing values.
     * </p>
     * 
     * @param instanceGroups
     *        Instance groups to change.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ModifyInstanceGroupsRequest withInstanceGroups(
            InstanceGroupModifyConfig... instanceGroups) {
        if (this.instanceGroups == null) {
            setInstanceGroups(new ArrayList<InstanceGroupModifyConfig>(
                    instanceGroups.length));
        }
        for (InstanceGroupModifyConfig ele : instanceGroups) {
            this.instanceGroups.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * Instance groups to change.
     * </p>
     * 
     * @param instanceGroups
     *        Instance groups to change.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ModifyInstanceGroupsRequest withInstanceGroups(
            java.util.Collection<InstanceGroupModifyConfig> instanceGroups) {
        setInstanceGroups(instanceGroups);
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
        if (getInstanceGroups() != null)
            sb.append("InstanceGroups: " + getInstanceGroups());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ModifyInstanceGroupsRequest == false)
            return false;
        ModifyInstanceGroupsRequest other = (ModifyInstanceGroupsRequest) obj;
        if (other.getClusterId() == null ^ this.getClusterId() == null)
            return false;
        if (other.getClusterId() != null
                && other.getClusterId().equals(this.getClusterId()) == false)
            return false;
        if (other.getInstanceGroups() == null
                ^ this.getInstanceGroups() == null)
            return false;
        if (other.getInstanceGroups() != null
                && other.getInstanceGroups().equals(this.getInstanceGroups()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime
                * hashCode
                + ((getClusterId() == null) ? 0 : getClusterId()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getInstanceGroups() == null) ? 0 : getInstanceGroups()
                        .hashCode());
        return hashCode;
    }

    @Override
    public ModifyInstanceGroupsRequest clone() {
        return (ModifyInstanceGroupsRequest) super.clone();
    }
}