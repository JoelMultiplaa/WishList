package com.example.wishlist.service;

import com.example.wishlist.model.Wish;
import com.example.wishlist.model.WishList;
import com.example.wishlist.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    private final WishRepository wishRepository;

    @Autowired
    public WishListService(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    public List<Wish> getAllWishes() {
        return wishRepository.getAllWishes();
    }

    public Wish getWishById(int id) {
        return wishRepository.getWishById(id);
    }

    public void createWish(Wish wish) {
        wishRepository.createWish(wish);
    }

    public Wish updateWish(int id, Wish updatedWish) {
        return wishRepository.updateWish(id, updatedWish);
    }

    public void deleteWish(int id) {
        wishRepository.deleteWish(id);
    }

    public List<WishList> getAllWishLists() {
        return wishRepository.getAllWishLists();
    }

   /* public WishList getWishListById(int id) {
        return wishRepository.getWishListById(id);
    }*/

    public void createWishList(WishList wishList) {
        wishRepository.createWishList(wishList);
    }

    public void updateWishList(int id, WishList updatedWishList) {
        wishRepository.updateWishList(id, updatedWishList);
    }

    public void deleteWishList(int id) {
        wishRepository.deleteWishList(id);
    }
}
