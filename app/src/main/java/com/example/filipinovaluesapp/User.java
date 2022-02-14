package com.example.filipinovaluesapp;

public class User {
    public Integer score;
    public String username, email, password;


    public User(String username, String email, String password, Integer score) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.score = score;
    }

    public User(){

    }
}
