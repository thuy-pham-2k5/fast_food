package com.example.fastfood.controller.admin;

import com.example.fastfood.model.User;
import com.example.fastfood.service.CustomerService;
import com.example.fastfood.service.CustomerServiceImpl;
import com.example.fastfood.service.UserService;
import com.example.fastfood.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/customer")
public class CustomerServlet extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "changeStatus":
                changeStatus (req, resp);
                break;
            default:
                showListCustomer(req, resp);
                break;
        }
    }

    private boolean changeStatus(HttpServletRequest req, HttpServletResponse resp) {
            int userId = Integer.parseInt(req.getParameter("id"));
            Boolean status = userService.getStatusById(userId);
            boolean newStatus = !status;
            userService.updateStatusById(userId, newStatus);
            try {
                resp.sendRedirect("/customer");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return newStatus;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "changeStatus":
                changeStatus (req, resp);
                break;
            default:
                showListCustomer(req, resp);
                break;
        }
    }
    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = customerService.getAllListCustomer();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/customer.jsp");
        dispatcher.forward(request, response);
    }
}
