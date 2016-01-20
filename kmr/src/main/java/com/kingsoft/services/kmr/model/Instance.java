package com.kingsoft.services.kmr.model;

import java.io.Serializable;

/**
 * <p>
 * Represents an instance provisioned as part of cluster.
 * </p>
 */
public class Instance implements Serializable, Cloneable {

    /**
     * <p>
     * The unique identifier for the instance in KMR.
     * </p>
     */
    private String id;


    /**
     * <p>
     * The public IP address of the instance.
     * </p>
     */
    private String publicIpAddress;

    /**
     * <p>
     * The private IP address of the instance.
     * </p>
     */
    private String privateIpAddress;
    /**
     * <p>
     * The current status of the instance.
     * </p>
     */
    private InstanceStatus status;

    /**
     * <p>
     * The unique identifier for the instance in KMR.
     * </p>
     * 
     * @param id
     *        The unique identifier for the instance in KMR.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>
     * The unique identifier for the instance in KMR.
     * </p>
     * 
     * @return The unique identifier for the instance in KMR.
     */
    public String getId() {
        return this.id;
    }

    /**
     * <p>
     * The unique identifier for the instance in KMR.
     * </p>
     * 
     * @param id
     *        The unique identifier for the instance in KMR.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Instance withId(String id) {
        setId(id);
        return this;
    }

    /**
     * <p>
     * The public IP address of the instance.
     * </p>
     * 
     * @param publicIpAddress
     *        The public IP address of the instance.
     */
    public void setPublicIpAddress(String publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
    }

    /**
     * <p>
     * The public IP address of the instance.
     * </p>
     * 
     * @return The public IP address of the instance.
     */
    public String getPublicIpAddress() {
        return this.publicIpAddress;
    }

    /**
     * <p>
     * The public IP address of the instance.
     * </p>
     * 
     * @param publicIpAddress
     *        The public IP address of the instance.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Instance withPublicIpAddress(String publicIpAddress) {
        setPublicIpAddress(publicIpAddress);
        return this;
    }


    /**
     * <p>
     * The private IP address of the instance.
     * </p>
     * 
     * @param privateIpAddress
     *        The private IP address of the instance.
     */
    public void setPrivateIpAddress(String privateIpAddress) {
        this.privateIpAddress = privateIpAddress;
    }

    /**
     * <p>
     * The private IP address of the instance.
     * </p>
     * 
     * @return The private IP address of the instance.
     */
    public String getPrivateIpAddress() {
        return this.privateIpAddress;
    }

    /**
     * <p>
     * The private IP address of the instance.
     * </p>
     * 
     * @param privateIpAddress
     *        The private IP address of the instance.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Instance withPrivateIpAddress(String privateIpAddress) {
        setPrivateIpAddress(privateIpAddress);
        return this;
    }

    /**
     * <p>
     * The current status of the instance.
     * </p>
     * 
     * @param status
     *        The current status of the instance.
     */
    public void setStatus(InstanceStatus status) {
        this.status = status;
    }

    /**
     * <p>
     * The current status of the instance.
     * </p>
     * 
     * @return The current status of the instance.
     */
    public InstanceStatus getStatus() {
        return this.status;
    }

    /**
     * <p>
     * The current status of the instance.
     * </p>
     * 
     * @param status
     *        The current status of the instance.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Instance withStatus(InstanceStatus status) {
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
        if (getPublicIpAddress() != null)
            sb.append("PublicIpAddress: " + getPublicIpAddress() + ",");
        if (getPrivateIpAddress() != null)
            sb.append("PrivateIpAddress: " + getPrivateIpAddress() + ",");
        if (getStatus() != null)
            sb.append("Status: " + getStatus());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Instance == false)
            return false;
        Instance other = (Instance) obj;
        if (other.getId() == null ^ this.getId() == null)
            return false;
        if (other.getId() != null
                && other.getId().equals(this.getId()) == false)
            return false;
        if (other.getPublicIpAddress() == null
                ^ this.getPublicIpAddress() == null)
            return false;
        if (other.getPublicIpAddress() != null
                && other.getPublicIpAddress().equals(this.getPublicIpAddress()) == false)
            return false;

        if (other.getPrivateIpAddress() == null
                ^ this.getPrivateIpAddress() == null)
            return false;
        if (other.getPrivateIpAddress() != null
                && other.getPrivateIpAddress().equals(
                        this.getPrivateIpAddress()) == false)
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

        hashCode = prime
                * hashCode
                + ((getPublicIpAddress() == null) ? 0 : getPublicIpAddress()
                        .hashCode());

        hashCode = prime
                * hashCode
                + ((getPrivateIpAddress() == null) ? 0 : getPrivateIpAddress()
                        .hashCode());
        hashCode = prime * hashCode
                + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return hashCode;
    }

    @Override
    public Instance clone() {
        try {
            return (Instance) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
