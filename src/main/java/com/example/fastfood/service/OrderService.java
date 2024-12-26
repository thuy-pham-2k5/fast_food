package com.example.fastfood.service;

public interface OrderService {
    void addNewOrder (int idUser, String deliveryAddress, String paymentStatus, String paymentTime, String foodIds, String foodQuantites);
}
