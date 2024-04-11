package com.example.wishlist.model;

public class Wish {
    private String name;
    private String description;
    private int price;
    private int password;
    private  String id;

    public Wish(String name, String description, int price, int password, String id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.password = password;
        this.id = id;

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
}

