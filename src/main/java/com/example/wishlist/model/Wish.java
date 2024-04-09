package com.example.wishlist.model;

public class Wish {
    private String name;
    private String description;
    private int price;

    public Wish(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public String getName(){
        return description;
    }

    public void setName(String name){
        this.name = name;
    }



}
