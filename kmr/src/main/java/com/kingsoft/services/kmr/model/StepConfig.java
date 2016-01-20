package com.kingsoft.services.kmr.model;

import java.io.Serializable;

public class StepConfig implements Serializable, Cloneable {

    private String name;
    private String actionOnFailure;
    private HadoopJarStepConfig hadoopJarStep;

    public StepConfig() {
    }

    public StepConfig(String name, HadoopJarStepConfig hadoopJarStep) {
        setName(name);
        setHadoopJarStep(hadoopJarStep);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public StepConfig withName(String name) {
        setName(name);
        return this;
    }


    public void setActionOnFailure(String actionOnFailure) {
        this.actionOnFailure = actionOnFailure;
    }


    public String getActionOnFailure() {
        return this.actionOnFailure;
    }

    public StepConfig withActionOnFailure(String actionOnFailure) {
        setActionOnFailure(actionOnFailure);
        return this;
    }

    public void setActionOnFailure(ActionOnFailure actionOnFailure) {
        this.actionOnFailure = actionOnFailure.toString();
    }


    public StepConfig withActionOnFailure(ActionOnFailure actionOnFailure) {
        setActionOnFailure(actionOnFailure);
        return this;
    }

    public void setHadoopJarStep(HadoopJarStepConfig hadoopJarStep) {
        this.hadoopJarStep = hadoopJarStep;
    }

    public HadoopJarStepConfig getHadoopJarStep() {
        return this.hadoopJarStep;
    }


    public StepConfig withHadoopJarStep(HadoopJarStepConfig hadoopJarStep) {
        setHadoopJarStep(hadoopJarStep);
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getName() != null)
            sb.append("Name: " + getName() + ",");
        if (getActionOnFailure() != null)
            sb.append("ActionOnFailure: " + getActionOnFailure() + ",");
        if (getHadoopJarStep() != null)
            sb.append("HadoopJarStep: " + getHadoopJarStep());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof StepConfig == false)
            return false;
        StepConfig other = (StepConfig) obj;
        if (other.getName() == null ^ this.getName() == null)
            return false;
        if (other.getName() != null
                && other.getName().equals(this.getName()) == false)
            return false;
        if (other.getActionOnFailure() == null
                ^ this.getActionOnFailure() == null)
            return false;
        if (other.getActionOnFailure() != null
                && other.getActionOnFailure().equals(this.getActionOnFailure()) == false)
            return false;
        if (other.getHadoopJarStep() == null ^ this.getHadoopJarStep() == null)
            return false;
        if (other.getHadoopJarStep() != null
                && other.getHadoopJarStep().equals(this.getHadoopJarStep()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getName() == null) ? 0 : getName().hashCode());
        hashCode = prime
                * hashCode
                + ((getActionOnFailure() == null) ? 0 : getActionOnFailure()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getHadoopJarStep() == null) ? 0 : getHadoopJarStep()
                        .hashCode());
        return hashCode;
    }

    @Override
    public StepConfig clone() {
        try {
            return (StepConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
