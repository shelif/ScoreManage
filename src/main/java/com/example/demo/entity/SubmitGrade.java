package com.example.demo.entity;

public class SubmitGrade {
    private String sId;
    private String cName;
    private float scGrade;

    @Override
    public String toString() {
        return "SubmitGrade{" +
                "sId='" + sId + '\'' +
                ", cName='" + cName + '\'' +
                ", scGrade=" + scGrade +
                '}';
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public float getScGrade() {
        return scGrade;
    }

    public void setScGrade(float scGrade) {
        this.scGrade = scGrade;
    }
}
