package com.example.wishlist.service;

import com.example.wishlist.model.User;
import com.example.wishlist.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void createUser(User newUser){
        userRepository.createUser(newUser);
    }
    public boolean loginUser(String username, String password) {
        // Kalder login-metoden i UserRepository for at validere loginoplysninger
        return userRepository.login(username, password);
    }
}
