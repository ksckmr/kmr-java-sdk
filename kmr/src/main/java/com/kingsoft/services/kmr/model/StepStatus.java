package com.kingsoft.services.kmr.model;

import java.io.Serializable;

/**
 * <p>
 * The execution status details of the cluster step.
 * </p>
 */
public class StepStatus implements Serializable, Cloneable {

    /**
     * <p>
     * The execution state of the cluster step.
     * </p>
     */
    private String state;

    /**
     * <p>
     * The execution state of the cluster step.
     * </p>
     * 
     * @param state
     *        The execution state of the cluster step.
     * @see StepState
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * <p>
     * The execution state of the cluster step.
     * </p>
     * 
     * @return The execution state of the cluster step.
     * @see StepState
     */
    public String getState() {
        return this.state;
    }

    /**
     * <p>
     * The execution state of the cluster step.
     * </p>
     * 
     * @param state
     *        The execution state of the cluster step.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see StepState
     */
    public StepStatus withState(String state) {
        setState(state);
        return this;
    }

    /**
     * <p>
     * The execution state of the cluster step.
     * </p>
     * 
     * @param state
     *        The execution state of the cluster step.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see StepState
     */
    public void setState(StepState state) {
        this.state = state.toString();
    }

    /**
     * <p>
     * The execution state of the cluster step.
     * </p>
     * 
     * @param state
     *        The execution state of the cluster step.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     * @see StepState
     */
    public StepStatus withState(StepState state) {
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

        if (obj instanceof StepStatus == false)
            return false;
        StepStatus other = (StepStatus) obj;
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
    public StepStatus clone() {
        try {
            return (StepStatus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}