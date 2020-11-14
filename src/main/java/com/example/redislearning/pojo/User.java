package com.example.redislearning.pojo;

public class User {

    public User() {
    }

    public User(long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    private long uid;
    private String name;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
