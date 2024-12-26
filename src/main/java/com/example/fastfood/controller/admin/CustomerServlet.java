package com.example.fastfood.controller.admin;

import com.example.fastfood.model.User;
import com.example.fastfood.service.CustomerService;
import com.example.fastfood.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/customer")
public class CustomerServlet extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            default:
                showListCustomer(req, resp);
                break;
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
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
