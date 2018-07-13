package com.example.demo.entity;

public class ScModel {
    private String scSId;
    private String scCId;
    private float scGrade;

    @Override
    public String toString() {
        return "ScModel{" +
                "scSId='" + scSId + '\'' +
                ", scCId='" + scCId + '\'' +
                ", scGrade=" + scGrade +
                '}';
    }

    public ScModel() {
        this.scGrade=-1;
    }

    public String getScSId() {
        return scSId;
    }

    public void setScSId(String scSId) {
        this.scSId = scSId;
    }

    public String getScCId() {
        return scCId;
    }

    public void setScCId(String scCId) {
        this.scCId = scCId;
    }

    public float getScGrade() {
        return scGrade;
    }

    public void setScGrade(float scGrade) {
        this.scGrade = scGrade;
    }
}
