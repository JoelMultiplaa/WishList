package com.example.wishlist.service;

import com.example.wishlist.controller.WishlistController;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.WishRepository;
import com.example.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }


   /* public WishList getWishListById(int id) {
        return wishRepository.getWishListById(id);
    }*/

    public void createWishList(Wishlist wishList) {
        wishlistRepository.createWishList(wishList);
    }

    public void updateWishList(int id, Wishlist updatedWishList) {
        wishlistRepository.updateWishList(id, updatedWishList);
    }

    public void deleteWishList(int id) {
        wishlistRepository.deleteWishList(id);
    }
    public List<Wishlist> getAllWishLists() {
        return wishlistRepository.getAllWishLists();
    }

}
