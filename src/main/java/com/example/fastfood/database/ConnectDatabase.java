package com.example.fastfood.database;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mysql.jdbc.Driver;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/demo";
    private static String username = "root";
    private static String password = "1234";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        String password = "1234";
//        String hashedPassword = BCrypt.withDefaults().hashToString(5, password.toCharArray());
//        System.out.println("Hashed Password: " + hashedPassword);
//        String authenticate = "1234";
//        BCrypt.Result result = BCrypt.verifyer().verify(authenticate.toCharArray(), hashedPassword);
//        if (result.verified) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }
//    }
}
