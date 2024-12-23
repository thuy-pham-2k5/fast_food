package com.example.fastfood.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/home-user")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null) action = "";
        switch (action) {
            default:
                showHomeUserView (req, resp);
                break;
        }
    }

    private void showHomeUserView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("successful");
        req.getRequestDispatcher("/view/user/home.jsp").forward(req, resp);
    }
}
