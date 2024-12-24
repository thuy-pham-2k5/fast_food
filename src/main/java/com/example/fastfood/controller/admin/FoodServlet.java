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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(value = "/food")
public class FoodServlet extends HttpServlet {
    private FoodService foodService = new FoodServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                addNewFood (req, resp);
                break;
            case "edit":
                editInformFood (req, resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
            default:
                break;
        }
    }

    private void editInformFood(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String imageUrl = req.getParameter("imageUrl");
        String type = req.getParameter("type");
        Food food = new Food(id, name, description, price, quantity, imageUrl, type);
        this.foodService.update(id, food);

        resp.sendRedirect("/food");
    }

    private void addNewFood(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String imageUrl = req.getParameter("imageUrl");
        String type = req.getParameter("type");
        Food food = new Food(name, description, price, quantity, imageUrl, type);
        this.foodService.add(food);

        resp.sendRedirect("food");
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        HttpSession session = req.getSession();
        session.setAttribute("keyword", keyword);
        req.setAttribute("foods", foodService.searchByName(keyword));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                showAddFood (req, resp);
                break;
            case "edit":
                showEditFood (req, resp);
                break;
            case "delete":
                deleteFood(req, resp);
                break;
            default:
                showAllFoods(req, resp);
                break;
        }
    }

    private void showEditFood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idFood"));
        req.setAttribute("food", foodService.getFoodById(id));
        req.getRequestDispatcher("/view/admin/editFood.jsp").forward(req, resp);
    }

    private void showAddFood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/admin/addFood.jsp").forward(req, resp);
    }

    private void deleteFood(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int idFood = Integer.parseInt(req.getParameter("idFood"));
        foodService.delete(idFood);
        HttpSession session = req.getSession();
        String keyword = (String) session.getAttribute("keyword");
        if (keyword==null) {
            resp.sendRedirect("/food");
        } else {
            req.setAttribute("foods", foodService.searchByName(keyword));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/home.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void showAllFoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> foods = foodService.getAllFood();
        req.setAttribute("foods", foods);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/home.jsp");
        dispatcher.forward(req, resp);
    }
}
