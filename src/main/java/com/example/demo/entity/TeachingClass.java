package com.example.demo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class TeachingClass implements Serializable {
    private String tcId;

    private String tcCId;

    private String tcTId;

    private String tcCapacity;

    private String tcWeekTime;

    private String tcLesson;

    private String tcLocation;

    private static final long serialVersionUID = 1L;

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public String getTcCId() {
        return tcCId;
    }

    public void setTcCId(String tcCId) {
        this.tcCId = tcCId;
    }

    public String getTcTId() {
        return tcTId;
    }

    public void setTcTId(String tcTId) {
        this.tcTId = tcTId;
    }

    public String getTcCapacity() {
        return tcCapacity;
    }

    public void setTcCapacity(String tcCapacity) {
        this.tcCapacity = tcCapacity;
    }

    public String getTcWeekTime() {
        return tcWeekTime;
    }

    public void setTcWeekTime(String tcWeekTime) {
        this.tcWeekTime = tcWeekTime;
    }

    public String getTcLesson() {
        return tcLesson;
    }

    public void setTcLesson(String tcLesson) {
        this.tcLesson = tcLesson;
    }

    public String getTcLocation() {
        return tcLocation;
    }

    public void setTcLocation(String tcLocation) {
        this.tcLocation = tcLocation;
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
        TeachingClass other = (TeachingClass) that;
        return (this.getTcId() == null ? other.getTcId() == null : this.getTcId().equals(other.getTcId()))
            && (this.getTcCId() == null ? other.getTcCId() == null : this.getTcCId().equals(other.getTcCId()))
            && (this.getTcTId() == null ? other.getTcTId() == null : this.getTcTId().equals(other.getTcTId()))
            && (this.getTcCapacity() == null ? other.getTcCapacity() == null : this.getTcCapacity().equals(other.getTcCapacity()))
            && (this.getTcWeekTime() == null ? other.getTcWeekTime() == null : this.getTcWeekTime().equals(other.getTcWeekTime()))
            && (this.getTcLesson() == null ? other.getTcLesson() == null : this.getTcLesson().equals(other.getTcLesson()))
            && (this.getTcLocation() == null ? other.getTcLocation() == null : this.getTcLocation().equals(other.getTcLocation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTcId() == null) ? 0 : getTcId().hashCode());
        result = prime * result + ((getTcCId() == null) ? 0 : getTcCId().hashCode());
        result = prime * result + ((getTcTId() == null) ? 0 : getTcTId().hashCode());
        result = prime * result + ((getTcCapacity() == null) ? 0 : getTcCapacity().hashCode());
        result = prime * result + ((getTcWeekTime() == null) ? 0 : getTcWeekTime().hashCode());
        result = prime * result + ((getTcLesson() == null) ? 0 : getTcLesson().hashCode());
        result = prime * result + ((getTcLocation() == null) ? 0 : getTcLocation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tcId=").append(tcId);
        sb.append(", tcCId=").append(tcCId);
        sb.append(", tcTId=").append(tcTId);
        sb.append(", tcCapacity=").append(tcCapacity);
        sb.append(", tcWeekTime=").append(tcWeekTime);
        sb.append(", tcLesson=").append(tcLesson);
        sb.append(", tcLocation=").append(tcLocation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}