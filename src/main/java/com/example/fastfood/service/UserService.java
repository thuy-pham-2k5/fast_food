package com.example.fastfood.service;

import com.example.fastfood.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User getUserByPhone (String phone);
    User login (String phone, String password);
    void registerUser(String phone , String password , String fullName);
}
