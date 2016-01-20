package com.kingsoft.services.kmr.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * The additional args of spark step.
 * </p>
 */
public class Additional implements Serializable, Cloneable {

    private List<String> sparkSubmitArgs;


    public java.util.List<String> getArgs() {
        if (sparkSubmitArgs == null) {
            sparkSubmitArgs = new ArrayList<String>();
        }
        return sparkSubmitArgs;
    }

    public void setArgs(java.util.Collection<String> args) {
        if (args == null) {
            this.sparkSubmitArgs = null;
            return;
        }

        this.sparkSubmitArgs = new ArrayList<String>(args);
    }

    public Additional withArgs(String... args) {
        if (this.sparkSubmitArgs == null) {
            setArgs(new ArrayList<String>(
                    args.length));
        }
        for (String ele : args) {
            this.sparkSubmitArgs.add(ele);
        }
        return this;
    }

    public Additional withArgs(java.util.Collection<String> args) {
        setArgs(args);
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
        if (getArgs() != null)
            sb.append("SparkSubmitArgs: " + getArgs());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Additional == false)
            return false;
        Additional other = (Additional) obj;
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
                + ((getArgs() == null) ? 0 : getArgs().hashCode());
        return hashCode;
    }

    @Override
    public Additional clone() {
        try {
            return (Additional) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}