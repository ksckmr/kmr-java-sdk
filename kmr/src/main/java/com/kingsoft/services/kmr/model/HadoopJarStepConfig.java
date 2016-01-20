package com.kingsoft.services.kmr.model;

import java.io.Serializable;
import java.util.*;


public class HadoopJarStepConfig implements Serializable, Cloneable {


    private List<KeyValue> properties;

    private String jar;
    private String mainClass;
    private List<String> args;

    // used for spark step
    private String mainJar;
    private Additional additional;

    public HadoopJarStepConfig() {
    }

    public HadoopJarStepConfig(String jar) {
        setJar(jar);
    }

    public java.util.List<KeyValue> getProperties() {
        if (properties == null) {
            properties = new ArrayList<KeyValue>();
        }
        return properties;
    }

    public void setProperties(java.util.Collection<KeyValue> properties) {
        if (properties == null) {
            this.properties = null;
            return;
        }

        this.properties = new ArrayList<KeyValue>(
                properties);
    }

    public HadoopJarStepConfig withProperties(KeyValue... properties) {
        if (this.properties == null) {
            setProperties(new ArrayList<KeyValue>(
                    properties.length));
        }
        for (KeyValue ele : properties) {
            this.properties.add(ele);
        }
        return this;
    }

    public HadoopJarStepConfig withProperties(
            java.util.Collection<KeyValue> properties) {
        setProperties(properties);
        return this;
    }

    public void setJar(String jar) {
        this.jar = jar;
    }

    public String getJar() {
        return this.jar;
    }

    public HadoopJarStepConfig withJar(String jar) {
        setJar(jar);
        return this;
    }


    public void setMainJar(String mainJar) {
        this.mainJar = mainJar;
    }

    public String getMainJar() {
        return this.mainJar;
    }

    public HadoopJarStepConfig withMainJar(String mainJar) {
        setMainJar(mainJar);
        return this;
    }

    public void setAdditional(Additional additional) {
        this.additional = additional;
    }

    public Additional getAdditional() {
        return this.additional;
    }

    public HadoopJarStepConfig withAdditional(Additional additional) {
        setAdditional(additional);
        return this;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getMainClass() {
        return this.mainClass;
    }

    public HadoopJarStepConfig withMainClass(String mainClass) {
        setMainClass(mainClass);
        return this;
    }

    public java.util.List<String> getArgs() {
        if (args == null) {
            args = new ArrayList<String>();
        }
        return args;
    }

    public void setArgs(java.util.Collection<String> args) {
        if (args == null) {
            this.args = null;
            return;
        }

        this.args = new ArrayList<String>(args);
    }

    public HadoopJarStepConfig withArgs(String... args) {
        if (this.args == null) {
            setArgs(new ArrayList<String>(
                    args.length));
        }
        for (String ele : args) {
            this.args.add(ele);
        }
        return this;
    }

    public HadoopJarStepConfig withArgs(java.util.Collection<String> args) {
        setArgs(args);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getProperties() != null)
            sb.append("Properties: " + getProperties() + ",");
        if (getJar() != null)
            sb.append("Jar: " + getJar() + ",");
        if (getMainClass() != null)
            sb.append("MainClass: " + getMainClass() + ",");
        if (getArgs() != null)
            sb.append("Args: " + getArgs());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof HadoopJarStepConfig == false)
            return false;
        HadoopJarStepConfig other = (HadoopJarStepConfig) obj;
        if (other.getProperties() == null ^ this.getProperties() == null)
            return false;
        if (other.getProperties() != null
                && other.getProperties().equals(this.getProperties()) == false)
            return false;
        if (other.getJar() == null ^ this.getJar() == null)
            return false;
        if (other.getJar() != null
                && other.getJar().equals(this.getJar()) == false)
            return false;
        if (other.getMainClass() == null ^ this.getMainClass() == null)
            return false;
        if (other.getMainClass() != null
                && other.getMainClass().equals(this.getMainClass()) == false)
            return false;
        if (other.getArgs() == null ^ this.getArgs() == null)
            return false;
        if (other.getArgs() != null
                && other.getArgs().equals(this.getArgs()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getProperties() == null) ? 0 : getProperties().hashCode());
        hashCode = prime * hashCode
                + ((getJar() == null) ? 0 : getJar().hashCode());
        hashCode = prime * hashCode
                + ((getMainClass() == null) ? 0 : getMainClass().hashCode());
        hashCode = prime * hashCode
                + ((getArgs() == null) ? 0 : getArgs().hashCode());
        return hashCode;
    }

    @Override
    public HadoopJarStepConfig clone() {
        try {
            return (HadoopJarStepConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
