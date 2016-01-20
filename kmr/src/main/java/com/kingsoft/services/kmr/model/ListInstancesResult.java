package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This output contains the list of instances.
 * </p>
 */
public class ListInstancesResult implements Serializable, Cloneable {

    /**
     * <p>
     * The list of instances for the cluster and given filters.
     * </p>
     */
    private List<Instance> instances;
    /**
     * <p>
     * The pagination token that indicates the next set of results to retrieve.
     * </p>
     */
    private String marker;

    /**
     * <p>
     * The list of instances for the cluster and given filters.
     * </p>
     * 
     * @return The list of instances for the cluster and given filters.
     */
    public java.util.List<Instance> getInstances() {
        if (instances == null) {
            instances = new ArrayList<Instance>();
        }
        return instances;
    }

    /**
     * <p>
     * The list of instances for the cluster and given filters.
     * </p>
     * 
     * @param instances
     *        The list of instances for the cluster and given filters.
     */
    public void setInstances(java.util.Collection<Instance> instances) {
        if (instances == null) {
            this.instances = null;
            return;
        }

        this.instances = new ArrayList<Instance>(
                instances);
    }

    /**
     * <p>
     * The list of instances for the cluster and given filters.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setInstances(java.util.Collection)} or
     * {@link #withInstances(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param instances
     *        The list of instances for the cluster and given filters.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ListInstancesResult withInstances(Instance... instances) {
        if (this.instances == null) {
            setInstances(new ArrayList<Instance>(
                    instances.length));
        }
        for (Instance ele : instances) {
            this.instances.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The list of instances for the cluster and given filters.
     * </p>
     * 
     * @param instances
     *        The list of instances for the cluster and given filters.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ListInstancesResult withInstances(
            java.util.Collection<Instance> instances) {
        setInstances(instances);
        return this;
    }

    /**
     * <p>
     * The pagination token that indicates the next set of results to retrieve.
     * </p>
     * 
     * @param marker
     *        The pagination token that indicates the next set of results to
     *        retrieve.
     */
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * <p>
     * The pagination token that indicates the next set of results to retrieve.
     * </p>
     * 
     * @return The pagination token that indicates the next set of results to
     *         retrieve.
     */
    public String getMarker() {
        return this.marker;
    }

    /**
     * <p>
     * The pagination token that indicates the next set of results to retrieve.
     * </p>
     * 
     * @param marker
     *        The pagination token that indicates the next set of results to
     *        retrieve.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ListInstancesResult withMarker(String marker) {
        setMarker(marker);
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
        if (getInstances() != null)
            sb.append("Instances: " + getInstances() + ",");
        if (getMarker() != null)
            sb.append("Marker: " + getMarker());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ListInstancesResult == false)
            return false;
        ListInstancesResult other = (ListInstancesResult) obj;
        if (other.getInstances() == null ^ this.getInstances() == null)
            return false;
        if (other.getInstances() != null
                && other.getInstances().equals(this.getInstances()) == false)
            return false;
        if (other.getMarker() == null ^ this.getMarker() == null)
            return false;
        if (other.getMarker() != null
                && other.getMarker().equals(this.getMarker()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getInstances() == null) ? 0 : getInstances().hashCode());
        hashCode = prime * hashCode
                + ((getMarker() == null) ? 0 : getMarker().hashCode());
        return hashCode;
    }

    @Override
    public ListInstancesResult clone() {
        try {
            return (ListInstancesResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}