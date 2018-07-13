package com.example.demo.entity;

public class Student {
    private String sId;
    private String sUsername;
    private String sPassword;
    private String sName;
    private String sMajor;
    private String sClass;
    private float sTotalScore;
    private float sGpa;
    private float sIQ;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public float getsTotalScore() {
        return sTotalScore;
    }

    public void setsTotalScore(float sTotalScore) {
        this.sTotalScore = sTotalScore;
    }

    public float getsGpa() {
        return sGpa;
    }

    public void setsGpa(float sGpa) {
        this.sGpa = sGpa;
    }

    public float getsIQ() {
        return sIQ;
    }

    public void setsIQ(float sIQ) {

        this.sIQ = sIQ;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sUsername='" + sUsername + '\'' +
                ", sPassword='" + sPassword + '\'' +
                ", sName='" + sName + '\'' +
                ", sMajor='" + sMajor + '\'' +
                ", sClass='" + sClass + '\'' +
                ", sTotalScore=" + sTotalScore +
                ", sGpa=" + sGpa +
                ", sIQ=" + sIQ +
                '}';
    }
}
