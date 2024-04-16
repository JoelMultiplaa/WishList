package com.example.wishlist.model;

import java.util.Date;

public class User {
    private String firstname;
    private String username;
    private String password;



    public User(String firstname,String username, String password) {
        this.firstname = firstname;
        this.username =username;
        this.password = password;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setDob(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
