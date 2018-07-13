package com.example.demo.entity;

public class SubmitClass {
    private String cid;
    private String name;
    private float score;
    private String tcid;
    private String time;
    private String location;
    private String capacity;
    private String temp;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getTcid() {
        return tcid;
    }

    public void setTcid(String tcid) {
        this.tcid = tcid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "SubmitClass{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", tcid='" + tcid + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", capacity='" + capacity + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
