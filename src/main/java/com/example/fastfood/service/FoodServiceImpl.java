package com.example.fastfood.service;

import com.example.fastfood.database.ConnectDatabase;
import com.example.fastfood.model.Food;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    @Override
    public List<Food> getAllFood() {
        List<Food> foods = new ArrayList<>();
        String query = "select * from foods";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foods.add(getFoodInDatabase(resultSet));
            }
            return foods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Food getFoodById(int id) {
        String query = "select * from foods where id_food = ?";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getFoodInDatabase(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Food food) {
        String query = "INSERT INTO foods (`name`, `description`, `price`, `quantity`, `image_url`) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, food.getName());
            preparedStatement.setString(2, food.getDescription());
            preparedStatement.setDouble(3, food.getPrice());
            preparedStatement.setInt(4, food.getQuantity());
            preparedStatement.setString(5, food.getImageUrl());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Food food) {
        String query = "UPDATE `fast_food`.`foods` SET `name` = ?, `description` = ?, `price` = ?, `quantity` = ?, image_url = ? WHERE (`id_food` = ?)";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, food.getName());
            preparedStatement.setString(2, food.getDescription());
            preparedStatement.setDouble(3, food.getPrice());
            preparedStatement.setInt(4, food.getQuantity());
            preparedStatement.setString(5, food.getImageUrl());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "delete from foods where id_food = ?";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Food> searchByName(String keyword) {
        String query = "{call searchFoodsByName (?)}";
        List<Food> foods = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, keyword);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                foods.add(getFoodInDatabase(resultSet));
            }
            return foods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Food getFoodInDatabase(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_food");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        double price = resultSet.getDouble("price");
        int quantity = resultSet.getInt("quantity");
        String imageUrl = resultSet.getString("image_url");
        return new Food(id, name, description, price, quantity, imageUrl);
    }
}
