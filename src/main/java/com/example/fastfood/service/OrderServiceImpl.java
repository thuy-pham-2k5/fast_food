package com.example.fastfood.service;

import com.example.fastfood.database.ConnectDatabase;
import com.example.fastfood.model.Food;
import com.example.fastfood.model.Order;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public void addNewOrder(int idUser, String deliveryAddress, String paymentStatus, String paymentTime, String foodIds, String foodQuantites) {
        String query = "{CALL createOrderAndFoodOrder(?, ?, ?, ?, ?, ?)}";
        try (Connection connection = ConnectDatabase.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, idUser);
            callableStatement.setString(2, deliveryAddress);
            callableStatement.setString(3, paymentStatus);
            callableStatement.setString(4, paymentTime);
            callableStatement.setString(5, foodIds);
            callableStatement.setString(6, foodQuantites);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
