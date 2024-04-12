package com.example.wishlist.repository;

import com.example.wishlist.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User>  users = new ArrayList<>(List.of(
            new User("Joel", "hemmelighed"),
            new User("Berzan", "bibloteket"),
            new User("Ali", "mazza")));

    public boolean getUser(String username) {
        for (User user:users) {
            if(user.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public boolean login(String id, String password){
        // Implementer logik til at validere brugerens loginoplysninger
        // Returner true, hvis loginoplysningerne er korrekte, ellers returner false
        return true;
    }

}