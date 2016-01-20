package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import com.kingsoft.services.RequestMessage;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * Input to the <a>TerminateJobFlows</a> operation.
 * </p>
 */
public class TerminateJobFlowsRequest extends RequestMessage implements
        Serializable, Cloneable {

    /**
     * <p>
     * A list of job flows to be shutdown.
     * </p>
     */
    private List<String> jobFlowIds;

    /**
     * Default constructor for TerminateJobFlowsRequest object. Callers should
     * use the setter or fluent setter (with...) methods to initialize the
     * object after creating it.
     */
    public TerminateJobFlowsRequest() {
    }

    /**
     * Constructs a new TerminateJobFlowsRequest object. Callers should use the
     * setter or fluent setter (with...) methods to initialize any additional
     * object members.
     * 
     * @param jobFlowIds
     *        A list of job flows to be shutdown.
     */
    public TerminateJobFlowsRequest(java.util.List<String> jobFlowIds) {
        setJobFlowIds(jobFlowIds);
    }

    /**
     * <p>
     * A list of job flows to be shutdown.
     * </p>
     * 
     * @return A list of job flows to be shutdown.
     */
    public java.util.List<String> getJobFlowIds() {
        if (jobFlowIds == null) {
            jobFlowIds = new ArrayList<String>();
        }
        return jobFlowIds;
    }

    /**
     * <p>
     * A list of job flows to be shutdown.
     * </p>
     * 
     * @param jobFlowIds
     *        A list of job flows to be shutdown.
     */
    public void setJobFlowIds(java.util.Collection<String> jobFlowIds) {
        if (jobFlowIds == null) {
            this.jobFlowIds = null;
            return;
        }

        this.jobFlowIds = new ArrayList<String>(
                jobFlowIds);
    }

    /**
     * <p>
     * A list of job flows to be shutdown.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setJobFlowIds(java.util.Collection)} or
     * {@link #withJobFlowIds(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param jobFlowIds
     *        A list of job flows to be shutdown.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public TerminateJobFlowsRequest withJobFlowIds(String... jobFlowIds) {
        if (this.jobFlowIds == null) {
            setJobFlowIds(new ArrayList<String>(
                    jobFlowIds.length));
        }
        for (String ele : jobFlowIds) {
            this.jobFlowIds.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * A list of job flows to be shutdown.
     * </p>
     * 
     * @param jobFlowIds
     *        A list of job flows to be shutdown.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public TerminateJobFlowsRequest withJobFlowIds(
            java.util.Collection<String> jobFlowIds) {
        setJobFlowIds(jobFlowIds);
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
        if (getJobFlowIds() != null)
            sb.append("JobFlowIds: " + getJobFlowIds());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof TerminateJobFlowsRequest == false)
            return false;
        TerminateJobFlowsRequest other = (TerminateJobFlowsRequest) obj;
        if (other.getJobFlowIds() == null ^ this.getJobFlowIds() == null)
            return false;
        if (other.getJobFlowIds() != null
                && other.getJobFlowIds().equals(this.getJobFlowIds()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getJobFlowIds() == null) ? 0 : getJobFlowIds().hashCode());
        return hashCode;
    }

    @Override
    public TerminateJobFlowsRequest clone() {
        return (TerminateJobFlowsRequest) super.clone();
    }
}