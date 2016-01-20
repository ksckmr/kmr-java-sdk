package com.kingsoft.services.kmr.model;


import java.io.Serializable;

/**
 * <p>
 * The summary description of the cluster.
 * </p>
 */
public class ClusterSummary implements Serializable, Cloneable {

    /**
     * <p>
     * The unique identifier for the cluster.
     * </p>
     */
    private String id;
    /**
     * <p>
     * The name of the cluster.
     * </p>
     */
    private String name;
    /**
     * <p>
     * The details about the current status of the cluster.
     * </p>
     */
    private ClusterStatus status;
    /**
     * <p>
     * An approximation of the cost of the job flow, represented in
     * m1.small/hours. This value is incremented one time for every hour an
     * m1.small instance runs. Larger instances are weighted more, so an 
     * instance that is roughly four times more expensive would result in the
     * normalized instance hours being incremented by four. This result is only
     * an approximation and does not reflect the actual billing rate.
     * </p>
     */
    private Integer normalizedInstanceMins;

    /**
     * <p>
     * The unique identifier for the cluster.
     * </p>
     * 
     * @param id
     *        The unique identifier for the cluster.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>
     * The unique identifier for the cluster.
     * </p>
     * 
     * @return The unique identifier for the cluster.
     */
    public String getId() {
        return this.id;
    }

    /**
     * <p>
     * The unique identifier for the cluster.
     * </p>
     * 
     * @param id
     *        The unique identifier for the cluster.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ClusterSummary withId(String id) {
        setId(id);
        return this;
    }

    /**
     * <p>
     * The name of the cluster.
     * </p>
     * 
     * @param name
     *        The name of the cluster.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>
     * The name of the cluster.
     * </p>
     * 
     * @return The name of the cluster.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>
     * The name of the cluster.
     * </p>
     * 
     * @param name
     *        The name of the cluster.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ClusterSummary withName(String name) {
        setName(name);
        return this;
    }

    /**
     * <p>
     * The details about the current status of the cluster.
     * </p>
     * 
     * @param status
     *        The details about the current status of the cluster.
     */
    public void setStatus(ClusterStatus status) {
        this.status = status;
    }

    /**
     * <p>
     * The details about the current status of the cluster.
     * </p>
     * 
     * @return The details about the current status of the cluster.
     */
    public ClusterStatus getStatus() {
        return this.status;
    }

    /**
     * <p>
     * The details about the current status of the cluster.
     * </p>
     * 
     * @param status
     *        The details about the current status of the cluster.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ClusterSummary withStatus(ClusterStatus status) {
        setStatus(status);
        return this;
    }

    /**
     * <p>
     * An approximation of the cost of the job flow, represented in
     * m1.small/hours. This value is incremented one time for every hour an
     * m1.small instance runs. Larger instances are weighted more, so an 
     * instance that is roughly four times more expensive would result in the
     * normalized instance hours being incremented by four. This result is only
     * an approximation and does not reflect the actual billing rate.
     * </p>
     * 
     * @param normalizedInstanceMins
     *        An approximation of the cost of the job flow, represented in
     *        m1.small/hours. This value is incremented one time for every hour
     *        an m1.small instance runs. Larger instances are weighted more, so
     *        an  instance that is roughly four times more expensive would
     *        result in the normalized instance hours being incremented by four.
     *        This result is only an approximation and does not reflect the
     *        actual billing rate.
     */
    public void setNormalizedInstanceMins(Integer normalizedInstanceMins) {
        this.normalizedInstanceMins = normalizedInstanceMins;
    }

    /**
     * <p>
     * An approximation of the cost of the job flow, represented in
     * m1.small/hours. This value is incremented one time for every hour an
     * m1.small instance runs. Larger instances are weighted more, so an 
     * instance that is roughly four times more expensive would result in the
     * normalized instance hours being incremented by four. This result is only
     * an approximation and does not reflect the actual billing rate.
     * </p>
     * 
     * @return An approximation of the cost of the job flow, represented in
     *         m1.small/hours. This value is incremented one time for every hour
     *         an m1.small instance runs. Larger instances are weighted more, so
     *         an  instance that is roughly four times more expensive would
     *         result in the normalized instance hours being incremented by
     *         four. This result is only an approximation and does not reflect
     *         the actual billing rate.
     */
    public Integer getNormalizedInstanceMins() {
        return this.normalizedInstanceMins;
    }

    /**
     * <p>
     * An approximation of the cost of the job flow, represented in
     * m1.small/hours. This value is incremented one time for every hour an
     * m1.small instance runs. Larger instances are weighted more, so an 
     * instance that is roughly four times more expensive would result in the
     * normalized instance hours being incremented by four. This result is only
     * an approximation and does not reflect the actual billing rate.
     * </p>
     * 
     * @param normalizedInstanceMins
     *        An approximation of the cost of the job flow, represented in
     *        m1.small/hours. This value is incremented one time for every hour
     *        an m1.small instance runs. Larger instances are weighted more, so
     *        an  instance that is roughly four times more expensive would
     *        result in the normalized instance hours being incremented by four.
     *        This result is only an approximation and does not reflect the
     *        actual billing rate.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ClusterSummary withNormalizedInstanceMins(
            Integer normalizedInstanceMins) {
        setNormalizedInstanceMins(normalizedInstanceMins);
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
        if (getStatus() != null)
            sb.append("Status: " + getStatus() + ",");
        if (getNormalizedInstanceMins() != null)
            sb.append("NormalizedInstanceMins: "
                    + getNormalizedInstanceMins());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ClusterSummary == false)
            return false;
        ClusterSummary other = (ClusterSummary) obj;
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
        if (other.getStatus() == null ^ this.getStatus() == null)
            return false;
        if (other.getStatus() != null
                && other.getStatus().equals(this.getStatus()) == false)
            return false;
        if (other.getNormalizedInstanceMins() == null
                ^ this.getNormalizedInstanceMins() == null)
            return false;
        if (other.getNormalizedInstanceMins() != null
                && other.getNormalizedInstanceMins().equals(
                        this.getNormalizedInstanceMins()) == false)
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
        hashCode = prime * hashCode
                + ((getStatus() == null) ? 0 : getStatus().hashCode());
        hashCode = prime
                * hashCode
                + ((getNormalizedInstanceMins() == null) ? 0
                        : getNormalizedInstanceMins().hashCode());
        return hashCode;
    }

    @Override
    public ClusterSummary clone() {
        try {
            return (ClusterSummary) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
