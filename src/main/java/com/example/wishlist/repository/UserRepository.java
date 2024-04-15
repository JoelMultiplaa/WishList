package com.example.wishlist.repository;

import com.example.wishlist.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        // Tilføj nogle startbrugere til listen (bare til testformål)
        users.add(new User("Joel", "Darko", "Joel17", "joel@hotmail.com", "1990-01-01", "1111111"));
        users.add(new User("Berzan", "Savuran", "Berzan20", "b@hotmail.com", "1985-05-15", "654321"));
        users.add(new User("Ali", "Hussain", "Ali17", "ali@hotmail.com", "1988-10-25", "123456"));
    }

    public boolean addUser(User user) {
        // Kontroller, om brugernavnet allerede eksisterer
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                return false; // Brugeren findes allerede
            }
        }
        // Tilføj den nye bruger
        users.add(user);
        return true; // Brugeren blev tilføjet
    }

    public boolean login(String username, String password) {
        // Implementer logik til at validere brugerens loginoplysninger
        // Returner true, hvis loginoplysningerne er korrekte, ellers returner false
        // Her kan du tilføje kode til at tjekke brugernavn og adgangskode mod din database eller anden lagring
        return true; // Simulerer en succesfuld login - du skal implementere den faktiske logik
    }
}
