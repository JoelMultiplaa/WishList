package com.example.wishlist.model;

import java.util.Date;

public class User {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;

    private String dateOfBirth;


    public User(String firstname, String lastname, String username, String email,String dateOfBirth, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username =username;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }


    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getUsername() {

        return username;
    }

    public void setDob(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
