package com.example.wishlist.repository;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class WishlistRepository {

    @Value("jdbc:mysql://localhost:3306/Wishlist")
    String url;
    @Value("root")
    String admin_id;
    @Value("Kwc52vap2qc#")
    String user_pwd;


    private List<Wishlist> wishLists = new ArrayList<>();

    private ConnectionManager connectionManager;


    public List<Wishlist> getAllWishLists() {
        return wishLists;
    }



    public Wishlist createWishlist(Wishlist newWishList ) {

        try (Connection con = DriverManager.getConnection(url, admin_id, user_pwd)) {
            String SQL = "INSERT INTO wishlist (user_id, name, description) VALUES(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, newWishList.getUser_id());
            pstmt.setString(2, newWishList.getName());
            pstmt.setString(3, newWishList.getDescription());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return newWishList;
    }

        public void updateWishList ( int id, Wishlist updatedWishList){
            for (int i = 0; i < wishLists.size(); i++) {
                if (wishLists.get(i).getWishListId() == id) {
                    wishLists.set(i, updatedWishList);
                    break;
                }
            }
        }

        public void deleteWishList ( int id){
            wishLists.removeIf(w -> w.getWishListId() == id);
        }

        public Wishlist getWishListById ( int id){
            for (Wishlist wishlist : wishLists) {
                if (wishlist.getWishListId() == id) {
                    return wishlist;
                }
            }
            return null; // Returner null, hvis ønskelisten ikke findes
        }
    }

