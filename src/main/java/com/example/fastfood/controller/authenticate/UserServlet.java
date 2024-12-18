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

@WebServlet(value = "/authenticate/user")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null) {
            action = "";
        }
        System.out.println("action" + action);
        switch (action) {
            case "signup":
                signup(req, resp);
                break;
            default:
                show (req, resp);
                break;
        }
    }

    private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/authenticate/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "signup":
                signup(req, resp);
                break;
            default:
                break;
        }
    }
    private void signup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String fullName = req.getParameter("fullName");

        if (phone.length() == 10 && password.length() >= 6) {
            if (!password.equals(confirmPassword)) {
                req.setAttribute("errorMessage", "Mật khẩu và xác nhận mật khẩu không khớp");
                show(req, resp);
                return;
            }

            User user = userService.getUserByPhone(phone);
            if (user != null) {
                req.setAttribute("errorMessage", "Đã có số điện thoại này");
                show(req, resp);
            } else {
                userService.registerUser(phone, password, fullName);
            }
        } else {
            req.setAttribute("errorMessage", "Error: Số điện thoại hoặc mật khẩu không hợp lệ");
            show(req, resp);
        }
    }



}
