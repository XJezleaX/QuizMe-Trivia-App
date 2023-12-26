package com.example.assignment_5_frontend.model;

public class User {

    private String username;  //Variables we will need
    private String password;
    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(String username, String password) {  //Constructor for our User object
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }  //Getter and setter for everything

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
