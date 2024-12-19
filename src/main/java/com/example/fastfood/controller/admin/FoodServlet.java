package com.example.fastfood.controller.admin;

import com.example.fastfood.model.Food;
import com.example.fastfood.service.FoodService;
import com.example.fastfood.service.FoodServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (value = "/food")
public class FoodServlet extends HttpServlet {
    private FoodService foodService = new FoodServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null) action = "";
        switch (action) {
            case "add":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null) action = "";
        switch (action) {
            case "add":
                break;
            case "edit":
                break;
            case "delete":

            default:
                showAllFoods (req, resp);
                break;
        }
    }

    private void showAllFoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> foods = foodService.getAllFood();
        req.setAttribute("foods", foods);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/home.jsp");
        dispatcher.forward(req, resp);
    }
}
