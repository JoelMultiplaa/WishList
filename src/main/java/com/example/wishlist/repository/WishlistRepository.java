package com.example.wishlist.repository;


import com.example.wishlist.model.Wishlist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WishlistRepository {

    private List<Wishlist> wishLists = new ArrayList<>();

    public List<Wishlist> getAllWishLists() {
        return wishLists;
    }

    public void createWishList(Wishlist newWishList) {
        wishLists.add(newWishList);
    }

    public void updateWishList(int id, Wishlist updatedWishList) {
        for (int i = 0; i < wishLists.size(); i++) {
            if (wishLists.get(i).getWishListId() == id) {
                wishLists.set(i, updatedWishList);
                break;
            }
        }
    }

    public void deleteWishList(int id) {
        wishLists.removeIf(w -> w.getWishListId() == id);
    }

}
