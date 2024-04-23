package com.example.wishlist.service;

import com.example.wishlist.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // Først skal vi kontrollere, om brugernavnet allerede eksisterer
        User existingUser = (User) userRepository.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            // Brugernavnet eksisterer allerede, returner null for at angive, at registrering mislykkedes
            return null;
        }

        // Brugernavnet er unikt, så opret brugeren i databasen
        return (User) userRepository.createUser((com.example.wishlist.model.User) user);
    }

    public boolean loginUser(String username, String password) {
        // Kalder login-metoden i UserRepository for at validere loginoplysninger
        return userRepository.login(username, password);
    }
}
