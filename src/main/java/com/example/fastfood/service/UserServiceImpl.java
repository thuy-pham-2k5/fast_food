package com.example.fastfood.service;

import com.example.fastfood.database.ConnectDatabase;
import com.example.fastfood.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByPhone(String phone) {
        String query = "select * from users where phone = ?";
        User user = null;
        HttpSessionListener listener;
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id_user");
                String phone1 = resultSet.getString("phone");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                String role = resultSet.getString("role");
                Boolean status = resultSet.getBoolean("status");
                user = new User(id, phone1, password, fullName, role, status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User login(String phone, String password) {
        String query = "select * from users where phone = ? and password = ?";
        User user = null;
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String fullName = resultSet.getString("full_name");
                String role = resultSet.getString("role");
                boolean status = resultSet.getBoolean("status");
                user = new User(idUser, phone, password, fullName, role, status);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registerUser(String phone, String password, String fullName) {
        try (Connection conn = ConnectDatabase.getConnection()) {
            String sql = "INSERT INTO users (phone, password, full_name, role, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone);
            pstmt.setString(2, password);
            pstmt.setString(3, fullName);
            pstmt.setString(4, "user");
            pstmt.setBoolean(5, Boolean.parseBoolean("activity"));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

