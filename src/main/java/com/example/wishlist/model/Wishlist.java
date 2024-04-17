package com.example.wishlist.model;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {

    private int user_id;
    private int wishListId;
    private String name;
    private String description;
    private List<Wish> wishList = new ArrayList<>();


    // Constructor
    public Wishlist(String name, String description, int wishListId, int user_id) {

        this.name = name;
        this.description = description;
        this.wishListId = wishListId;
        this.wishList = new ArrayList<>();
        this.user_id = user_id;

    }

    public Wishlist() {

    }

    public int getUser_id() {
        return user_id;
    }



    public String getName() {

        return name;
    }

    public int getWishListId() {

        return wishListId;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setUser_id(int user_id) {

        this.user_id = user_id;
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

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishListId=" + wishListId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", wishList=" + wishList +
                '}';
    }
}
