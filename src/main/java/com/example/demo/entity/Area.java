package com.example.demo.entity;

import java.util.Date;

public class Area {
    private Integer areaId;
    private String areaNmae;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaNmae() {
        return areaNmae;
    }

    public void setAreaNmae(String areaNmae) {
        this.areaNmae = areaNmae;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaNmae='" + areaNmae + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }
}
