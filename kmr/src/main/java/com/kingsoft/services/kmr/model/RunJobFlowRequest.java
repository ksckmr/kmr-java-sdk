package com.kingsoft.services.kmr.model;

import com.kingsoft.services.RequestMessage;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


/**
 * Input to the <a>RunJobFlow</a> operation.
 */
public class RunJobFlowRequest extends RequestMessage implements Serializable, Cloneable {

    /**
     * job flow名称.
     */
    private String name;
    /**
     * log在KS3中存放位置
     */
    private String logUri;
 
    private String hadoopVersion;
    private Boolean enableHighAvailability;
    private String sshKeyIds;
    private Boolean enableEip;

    /**
     * instance配置,包括节点类型和数量等.
     */
    private JobFlowInstancesConfig instances;
    /**
     * 运行的steps配置
     */
    private List<StepConfig> steps;

    private List<String> applications;

    /**
     * 默认构造函数.
     */
    public RunJobFlowRequest() {
    }

    /**
     * 使用cluster名称和instance配置构造cluster
     * 
     */
    public RunJobFlowRequest(String name, JobFlowInstancesConfig instances) {
        setName(name);
        setInstances(instances);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public RunJobFlowRequest withName(String name) {
        setName(name);
        return this;
    }

    public void setEnableHighAvailability(
            Boolean enableHighAvailability) {
        this.enableHighAvailability = enableHighAvailability;
    }

    public Boolean getEnableHighAvailability() {
        return this.enableHighAvailability;
    }

    public RunJobFlowRequest withEnableHighAvailability(
            Boolean enableHighAvailability) {
        setEnableHighAvailability(enableHighAvailability);
        return this;
    }

    public void setEnableEip(
            Boolean enableEip) {
        this.enableEip = enableEip;
    }

    public Boolean getEnableEip() {
        return this.enableEip;
    }

    public RunJobFlowRequest withEnableEip(
            Boolean enableEip) {
        setEnableEip(enableEip);
        return this;
    }

    public Boolean isEnableHighAvailability() {
        return this.enableHighAvailability;
    }

    public void setSshKeyIds(String sshKeyIds) {
        this.sshKeyIds = sshKeyIds;
    }

    public String getSshKeyIds() {
        return this.sshKeyIds;
    }

    public RunJobFlowRequest withSshKeyIds(String sshKeyIds) {
        setSshKeyIds(sshKeyIds);
        return this;
    }

    public void setLogUri(String logUri) {
        this.logUri = logUri;
    }

    public String getLogUri() {
        return this.logUri;
    }

    public RunJobFlowRequest withLogUri(String logUri) {
        setLogUri(logUri);
        return this;
    }

    public void setInstances(JobFlowInstancesConfig instances) {
        this.instances = instances;
    }

    public JobFlowInstancesConfig getInstances() {
        return this.instances;
    }

    public RunJobFlowRequest withInstances(JobFlowInstancesConfig instances) {
        setInstances(instances);
        return this;
    }

    public java.util.List<StepConfig> getSteps() {
        if (steps == null) {
            steps = new ArrayList<StepConfig>();
        }
        return steps;
    }

    public void setSteps(java.util.Collection<StepConfig> steps) {
        if (steps == null) {
            this.steps = null;
            return;
        }

        this.steps = new ArrayList<StepConfig>(
                steps);
    }

    public RunJobFlowRequest withSteps(StepConfig... steps) {
        if (this.steps == null) {
            setSteps(new ArrayList<StepConfig>(
                    steps.length));
        }
        for (StepConfig ele : steps) {
            this.steps.add(ele);
        }
        return this;
    }

    public RunJobFlowRequest withSteps(java.util.Collection<StepConfig> steps) {
        setSteps(steps);
        return this;
    }

    public void setHadoopVersion(String hadoopVersion) {
        this.hadoopVersion = hadoopVersion;
    }

    public String getHadoopVersion() {
        return this.hadoopVersion;
    }

    public RunJobFlowRequest withHadoopVersion(String hadoopVersion) {
        setHadoopVersion(hadoopVersion);
        return this;
    }


    public java.util.List<String> getApplications() {
        if (applications == null) {
            applications = new ArrayList<String>();
        }
        return applications;
    }


    public void setApplications(java.util.Collection<String> applications) {
        if (applications == null) {
            this.applications = null;
            return;
        }

        this.applications = new ArrayList<String>(
                applications);
    }

    public RunJobFlowRequest withApplications(String... applications) {
        if (this.applications == null) {
            setApplications(new ArrayList<String>(
                    applications.length));
        }
        for (String ele : applications) {
            this.applications.add(ele);
        }
        return this;
    }

    public RunJobFlowRequest withApplications(
            java.util.Collection<String> applications) {
        setApplications(applications);
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
        if (getName() != null)
            sb.append("Name: " + getName() + ",");
        if (getLogUri() != null)
            sb.append("LogUri: " + getLogUri() + ",");
        if (getHadoopVersion() != null)
            sb.append("HadoopVersion: " + getHadoopVersion() + ",");
        if (getApplications() != null)
            sb.append("Applications: " + getApplications() + ",");
        if (getSshKeyIds() != null)
            sb.append("SshKeyIds: " + getSshKeyIds() + ",");
        if (getEnableHighAvailability() != null)
            sb.append("EnableHighAvailability: " + getEnableHighAvailability() + ",");
        if (getEnableEip() != null)
            sb.append("EnableEip: " + getEnableEip() + ",");
        if (getInstances() != null)
            sb.append("Instances: " + getInstances() + ",");
        if (getSteps() != null)
            sb.append("Steps: " + getSteps());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof RunJobFlowRequest == false)
            return false;
        RunJobFlowRequest other = (RunJobFlowRequest) obj;
        if (other.getName() == null ^ this.getName() == null)
            return false;
        if (other.getName() != null
                && other.getName().equals(this.getName()) == false)
            return false;
        if (other.getLogUri() == null ^ this.getLogUri() == null)
            return false;
        if (other.getLogUri() != null
                && other.getLogUri().equals(this.getLogUri()) == false)
            return false;
        if (other.getInstances() == null ^ this.getInstances() == null)
            return false;
        if (other.getInstances() != null
                && other.getInstances().equals(this.getInstances()) == false)
            return false;
        if (other.getSteps() == null ^ this.getSteps() == null)
            return false;
        if (other.getSteps() != null
                && other.getSteps().equals(this.getSteps()) == false)
            return false;
        if (other.getHadoopVersion() == null ^ this.getHadoopVersion() == null)
            return false;
        if (other.getHadoopVersion() != null
                && other.getHadoopVersion().equals(this.getHadoopVersion()) == false)
            return false;
        if (other.getEnableHighAvailability() == null ^ this.getEnableHighAvailability() == null)
            return false;
        if (other.getEnableHighAvailability() != null
                && other.getEnableHighAvailability().equals(this.getEnableHighAvailability()) == false)
            return false;
        if (other.getEnableEip() == null ^ this.getEnableEip() == null)
            return false;
        if (other.getEnableEip() != null
                && other.getEnableEip().equals(this.getEnableEip()) == false)
            return false;
        if (other.getSshKeyIds() == null ^ this.getSshKeyIds() == null)
            return false;
        if (other.getSshKeyIds() != null
                && other.getSshKeyIds().equals(this.getSshKeyIds()) == false)
            return false;
        if (other.getApplications() == null ^ this.getApplications() == null)
            return false;
        if (other.getApplications() != null
                && other.getApplications().equals(this.getApplications()) == false)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getName() == null) ? 0 : getName().hashCode());
        hashCode = prime * hashCode
                + ((getLogUri() == null) ? 0 : getLogUri().hashCode());
        hashCode = prime * hashCode
                + ((getInstances() == null) ? 0 : getInstances().hashCode());
        hashCode = prime * hashCode
                + ((getSteps() == null) ? 0 : getSteps().hashCode());
        hashCode = prime
                * hashCode
                + ((getHadoopVersion() == null) ? 0 : getHadoopVersion()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getApplications() == null) ? 0 : getApplications()
                .hashCode());
        hashCode = prime
                * hashCode
                + ((getSshKeyIds() == null) ? 0 : getSshKeyIds()
                .hashCode());
        hashCode = prime
                * hashCode
                + ((getEnableHighAvailability() == null) ? 0 : getEnableHighAvailability()
                .hashCode());
        hashCode = prime
                * hashCode
                + ((getEnableEip() == null) ? 0 : getEnableEip()
                .hashCode());
        return hashCode;
    }

    @Override
    public RunJobFlowRequest clone()  {
        return (RunJobFlowRequest) super.clone();
    }
}
