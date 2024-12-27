package com.example.fastfood.service;

import com.example.fastfood.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder (int idUser);
    List<Order> getOrderByIdUserAndIdOrder(int idUser, int idOrder);
    void addNewOrder (int idUser, String deliveryAddress, String paymentStatus, String paymentTime, String foodIds, String foodQuantites);
}
