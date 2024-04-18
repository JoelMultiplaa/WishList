package com.example.wishlist.service;

import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {

        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> getAllWishLists() {
        return wishlistRepository.getAllWishLists();
    }


    public Wishlist getWishlistById(int id) {
        return wishlistRepository.getWishListById(id);
    }

    public void creteWishlist (Wishlist wishList) {
        wishlistRepository.createWishlist(wishList);
    }

    public void updateWishlist(int id, Wishlist updatedWishList) {
        wishlistRepository.updateWishList(id, updatedWishList);
    }

    public void deleteWishList(int id) {
        wishlistRepository.deleteWishList(id);
    }

}
