package com.example.fastfood.controller.authenticate;

import com.example.fastfood.model.User;
import com.example.fastfood.service.UserService;
import com.example.fastfood.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/sign-up")
public class SignupServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        if (phone.length()==10 && password.length()>=6) {
            User user = userService.getUserByPhone(phone);
            if (user!=null) {
                System.out.println("chua co so dien thoai nay");
            } else {

            }
        }
    }
}
