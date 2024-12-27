package com.example.fastfood.service;

import com.example.fastfood.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAllFood();
    Food getFoodById (int id);
    Food getFoodByIdAndQuantity (int id, int quantity);
    void add (Food food);
    void update (int id, Food food);
    void delete (int id);
    List<Food> searchByName (String keyword);
}
