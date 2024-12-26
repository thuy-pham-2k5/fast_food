package com.example.fastfood.service;

import com.example.fastfood.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public interface UserService {
    Boolean getUserByPhone (String phone);
    Boolean getStatusById (int id);
    User login (String phone, String password);
    void registerUser(String phone , String password , String fullName);

    boolean updateStatusById(int userId, boolean newStatus);
}
