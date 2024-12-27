package com.example.fastfood.service;

import com.example.fastfood.database.ConnectDatabase;
import com.example.fastfood.model.Food;
import com.example.fastfood.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> getAllOrder(int idUser) {
        String query = "select * from orders where id_user = ?";
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idOrder = resultSet.getInt(1);
                String orderTime = resultSet.getString(3);
                String deliveryAddress = resultSet.getString(4);
                String orderStatus = resultSet.getString(5);
                double amount = resultSet.getDouble(6);
                int totalFood = resultSet.getInt(7);
                String paymentStatus = resultSet.getString(8);
                String paymentTime = resultSet.getString(9);
                orders.add(new Order(idOrder, idUser, orderTime, deliveryAddress, orderStatus, amount, totalFood, paymentStatus, paymentTime));
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getOrderByIdUserAndIdOrder(int idUser, int idOrder) {
        String query = "{CALL getOrderByIdUserAndIdOrder(?,?)}";
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, idUser);
            callableStatement.setInt(2, idOrder);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String orderTime = resultSet.getString(3);
                String deliveryAddress = resultSet.getString(4);
                String orderStatus = resultSet.getString(5);
                double amount = resultSet.getDouble(6);
                int totalFood = resultSet.getInt(7);
                String paymentStatus = resultSet.getString(8);
                String paymentTime = resultSet.getString(9);
                String foodIds = resultSet.getString(10);
                String foodQuantities = resultSet.getString(11);
                orders.add(new Order(idOrder, idUser, orderTime, deliveryAddress, orderStatus, amount, totalFood, paymentStatus, paymentTime, foodIds, foodQuantities));
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public void addNewOrder(int idUser, String deliveryAddress, String paymentStatus, String paymentTime, String foodIds, String foodQuantites) {
        String query = "{CALL createOrderAndFoodOrder(?, ?, ?, ?, ?, ?)}";
        try (Connection connection = ConnectDatabase.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, idUser);
            callableStatement.setString(2, deliveryAddress);
            if (paymentStatus.equals("paid")) {
                callableStatement.setString(3, "Đã thanh toán");
            } else if (paymentStatus.equals("unpaid")) {
                callableStatement.setString(3, "Chưa thanh toán");
            }
            callableStatement.setString(4, paymentTime);
            callableStatement.setString(5, foodIds);
            callableStatement.setString(6, foodQuantites);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
