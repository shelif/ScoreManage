package com.example.demo.entity;

public class DeleteClass {
    private String tcid;
    private String name;
    private float score;

    public String getTcid() {
        return tcid;
    }

    public void setTcid(String tcid) {
        this.tcid = tcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "DeleteClass{" +
                "tcid='" + tcid + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
