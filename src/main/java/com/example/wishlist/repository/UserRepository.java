package com.example.wishlist.repository;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

List<User>  users = new ArrayList<>(List.of(
        new User("Joel", "hemmelighed"),
        new User("Berzan", "bibloteket"),
        new User("Ali", "mazza"));

public User getUser(String id) {
    for (User user:users) {
        if(user.getid().equals(id))
            return user;
    }
}
}