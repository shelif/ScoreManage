package com.example.demo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class StKey implements Serializable {
    private String stSId;

    private String stTcId;

    private static final long serialVersionUID = 1L;

    public String getStSId() {
        return stSId;
    }

    public void setStSId(String stSId) {
        this.stSId = stSId;
    }

    public String getStTcId() {
        return stTcId;
    }

    public void setStTcId(String stTcId) {
        this.stTcId = stTcId;
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
        StKey other = (StKey) that;
        return (this.getStSId() == null ? other.getStSId() == null : this.getStSId().equals(other.getStSId()))
            && (this.getStTcId() == null ? other.getStTcId() == null : this.getStTcId().equals(other.getStTcId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStSId() == null) ? 0 : getStSId().hashCode());
        result = prime * result + ((getStTcId() == null) ? 0 : getStTcId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stSId=").append(stSId);
        sb.append(", stTcId=").append(stTcId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}