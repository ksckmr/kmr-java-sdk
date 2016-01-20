package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * The output for the <a>AddJobFlowSteps</a> operation.
 * </p>
 */
public class AddJobFlowStepsResult implements Serializable, Cloneable {

    /**
     * <p>
     * The identifiers of the list of steps added to the job flow.
     * </p>
     */
    private List<String> stepIds;

    /**
     * <p>
     * The identifiers of the list of steps added to the job flow.
     * </p>
     * 
     * @return The identifiers of the list of steps added to the job flow.
     */
    public java.util.List<String> getStepIds() {
        if (stepIds == null) {
            stepIds = new ArrayList<String>();
        }
        return stepIds;
    }

    /**
     * <p>
     * The identifiers of the list of steps added to the job flow.
     * </p>
     * 
     * @param stepIds
     *        The identifiers of the list of steps added to the job flow.
     */
    public void setStepIds(java.util.Collection<String> stepIds) {
        if (stepIds == null) {
            this.stepIds = null;
            return;
        }

        this.stepIds = new ArrayList<String>(
                stepIds);
    }

    /**
     * <p>
     * The identifiers of the list of steps added to the job flow.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setStepIds(java.util.Collection)} or
     * {@link #withStepIds(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param stepIds
     *        The identifiers of the list of steps added to the job flow.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public AddJobFlowStepsResult withStepIds(String... stepIds) {
        if (this.stepIds == null) {
            setStepIds(new ArrayList<String>(
                    stepIds.length));
        }
        for (String ele : stepIds) {
            this.stepIds.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The identifiers of the list of steps added to the job flow.
     * </p>
     * 
     * @param stepIds
     *        The identifiers of the list of steps added to the job flow.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public AddJobFlowStepsResult withStepIds(
            java.util.Collection<String> stepIds) {
        setStepIds(stepIds);
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
        if (getStepIds() != null)
            sb.append("StepIds: " + getStepIds());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof AddJobFlowStepsResult == false)
            return false;
        AddJobFlowStepsResult other = (AddJobFlowStepsResult) obj;
        if (other.getStepIds() == null ^ this.getStepIds() == null)
            return false;
        if (other.getStepIds() != null
                && other.getStepIds().equals(this.getStepIds()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getStepIds() == null) ? 0 : getStepIds().hashCode());
        return hashCode;
    }

    @Override
    public AddJobFlowStepsResult clone() {
        try {
            return (AddJobFlowStepsResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}