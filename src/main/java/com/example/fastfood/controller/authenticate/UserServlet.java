package com.example.fastfood.controller.authenticate;

import com.example.fastfood.model.User;
import com.example.fastfood.service.UserService;
import com.example.fastfood.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "signup":
                signup(req, resp);
                break;
            case "login":
                login(req, resp);
                break;
            default:
                break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        if (phone.length()==10 && password.length()>=6) {
            if (userService.getUserByPhone(phone)!=null) {

            }
        } else {
            resp.sendRedirect("/user");
        }
    }

    private void signup(HttpServletRequest req, HttpServletResponse resp) {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        System.out.println(phone + " " + password + " " + fullName);
        if (phone.length() == 10 && password.length() >= 6) {
            User user = userService.getUserByPhone(phone);
            if (user != null) {
                System.out.println("Da co so dien thoai nay");
            } else {
                System.out.println("Dang ky thanh cong" + phone + " " + password + " " + fullName);
            }
        } else {
            System.out.println("Error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "signup":
                showSignupView(req, resp);
                break;
            default:
                showLoginView(req, resp);
                break;
        }
    }

    private void showSignupView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    private void showLoginView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/authenticate/login.jsp");
        dispatcher.forward(req, resp);
    }
}
