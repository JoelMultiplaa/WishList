package com.example.wishlist.model;

public class User {
    private String firstname;
    private String username;
    private String password;

    private int user_id;



    public User(String firstname,String username, String password, int user_id) {
        this.firstname = firstname;
        this.username =username;
        this.password = password;
        this.user_id = user_id;
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
    public int getUser_id(){
        return user_id;
    }

    public void setUser_id(int anInt) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {

        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
