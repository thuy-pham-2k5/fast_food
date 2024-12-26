package com.example.fastfood.service;

import com.example.fastfood.database.ConnectDatabase;
import com.example.fastfood.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<User> getAllListCustomer() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users WHERE role = 'user'";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(getUserInDataBase(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User getUserInDataBase(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_user");
        String phone = rs.getString("phone");
        String password = rs.getString("password");
        String fullName = rs.getString("full_name");
        boolean status = rs.getBoolean("status");
        return new User(id, phone, password, fullName, status);
    }

}
