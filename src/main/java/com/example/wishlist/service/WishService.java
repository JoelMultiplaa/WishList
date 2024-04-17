package com.example.wishlist.service;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.WishRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class WishService {
    private WishRepository wishRepository;

    public WishService (WishRepository wishRepository){
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


}
