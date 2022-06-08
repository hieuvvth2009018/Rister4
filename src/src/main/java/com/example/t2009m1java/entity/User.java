package com.example.t2009m1java.entity;

import com.example.t2009m1java.entity.base.BaseEntity;

public class User extends BaseEntity {
    private int id;
    private String username;
    private String passwordHash;
    private int status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", status=" + status +
                '}';
    }

    public User() {
    }

    public User(String username, String passwordHash, int status) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.status = status;
    }

    public User(int id, String username, String passwordHash, int status) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
