package com.example.fastfood.controller.user;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/home-user")
public class HomeServlet extends HttpServlet {
    private final FoodService foodService = new FoodServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "search":
                searchByName(req, resp);
                break;
            case "addToCart":
                addToCart(req, resp);
                break;
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        HttpSession session = req.getSession();
        session.setAttribute("keyword", keyword);
        req.setAttribute("foods", foodService.searchByName(keyword));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/user/home.jsp");
        dispatcher.forward(req, resp);
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        List<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isExisting = cart.stream().anyMatch(idFood -> idFood.equals(id));
        if (!isExisting) {
            cart.add(id);
        }
        session.setAttribute("cart", cart);
        resp.sendRedirect("/home-user");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "searchType":
                searchByTypeFood (req, resp);
                break;
            default:
                showHomeUserView(req, resp);
                break;
        }
    }
    private void searchByTypeFood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (type.equals("a")) {
            type = "Gà tây, Bò hầm";
        } else if (type.equals("b")) {
            type = "Bánh kem";
        } else if (type.equals("c")) {
            type = "Kẹo";
        }
        req.setAttribute("foods", foodService.searchByType(type));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/user/home.jsp");
        dispatcher.forward(req, resp);
    }

    private void showHomeUserView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> foods = foodService.getAllFood();
        req.setAttribute("foods", foods);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/user/home.jsp");
        requestDispatcher.forward(req, resp);
    }
}
