package com.example.fastfood.service;

import com.example.fastfood.database.ConnectDatabase;
import com.example.fastfood.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByPhone(String phone) {
        String query = "select * from users where phone = ?";
        User user = null;
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
}

