package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import com.kingsoft.services.RequestMessage;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * The input argument to the <a>TerminationProtection</a> operation.
 * </p>
 */
public class SetTerminationProtectionRequest extends RequestMessage
        implements Serializable, Cloneable {

    /**
     * <p>
     * A list of strings that uniquely identify the job flows to protect. This
     * identifier is returned by <a>RunJobFlow</a> and can also be obtained from
     * <a>DescribeJobFlows</a> .
     * </p>
     */
    private List<String> jobFlowIds;
    /**
     * <p>
     * A Boolean that indicates whether to protect the job flow and prevent the
     * instances in the cluster from shutting down due to API calls,
     * user intervention, or job-flow error.
     * </p>
     */
    private Boolean terminationProtected;

    /**
     * <p>
     * A list of strings that uniquely identify the job flows to protect. This
     * identifier is returned by <a>RunJobFlow</a> and can also be obtained from
     * <a>DescribeJobFlows</a> .
     * </p>
     * 
     * @return A list of strings that uniquely identify the job flows to
     *         protect. This identifier is returned by <a>RunJobFlow</a> and can
     *         also be obtained from <a>DescribeJobFlows</a> .
     */
    public java.util.List<String> getJobFlowIds() {
        if (jobFlowIds == null) {
            jobFlowIds = new ArrayList<String>();
        }
        return jobFlowIds;
    }

    /**
     * <p>
     * A list of strings that uniquely identify the job flows to protect. This
     * identifier is returned by <a>RunJobFlow</a> and can also be obtained from
     * <a>DescribeJobFlows</a> .
     * </p>
     * 
     * @param jobFlowIds
     *        A list of strings that uniquely identify the job flows to protect.
     *        This identifier is returned by <a>RunJobFlow</a> and can also be
     *        obtained from <a>DescribeJobFlows</a> .
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
     * A list of strings that uniquely identify the job flows to protect. This
     * identifier is returned by <a>RunJobFlow</a> and can also be obtained from
     * <a>DescribeJobFlows</a> .
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setJobFlowIds(java.util.Collection)} or
     * {@link #withJobFlowIds(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param jobFlowIds
     *        A list of strings that uniquely identify the job flows to protect.
     *        This identifier is returned by <a>RunJobFlow</a> and can also be
     *        obtained from <a>DescribeJobFlows</a> .
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public SetTerminationProtectionRequest withJobFlowIds(String... jobFlowIds) {
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
     * A list of strings that uniquely identify the job flows to protect. This
     * identifier is returned by <a>RunJobFlow</a> and can also be obtained from
     * <a>DescribeJobFlows</a> .
     * </p>
     * 
     * @param jobFlowIds
     *        A list of strings that uniquely identify the job flows to protect.
     *        This identifier is returned by <a>RunJobFlow</a> and can also be
     *        obtained from <a>DescribeJobFlows</a> .
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public SetTerminationProtectionRequest withJobFlowIds(
            java.util.Collection<String> jobFlowIds) {
        setJobFlowIds(jobFlowIds);
        return this;
    }

    /**
     * <p>
     * A Boolean that indicates whether to protect the job flow and prevent the
     * instances in the cluster from shutting down due to API calls,
     * user intervention, or job-flow error.
     * </p>
     * 
     * @param terminationProtected
     *        A Boolean that indicates whether to protect the job flow and
     *        prevent the instances in the cluster from shutting down
     *        due to API calls, user intervention, or job-flow error.
     */
    public void setTerminationProtected(Boolean terminationProtected) {
        this.terminationProtected = terminationProtected;
    }

    /**
     * <p>
     * A Boolean that indicates whether to protect the job flow and prevent the
     * instances in the cluster from shutting down due to API calls,
     * user intervention, or job-flow error.
     * </p>
     * 
     * @return A Boolean that indicates whether to protect the job flow and
     *         prevent the instances in the cluster from shutting
     *         down due to API calls, user intervention, or job-flow error.
     */
    public Boolean getTerminationProtected() {
        return this.terminationProtected;
    }

    /**
     * <p>
     * A Boolean that indicates whether to protect the job flow and prevent the
     * instances in the cluster from shutting down due to API calls,
     * user intervention, or job-flow error.
     * </p>
     * 
     * @param terminationProtected
     *        A Boolean that indicates whether to protect the job flow and
     *        prevent the instances in the cluster from shutting down
     *        due to API calls, user intervention, or job-flow error.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public SetTerminationProtectionRequest withTerminationProtected(
            Boolean terminationProtected) {
        setTerminationProtected(terminationProtected);
        return this;
    }

    /**
     * <p>
     * A Boolean that indicates whether to protect the job flow and prevent the
     * instances in the cluster from shutting down due to API calls,
     * user intervention, or job-flow error.
     * </p>
     * 
     * @return A Boolean that indicates whether to protect the job flow and
     *         prevent the instances in the cluster from shutting
     *         down due to API calls, user intervention, or job-flow error.
     */
    public Boolean isTerminationProtected() {
        return this.terminationProtected;
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
            sb.append("JobFlowIds: " + getJobFlowIds() + ",");
        if (getTerminationProtected() != null)
            sb.append("TerminationProtected: " + getTerminationProtected());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof SetTerminationProtectionRequest == false)
            return false;
        SetTerminationProtectionRequest other = (SetTerminationProtectionRequest) obj;
        if (other.getJobFlowIds() == null ^ this.getJobFlowIds() == null)
            return false;
        if (other.getJobFlowIds() != null
                && other.getJobFlowIds().equals(this.getJobFlowIds()) == false)
            return false;
        if (other.getTerminationProtected() == null
                ^ this.getTerminationProtected() == null)
            return false;
        if (other.getTerminationProtected() != null
                && other.getTerminationProtected().equals(
                        this.getTerminationProtected()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getJobFlowIds() == null) ? 0 : getJobFlowIds().hashCode());
        hashCode = prime
                * hashCode
                + ((getTerminationProtected() == null) ? 0
                        : getTerminationProtected().hashCode());
        return hashCode;
    }

    @Override
    public SetTerminationProtectionRequest clone() {
        return (SetTerminationProtectionRequest) super.clone();
    }
}