package com.example.wishlist.model;

import java.util.ArrayList;
import java.util.List;

public class WishList {
    private int wishListId;
    private String name;
    private String description;
    private List<Wish> wishList = new ArrayList<>();


    // Constructor
    public WishList(String name, String description, int wishListId) {

        this.name = name;
        this.description = description;
        this.wishListId = wishListId;
        this.wishList = new ArrayList<>();

    }

    public WishList() {

    }

    // Getters and Setters

    public String getName() {

        return name;
    }

    public int getWishListId() {

        return wishListId;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setWishListId(int wishListId) {

        this.wishListId = wishListId;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public List<Wish> getWishList() {
        return wishList;
    }

    public void setWishList(List<Wish> wishList) {
        this.wishList = wishList;
    }
}
