package com.example.demo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class ScKey implements Serializable {
    private String scCId;

    private String scSId;

    private static final long serialVersionUID = 1L;

    public String getScCId() {
        return scCId;
    }

    public void setScCId(String scCId) {
        this.scCId = scCId;
    }

    public String getScSId() {
        return scSId;
    }

    public void setScSId(String scSId) {
        this.scSId = scSId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ScKey other = (ScKey) that;
        return (this.getScCId() == null ? other.getScCId() == null : this.getScCId().equals(other.getScCId()))
            && (this.getScSId() == null ? other.getScSId() == null : this.getScSId().equals(other.getScSId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getScCId() == null) ? 0 : getScCId().hashCode());
        result = prime * result + ((getScSId() == null) ? 0 : getScSId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", scCId=").append(scCId);
        sb.append(", scSId=").append(scSId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}