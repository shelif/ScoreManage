package com.example.demo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Sc extends ScKey implements Serializable {
    private Float scGrade;

    private static final long serialVersionUID = 1L;

    public Float getScGrade() {
        return scGrade;
    }

    public void setScGrade(Float scGrade) {
        this.scGrade = scGrade;
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
        Sc other = (Sc) that;
        return (this.getScCId() == null ? other.getScCId() == null : this.getScCId().equals(other.getScCId()))
            && (this.getScSId() == null ? other.getScSId() == null : this.getScSId().equals(other.getScSId()))
            && (this.getScGrade() == null ? other.getScGrade() == null : this.getScGrade().equals(other.getScGrade()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getScCId() == null) ? 0 : getScCId().hashCode());
        result = prime * result + ((getScSId() == null) ? 0 : getScSId().hashCode());
        result = prime * result + ((getScGrade() == null) ? 0 : getScGrade().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", scGrade=").append(scGrade);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}