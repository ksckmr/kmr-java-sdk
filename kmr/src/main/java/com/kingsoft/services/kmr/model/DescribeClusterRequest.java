package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import com.kingsoft.services.RequestMessage;

/**
 * <p>
 * This input determines which cluster to describe.
 * </p>
 */
public class DescribeClusterRequest extends RequestMessage implements
        Serializable, Cloneable {

    /**
     * <p>
     * The identifier of the cluster to describe.
     * </p>
     */
    private String clusterId;

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
    public DescribeClusterRequest withClusterId(String clusterId) {
        setClusterId(clusterId);
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
            sb.append("ClusterId: " + getClusterId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DescribeClusterRequest == false)
            return false;
        DescribeClusterRequest other = (DescribeClusterRequest) obj;
        if (other.getClusterId() == null ^ this.getClusterId() == null)
            return false;
        if (other.getClusterId() != null
                && other.getClusterId().equals(this.getClusterId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getClusterId() == null) ? 0 : getClusterId().hashCode());
        return hashCode;
    }

    @Override
    public DescribeClusterRequest clone() {
        return (DescribeClusterRequest) super.clone();
    }
}