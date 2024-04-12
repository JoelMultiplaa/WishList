
package com.example.wishlist.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.wishlist.model.Wish;


@Repository
public class WishRepository {
    private List<Wish> wishes = new ArrayList<>();

    public WishRepository() {
        // Tilføj nogle eksempel ønsker til listen
        wishes.add(new Wish("Birthday Cake", "A delicious cake for my birthday", 120));
        wishes.add(new Wish("Iphone 15", "The latest model of smartphone", 2500));
        wishes.add(new Wish("Shoes", "Nike Air Max", 1000));
    }

    public List<Wish> getAllWishes() {
        return wishes;
    }

    public Wish getWishById(int id) {
        // Find ønsket baseret på dets id
        Optional<Wish> wishOptional = wishes.stream().filter(w -> w.getId() == id).findFirst();
        return wishOptional.orElse(null);
    }

    public Wish createWish(Wish wish) {
        // Tilføj det nye ønske til listen
        wishes.add(wish);
        return wish;
    }

    public Wish updateWish(int id, Wish updatedWish) {
        // Find og opdater det ønskede ønske
        for (int i = 0; i < wishes.size(); i++) {
            if (wishes.get(i).getId() == id) {
                wishes.set(i, updatedWish);
                return updatedWish;
            }
        }
        return null;
    }

    public void deleteWish(int id) {
        // Slet ønsket baseret på dets id
        wishes.removeIf(w -> w.getId() == id);
    }
}