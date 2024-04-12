package com.example.wishlist.service;
import com.example.wishlist.model.Wish;
import com.example.wishlist.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishListService {

    private WishRepository wishRepository;

    public List<Wish> getAllWishes() {
        return wishRepository.getAllWishes();
    }

    public Wish getWishById(int id) {
        return wishRepository.getWishById(id);
    }

    public Wish createWish(Wish wish) {
        // Implementer eventuel validering af ønsket før oprettelse
        return wishRepository.createWish(wish);
    }

    public Wish updateWish(int id, Wish updatedWish) {
        // Implementer eventuel validering af opdaterede ønsket før opdatering
        return wishRepository.updateWish(id, updatedWish);
    }

    public void deleteWish(int id) {
        wishRepository.deleteWish(id);
    }
}
