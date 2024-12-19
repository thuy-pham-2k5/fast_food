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
    public Boolean getUserByPhone(String phone) {
        String query = "select * from users where phone = ?";
        User user = null;
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        String sql = "INSERT INTO users (phone, password, full_name, role, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDatabase.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone);
            pstmt.setString(2, password);
            pstmt.setString(3, fullName);
            pstmt.setString(4, "user");
            pstmt.setBoolean(5, true);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

