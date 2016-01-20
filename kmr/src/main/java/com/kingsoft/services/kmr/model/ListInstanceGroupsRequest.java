package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import com.kingsoft.services.RequestMessage;

/**
 * <p>
 * This input determines which instance groups to retrieve.
 * </p>
 */
public class ListInstanceGroupsRequest extends RequestMessage
        implements Serializable, Cloneable {

    /**
     * <p>
     * The identifier of the cluster for which to list the instance groups.
     * </p>
     */
    private String clusterId;
    /**
     * <p>
     * The pagination token that indicates the next set of results to retrieve.
     * </p>
     */
    private String marker;

    /**
     * <p>
     * The identifier of the cluster for which to list the instance groups.
     * </p>
     * 
     * @param clusterId
     *        The identifier of the cluster for which to list the instance
     *        groups.
     */
    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    /**
     * <p>
     * The identifier of the cluster for which to list the instance groups.
     * </p>
     * 
     * @return The identifier of the cluster for which to list the instance
     *         groups.
     */
    public String getClusterId() {
        return this.clusterId;
    }

    /**
     * <p>
     * The identifier of the cluster for which to list the instance groups.
     * </p>
     * 
     * @param clusterId
     *        The identifier of the cluster for which to list the instance
     *        groups.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ListInstanceGroupsRequest withClusterId(String clusterId) {
        setClusterId(clusterId);
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
    public ListInstanceGroupsRequest withMarker(String marker) {
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
        if (getClusterId() != null)
            sb.append("ClusterId: " + getClusterId() + ",");
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

        if (obj instanceof ListInstanceGroupsRequest == false)
            return false;
        ListInstanceGroupsRequest other = (ListInstanceGroupsRequest) obj;
        if (other.getClusterId() == null ^ this.getClusterId() == null)
            return false;
        if (other.getClusterId() != null
                && other.getClusterId().equals(this.getClusterId()) == false)
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
                + ((getClusterId() == null) ? 0 : getClusterId().hashCode());
        hashCode = prime * hashCode
                + ((getMarker() == null) ? 0 : getMarker().hashCode());
        return hashCode;
    }

    @Override
    public ListInstanceGroupsRequest clone() {
        return (ListInstanceGroupsRequest) super.clone();
    }
}