package com.example.wishlist.repository;

import com.example.wishlist.model.User;
import com.example.wishlist.model.Wish;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String user_id;
    @Value("$spring.datasource.password")
    String user_pwd;

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        // Tilføj nogle startbrugere til listen (bare til testformål)
        users.add(new User("Joel", "Joel17", "1111111"));
        users.add(new User("Berzan",  "Berzan20",   "654321"));
        users.add(new User("Ali", "Ali17",   "123456"));
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

    public void createUser(User newUser) {
        try (Connection con = DriverManager.getConnection(url, user_id, user_pwd)) {
            String SQL = "INSERT INTO WishList (FIRSTNAME, USERNAME, PASSWORD) VALUES(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, newUser.getFirstName());
            pstmt.setString(2, newUser.getUsername());
            pstmt.setString(3, newUser.getPassword());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
