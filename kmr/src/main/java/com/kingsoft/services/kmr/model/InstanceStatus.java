package com.kingsoft.services.kmr.model;

import java.io.Serializable;

/**
 * <p>
 * The instance status details.
 * </p>
 */
public class InstanceStatus implements Serializable, Cloneable {

    /**
     * <p>
     * The current state of the instance.
     * </p>
     */
    private String state;


    /**
     * <p>
     * The current state of the instance.
     * </p>
     * 
     * @param state
     *        The current state of the instance.
     * @see InstanceState
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * <p>
     * The current state of the instance.
     * </p>
     * 
     * @return The current state of the instance.
     * @see InstanceState
     */
    public String getState() {
        return this.state;
    }

    /**
     * <p>
     * The current state of the instance.
     * </p>
     * 
     * @param state
     *        The current state of the instance.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceState
     */
    public InstanceStatus withState(String state) {
        setState(state);
        return this;
    }

    /**
     * <p>
     * The current state of the instance.
     * </p>
     * 
     * @param state
     *        The current state of the instance.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceState
     */
    public void setState(InstanceState state) {
        this.state = state.toString();
    }

    /**
     * <p>
     * The current state of the instance.
     * </p>
     * 
     * @param state
     *        The current state of the instance.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see InstanceState
     */
    public InstanceStatus withState(InstanceState state) {
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

        if (obj instanceof InstanceStatus == false)
            return false;
        InstanceStatus other = (InstanceStatus) obj;
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
    public InstanceStatus clone() {
        try {
            return (InstanceStatus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}