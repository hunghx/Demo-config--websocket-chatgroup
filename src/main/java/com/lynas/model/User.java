package com.lynas.model;

/**
 * Created by sazzad on 2/15/16
 */
public class User {
    private String name;
    private String mess;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String mess) {
        this.name = name;
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }
}
