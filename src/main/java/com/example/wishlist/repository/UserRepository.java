package com.example.wishlist.repository;

import com.example.wishlist.model.User;
import com.example.wishlist.repository.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String user_pwd;



    public User createUser(User newUser) {
         Connection conn = ConnectionManager.getConnection(url, uid, user_pwd); {
            String SQL = "INSERT INTO user (FIRSTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?)";
           try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, newUser.getFirstName());
            pstmt.setString(2, newUser.getUsername());
            pstmt.setString(3, newUser.getPassword());

            return newUser;

             } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}






    public boolean login(String username, String password) {
        try (Connection con = DriverManager.getConnection(url, uid, user_pwd)) {
            String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        return count > 0; // Returner true, hvis der findes en bruger med det angivne brugernavn og adgangskode
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Håndter fejlhåndtering passende
        }
        return false; // Returner false, hvis der opstår en fejl eller hvis brugernavn og adgangskode ikke er fundet
    }

    public User getUserByUsername(String username) {
        try (Connection con = DriverManager.getConnection(url, uid, user_pwd)) {
            String sql = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, username);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return new User(
                                rs.getString("FIRSTNAME"),
                                rs.getString("USERNAME"),
                                rs.getString("PASSWORD"),
                                rs.getInt("USER_ID")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Håndter fejlhåndtering passende
        }
        return null; // Returner null, hvis der opstår en fejl eller hvis brugernavnet ikke findes
    }
}
