package com.kingsoft.services.kmr.model;
import java.io.Serializable;

/**
 * <p>
 * This output contains the description of the cluster step.
 * </p>
 */
public class DescribeStepResult implements Serializable, Cloneable {

    /**
     * <p>
     * The step details for the requested step identifier.
     * </p>
     */
    private Step step;

    /**
     * <p>
     * The step details for the requested step identifier.
     * </p>
     * 
     * @param step
     *        The step details for the requested step identifier.
     */
    public void setStep(Step step) {
        this.step = step;
    }

    /**
     * <p>
     * The step details for the requested step identifier.
     * </p>
     * 
     * @return The step details for the requested step identifier.
     */
    public Step getStep() {
        return this.step;
    }

    /**
     * <p>
     * The step details for the requested step identifier.
     * </p>
     * 
     * @param step
     *        The step details for the requested step identifier.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public DescribeStepResult withStep(Step step) {
        setStep(step);
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
        if (getStep() != null)
            sb.append("Step: " + getStep());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DescribeStepResult == false)
            return false;
        DescribeStepResult other = (DescribeStepResult) obj;
        if (other.getStep() == null ^ this.getStep() == null)
            return false;
        if (other.getStep() != null
                && other.getStep().equals(this.getStep()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getStep() == null) ? 0 : getStep().hashCode());
        return hashCode;
    }

    @Override
    public DescribeStepResult clone() {
        try {
            return (DescribeStepResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}