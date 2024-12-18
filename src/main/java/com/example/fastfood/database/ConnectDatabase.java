package com.example.fastfood.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fast_food", "root", "1234");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fast_food", "root", "13122005");
            System.out.println("kết nối thành công");
        }
        return connection;
    }
}
