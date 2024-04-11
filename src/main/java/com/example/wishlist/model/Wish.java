package com.example.wishlist.model;

public class Wish {
    private int id;
    private String name;
    private String description;
    private int price;


    public Wish(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public String getName(){

        return name;
    }


    public int getPrice() {

        return price;
    }

    public String getDescription() {

        return description;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setPrice(int price) {

        this.price = price;
    }
    public int getId(){
        return id;
    }
}

