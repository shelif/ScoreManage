package com.example.demo.entity;

import java.util.List;

public class TeacherSelfInfo {
    private String tName;
    private String tId;
    private List<SubmitClass> submitClasses;

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public List<SubmitClass> getSubmitClasses() {
        return submitClasses;
    }

    public void setSubmitClasses(List<SubmitClass> submitClasses) {
        this.submitClasses = submitClasses;
    }

    @Override
    public String toString() {
        return "TeacherSelfInfo{" +
                "tName='" + tName + '\'' +
                ", tId='" + tId + '\'' +
                ", submitClasses=" + submitClasses +
                '}';
    }
}
