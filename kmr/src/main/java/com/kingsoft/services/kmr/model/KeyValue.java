package com.kingsoft.services.kmr.model;

import java.io.Serializable;

public class KeyValue implements Serializable, Cloneable {

    private String key;
    private String value;

    public KeyValue() {
    }

    public KeyValue(String key, String value) {
        setKey(key);
        setValue(value);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public KeyValue withKey(String key) {
        setKey(key);
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public KeyValue withValue(String value) {
        setValue(value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKey() != null)
            sb.append("Key: " + getKey() + ",");
        if (getValue() != null)
            sb.append("Value: " + getValue());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof KeyValue == false)
            return false;
        KeyValue other = (KeyValue) obj;
        if (other.getKey() == null ^ this.getKey() == null)
            return false;
        if (other.getKey() != null
                && other.getKey().equals(this.getKey()) == false)
            return false;
        if (other.getValue() == null ^ this.getValue() == null)
            return false;
        if (other.getValue() != null
                && other.getValue().equals(this.getValue()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getKey() == null) ? 0 : getKey().hashCode());
        hashCode = prime * hashCode
                + ((getValue() == null) ? 0 : getValue().hashCode());
        return hashCode;
    }

    @Override
    public KeyValue clone() {
        try {
            return (KeyValue) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
