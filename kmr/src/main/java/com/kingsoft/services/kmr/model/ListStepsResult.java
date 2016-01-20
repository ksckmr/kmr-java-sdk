package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This output contains the list of steps.
 * </p>
 */
public class ListStepsResult implements Serializable, Cloneable {

    /**
     * <p>
     * The filtered list of steps for the cluster.
     * </p>
     */
    private List<StepSummary> steps;
    /**
     * <p>
     * The pagination token that indicates the next set of results to retrieve.
     * </p>
     */
    private String marker;

    /**
     * <p>
     * The filtered list of steps for the cluster.
     * </p>
     * 
     * @return The filtered list of steps for the cluster.
     */
    public java.util.List<StepSummary> getSteps() {
        if (steps == null) {
            steps = new ArrayList<StepSummary>();
        }
        return steps;
    }

    /**
     * <p>
     * The filtered list of steps for the cluster.
     * </p>
     * 
     * @param steps
     *        The filtered list of steps for the cluster.
     */
    public void setSteps(java.util.Collection<StepSummary> steps) {
        if (steps == null) {
            this.steps = null;
            return;
        }

        this.steps = new ArrayList<StepSummary>(
                steps);
    }

    /**
     * <p>
     * The filtered list of steps for the cluster.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setSteps(java.util.Collection)} or
     * {@link #withSteps(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param steps
     *        The filtered list of steps for the cluster.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ListStepsResult withSteps(StepSummary... steps) {
        if (this.steps == null) {
            setSteps(new ArrayList<StepSummary>(
                    steps.length));
        }
        for (StepSummary ele : steps) {
            this.steps.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The filtered list of steps for the cluster.
     * </p>
     * 
     * @param steps
     *        The filtered list of steps for the cluster.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public ListStepsResult withSteps(java.util.Collection<StepSummary> steps) {
        setSteps(steps);
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
    public ListStepsResult withMarker(String marker) {
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
        if (getSteps() != null)
            sb.append("Steps: " + getSteps() + ",");
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

        if (obj instanceof ListStepsResult == false)
            return false;
        ListStepsResult other = (ListStepsResult) obj;
        if (other.getSteps() == null ^ this.getSteps() == null)
            return false;
        if (other.getSteps() != null
                && other.getSteps().equals(this.getSteps()) == false)
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
                + ((getSteps() == null) ? 0 : getSteps().hashCode());
        hashCode = prime * hashCode
                + ((getMarker() == null) ? 0 : getMarker().hashCode());
        return hashCode;
    }

    @Override
    public ListStepsResult clone() {
        try {
            return (ListStepsResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}