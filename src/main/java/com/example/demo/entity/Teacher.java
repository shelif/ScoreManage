package com.example.demo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Teacher implements Serializable {
    private String tId;

    private String tUsername;

    private String tPassword;

    private String tName;

    private static final long serialVersionUID = 1L;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettUsername() {
        return tUsername;
    }

    public void settUsername(String tUsername) {
        this.tUsername = tUsername;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
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
        Teacher other = (Teacher) that;
        return (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.gettUsername() == null ? other.gettUsername() == null : this.gettUsername().equals(other.gettUsername()))
            && (this.gettPassword() == null ? other.gettPassword() == null : this.gettPassword().equals(other.gettPassword()))
            && (this.gettName() == null ? other.gettName() == null : this.gettName().equals(other.gettName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((gettUsername() == null) ? 0 : gettUsername().hashCode());
        result = prime * result + ((gettPassword() == null) ? 0 : gettPassword().hashCode());
        result = prime * result + ((gettName() == null) ? 0 : gettName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tId=").append(tId);
        sb.append(", tUsername=").append(tUsername);
        sb.append(", tPassword=").append(tPassword);
        sb.append(", tName=").append(tName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}