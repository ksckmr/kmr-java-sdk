package com.kingsoft.services.kmr.model;


import java.io.Serializable;

/**
 * <p>
 * The details of the instance group status.
 * </p>
 */
public class InstanceGroupStatus implements Serializable, Cloneable {

    /**
     * <p>
     * The current state of the instance group.
     * </p>
     */
    private String state;


    /**
     * <p>
     * The current state of the instance group.
     * </p>
     * 
     * @param state
     *        The current state of the instance group.
     * @see InstanceGroupState
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * <p>
     * The current state of the instance group.
     * </p>
     * 
     * @return The current state of the instance group.
     * @see InstanceGroupState
     */
    public String getState() {
        return this.state;
    }

    /**
     * <p>
     * The current state of the instance group.
     * </p>
     * 
     * @param state
     *        The current state of the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceGroupState
     */
    public InstanceGroupStatus withState(String state) {
        setState(state);
        return this;
    }

    /**
     * <p>
     * The current state of the instance group.
     * </p>
     * 
     * @param state
     *        The current state of the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceGroupState
     */
    public void setState(InstanceGroupState state) {
        this.state = state.toString();
    }

    /**
     * <p>
     * The current state of the instance group.
     * </p>
     * 
     * @param state
     *        The current state of the instance group.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceGroupState
     */
    public InstanceGroupStatus withState(InstanceGroupState state) {
        setState(state);
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
        if (getState() != null)
            sb.append("State: " + getState());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof InstanceGroupStatus == false)
            return false;
        InstanceGroupStatus other = (InstanceGroupStatus) obj;
        if (other.getState() == null ^ this.getState() == null)
            return false;
        if (other.getState() != null
                && other.getState().equals(this.getState()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getState() == null) ? 0 : getState().hashCode());
        return hashCode;
    }

    @Override
    public InstanceGroupStatus clone() {
        try {
            return (InstanceGroupStatus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}