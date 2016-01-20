package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * The detailed description of the cluster.
 * </p>
 */
public class Cluster implements Serializable, Cloneable {

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
    private String masterPublicDnsName;
    private String hadoopVersion;
    /**
     * <p>
     * The current status details about the cluster.
     * </p>
     */
    private ClusterStatus status;

    //private InstanceAttributes InstanceAttributes;
    /**
     * <p>
     * The path to the KS3 location where logs for this cluster are
     * stored.
     * </p>
     */
    private String logUri;


    /**
     * <p>
     * Specifies whether the cluster should terminate after completing all
     * steps.
     * </p>
     */
    private Boolean autoTerminate;
    /**
     * <p>
     * Indicates whether KMR will lock the cluster to prevent the
     * instances from being terminated by an API call or user intervention, or
     * in the event of a cluster error.
     * </p>
     */
    private Boolean terminationProtected;

    /**
     * <p>
     * The applications installed on this cluster.
     * </p>
     */
    private List<String> applications;

    /**
     * <p>
     * The IAM role that will be assumed by the KMR service to access KSC 
     * resources on your behalf.
     * </p>
     */
    private String serviceRole;
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
    public Cluster withId(String id) {
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
    public Cluster withName(String name) {
        setName(name);
        return this;
    }


    public void setMasterPublicDnsName(String masterPublicDnsName) {
        this.masterPublicDnsName = masterPublicDnsName;
    }

    /**
     * <p>
     * The public DNS name of the master instance.
     * </p>
     *
     * @return The public DNS name of the master instance.
     */
    public String getMasterPublicDnsName() {
        return this.masterPublicDnsName;
    }

    /**
     * <p>
     * The public DNS name of the master instance.
     * </p>
     *
     * @param masterPublicDnsName
     *        The public DNS name of the master instance.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withMasterPublicDnsName(String masterPublicDnsName) {
        setMasterPublicDnsName(masterPublicDnsName);
        return this;
    }

    public void setHadoopVersion(String hadoopVersion) {
        this.hadoopVersion = hadoopVersion;
    }


    public String getHadoopVersion() {
        return this.hadoopVersion;
    }


    public Cluster withHadoopVersion(String hadoopVersion) {
        setHadoopVersion(hadoopVersion);
        return this;
    }

    /**
     * <p>
     * The current status details about the cluster.
     * </p>
     * 
     * @param status
     *        The current status details about the cluster.
     */
    public void setStatus(ClusterStatus status) {
        this.status = status;
    }

    /**
     * <p>
     * The current status details about the cluster.
     * </p>
     * 
     * @return The current status details about the cluster.
     */
    public ClusterStatus getStatus() {
        return this.status;
    }

    /**
     * <p>
     * The current status details about the cluster.
     * </p>
     * 
     * @param status
     *        The current status details about the cluster.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withStatus(ClusterStatus status) {
        setStatus(status);
        return this;
    }

    /*
    public void setInstanceAttributes(
            InstanceAttributes InstanceAttributes) {
        this.InstanceAttributes = InstanceAttributes;
    }

    public InstanceAttributes getInstanceAttributes() {
        return this.InstanceAttributes;
    }

    public Cluster withInstanceAttributes(
            InstanceAttributes InstanceAttributes) {
        setInstanceAttributes(InstanceAttributes);
        return this;
    }
    */
    /**
     * <p>
     * The path to the KS3 location where logs for this cluster are
     * stored.
     * </p>
     * 
     * @param logUri
     *        The path to the KS3 location where logs for this cluster are
     *        stored.
     */
    public void setLogUri(String logUri) {
        this.logUri = logUri;
    }

    /**
     * <p>
     * The path to the KS3 location where logs for this cluster are
     * stored.
     * </p>
     * 
     * @return The path to the KS3 location where logs for this cluster
     *         are stored.
     */
    public String getLogUri() {
        return this.logUri;
    }

    /**
     * <p>
     * The path to the KS3 location where logs for this cluster are
     * stored.
     * </p>
     * 
     * @param logUri
     *        The path to the KS3 location where logs for this cluster are
     *        stored.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withLogUri(String logUri) {
        setLogUri(logUri);
        return this;
    }


    /**
     * <p>
     * Specifies whether the cluster should terminate after completing all
     * steps.
     * </p>
     * 
     * @param autoTerminate
     *        Specifies whether the cluster should terminate after completing
     *        all steps.
     */
    public void setAutoTerminate(Boolean autoTerminate) {
        this.autoTerminate = autoTerminate;
    }

    /**
     * <p>
     * Specifies whether the cluster should terminate after completing all
     * steps.
     * </p>
     * 
     * @return Specifies whether the cluster should terminate after completing
     *         all steps.
     */
    public Boolean getAutoTerminate() {
        return this.autoTerminate;
    }

    /**
     * <p>
     * Specifies whether the cluster should terminate after completing all
     * steps.
     * </p>
     * 
     * @param autoTerminate
     *        Specifies whether the cluster should terminate after completing
     *        all steps.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withAutoTerminate(Boolean autoTerminate) {
        setAutoTerminate(autoTerminate);
        return this;
    }

    /**
     * <p>
     * Specifies whether the cluster should terminate after completing all
     * steps.
     * </p>
     * 
     * @return Specifies whether the cluster should terminate after completing
     *         all steps.
     */
    public Boolean isAutoTerminate() {
        return this.autoTerminate;
    }

    /**
     * <p>
     * Indicates whether KMR will lock the cluster to prevent the
     * instances from being terminated by an API call or user intervention, or
     * in the event of a cluster error.
     * </p>
     * 
     * @param terminationProtected
     *        Indicates whether KMR will lock the cluster to prevent the
     *        instances from being terminated by an API call or user
     *        intervention, or in the event of a cluster error.
     */
    public void setTerminationProtected(Boolean terminationProtected) {
        this.terminationProtected = terminationProtected;
    }

    /**
     * <p>
     * Indicates whether KMR will lock the cluster to prevent the
     * instances from being terminated by an API call or user intervention, or
     * in the event of a cluster error.
     * </p>
     * 
     * @return Indicates whether KMR will lock the cluster to prevent the
     *         instances from being terminated by an API call or user
     *         intervention, or in the event of a cluster error.
     */
    public Boolean getTerminationProtected() {
        return this.terminationProtected;
    }

    /**
     * <p>
     * Indicates whether KMR will lock the cluster to prevent the
     * instances from being terminated by an API call or user intervention, or
     * in the event of a cluster error.
     * </p>
     * 
     * @param terminationProtected
     *        Indicates whether KMR will lock the cluster to prevent the
     *        instances from being terminated by an API call or user
     *        intervention, or in the event of a cluster error.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withTerminationProtected(Boolean terminationProtected) {
        setTerminationProtected(terminationProtected);
        return this;
    }

    /**
     * <p>
     * Indicates whether KMR will lock the cluster to prevent the
     * instances from being terminated by an API call or user intervention, or
     * in the event of a cluster error.
     * </p>
     * 
     * @return Indicates whether KMR will lock the cluster to prevent the
     *         instances from being terminated by an API call or user
     *         intervention, or in the event of a cluster error.
     */
    public Boolean isTerminationProtected() {
        return this.terminationProtected;
    }


    /**
     * <p>
     * The applications installed on this cluster.
     * </p>
     * 
     * @return The applications installed on this cluster.
     */
    public java.util.List<String> getApplications() {
        if (applications == null) {
            applications = new ArrayList<String>();
        }
        return applications;
    }

    /**
     * <p>
     * The applications installed on this cluster.
     * </p>
     * 
     * @param applications
     *        The applications installed on this cluster.
     */
    public void setApplications(java.util.Collection<String> applications) {
        if (applications == null) {
            this.applications = null;
            return;
        }

        this.applications = new ArrayList<String>(
                applications);
    }

    /**
     * <p>
     * The applications installed on this cluster.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setApplications(java.util.Collection)} or
     * {@link #withApplications(java.util.Collection)} if you want to override
     * the existing values.
     * </p>
     * 
     * @param applications
     *        The applications installed on this cluster.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withApplications(String... applications) {
        if (this.applications == null) {
            setApplications(new ArrayList<String>(
                    applications.length));
        }
        for (String ele : applications) {
            this.applications.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The applications installed on this cluster.
     * </p>
     * 
     * @param applications
     *        The applications installed on this cluster.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withApplications(
            java.util.Collection<String> applications) {
        setApplications(applications);
        return this;
    }


    /**
     * <p>
     * The IAM role that will be assumed by the KMR service to access KSC 
     * resources on your behalf.
     * </p>
     * 
     * @param serviceRole
     *        The IAM role that will be assumed by the KMR service to
     *        access KSC resources on your behalf.
     */
    public void setServiceRole(String serviceRole) {
        this.serviceRole = serviceRole;
    }

    /**
     * <p>
     * The IAM role that will be assumed by the KMR service to access KSC 
     * resources on your behalf.
     * </p>
     * 
     * @return The IAM role that will be assumed by the KMR service to
     *         access KSC resources on your behalf.
     */
    public String getServiceRole() {
        return this.serviceRole;
    }

    /**
     * <p>
     * The IAM role that will be assumed by the KMR service to access KSC 
     * resources on your behalf.
     * </p>
     * 
     * @param serviceRole
     *        The IAM role that will be assumed by the KMR service to
     *        access KSC resources on your behalf.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withServiceRole(String serviceRole) {
        setServiceRole(serviceRole);
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
     *        an instance that is roughly four times more expensive would
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
     *         an instance that is roughly four times more expensive would
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
     *        an instance that is roughly four times more expensive would
     *        result in the normalized instance hours being incremented by four.
     *        This result is only an approximation and does not reflect the
     *        actual billing rate.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public Cluster withNormalizedInstanceMins(Integer normalizedInstanceMins) {
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
        /*
        if (getInstanceAttributes() != null)
            sb.append("InstanceAttributes: " + getInstanceAttributes()
                    + ",");
        */
        if (getLogUri() != null)
            sb.append("LogUri: " + getLogUri() + ",");

        if (getAutoTerminate() != null)
            sb.append("AutoTerminate: " + getAutoTerminate() + ",");
        if (getTerminationProtected() != null)
            sb.append("TerminationProtected: " + getTerminationProtected()
                    + ",");
        if (getApplications() != null)
            sb.append("Applications: " + getApplications() + ",");
        if (getMasterPublicDnsName() != null)
            sb.append("MasterPublicDnsName: " + getMasterPublicDnsName() + ",");
        if (getHadoopVersion() != null)
            sb.append("HadoopVersion: " + getHadoopVersion() + ",");
        if (getServiceRole() != null)
            sb.append("ServiceRole: " + getServiceRole() + ",");
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

        if (obj instanceof Cluster == false)
            return false;
        Cluster other = (Cluster) obj;
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
        /*
        if (other.getInstanceAttributes() == null
                ^ this.getInstanceAttributes() == null)
            return false;
        if (other.getInstanceAttributes() != null
                && other.getInstanceAttributes().equals(
                        this.getInstanceAttributes()) == false)
            return false;
        */
        if (other.getLogUri() == null ^ this.getLogUri() == null)
            return false;
        if (other.getLogUri() != null
                && other.getLogUri().equals(this.getLogUri()) == false)
            return false;
        if (other.getAutoTerminate() == null ^ this.getAutoTerminate() == null)
            return false;
        if (other.getAutoTerminate() != null
                && other.getAutoTerminate().equals(this.getAutoTerminate()) == false)
            return false;
        if (other.getTerminationProtected() == null
                ^ this.getTerminationProtected() == null)
            return false;
        if (other.getTerminationProtected() != null
                && other.getTerminationProtected().equals(
                        this.getTerminationProtected()) == false)
            return false;
        if (other.getApplications() == null ^ this.getApplications() == null)
            return false;
        if (other.getApplications() != null
                && other.getApplications().equals(this.getApplications()) == false)
            return false;
        if (other.getServiceRole() == null ^ this.getServiceRole() == null)
            return false;
        if (other.getServiceRole() != null
                && other.getServiceRole().equals(this.getServiceRole()) == false)
            return false;
        if (other.getNormalizedInstanceMins() == null
                ^ this.getNormalizedInstanceMins() == null)
            return false;
        if (other.getMasterPublicDnsName() != null
                && other.getMasterPublicDnsName().equals(
                this.getMasterPublicDnsName()) == false)
            return false;
        if (other.getHadoopVersion() != null
                && other.getHadoopVersion().equals(
                this.getHadoopVersion()) == false)
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
        /*
        hashCode = prime
                * hashCode
                + ((getInstanceAttributes() == null) ? 0
                        : getInstanceAttributes().hashCode());
        */
        hashCode = prime * hashCode
                + ((getLogUri() == null) ? 0 : getLogUri().hashCode());
        hashCode = prime
                * hashCode
                + ((getAutoTerminate() == null) ? 0 : getAutoTerminate()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getTerminationProtected() == null) ? 0
                        : getTerminationProtected().hashCode());
        hashCode = prime
                * hashCode
                + ((getMasterPublicDnsName() == null) ? 0
                : getMasterPublicDnsName().hashCode());
        hashCode = prime
                * hashCode
                + ((getHadoopVersion() == null) ? 0
                : getHadoopVersion().hashCode());
        hashCode = prime
                * hashCode
                + ((getApplications() == null) ? 0 : getApplications()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getServiceRole() == null) ? 0 : getServiceRole().hashCode());
        hashCode = prime
                * hashCode
                + ((getNormalizedInstanceMins() == null) ? 0
                        : getNormalizedInstanceMins().hashCode());

        return hashCode;
    }

    @Override
    public Cluster clone() {
        try {
            return (Cluster) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
