package com.example.wishlist.repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection conn;

    private ConnectionManager() {
    }

    public static Connection getConnection(String url, String user_id, String user_pwd) {

        if (conn != null) return conn;

        try {
            conn = DriverManager.getConnection(url, user_id, user_pwd);

        } catch (SQLException e) {
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }
        return conn;
    }
}