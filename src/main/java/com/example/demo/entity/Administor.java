package com.example.demo.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Administor implements Serializable {
    private String aId;

    private String aUsername;

    private String aPassword;

    private static final long serialVersionUID = 1L;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaUsername() {
        return aUsername;
    }

    public void setaUsername(String aUsername) {
        this.aUsername = aUsername;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
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
        Administor other = (Administor) that;
        return (this.getaId() == null ? other.getaId() == null : this.getaId().equals(other.getaId()))
            && (this.getaUsername() == null ? other.getaUsername() == null : this.getaUsername().equals(other.getaUsername()))
            && (this.getaPassword() == null ? other.getaPassword() == null : this.getaPassword().equals(other.getaPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getaId() == null) ? 0 : getaId().hashCode());
        result = prime * result + ((getaUsername() == null) ? 0 : getaUsername().hashCode());
        result = prime * result + ((getaPassword() == null) ? 0 : getaPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aId=").append(aId);
        sb.append(", aUsername=").append(aUsername);
        sb.append(", aPassword=").append(aPassword);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}