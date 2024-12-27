package com.example.fastfood.controller.user;

import com.example.fastfood.model.Food;
import com.example.fastfood.model.User;
import com.example.fastfood.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/cart-user")
public class CartServlet extends HttpServlet {
    private final FoodService foodService = new FoodServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "order":
                showOrderFood(req, resp);
                break;
            case "payment":
                paymentOrder (req, resp);
                break;
            default:
                break;
        }
    }

    private void paymentOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] foodIds = req.getParameterValues("foodId");
        String[] foodQuantities = req.getParameterValues("foodQuantity");
        String paymentStatus = req.getParameter("pay_status");
        String address = req.getParameter("address");

        String foodIdsString = String.join(",", foodIds);
        String foodQuantitiesString = String.join(",", foodQuantities);

        User user = (User) req.getSession().getAttribute("user");

        String paymentTime = "";
        if (paymentStatus.equals("paid")) {
            paymentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }

        this.orderService.addNewOrder(user.getId(), address, paymentStatus, paymentTime, foodIdsString, foodQuantitiesString);
        resp.sendRedirect("/home-user");
    }

    private void showOrderFood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] foodIds = req.getParameterValues("foodId");
        String[] foodQuantities = req.getParameterValues("foodQuantity");
        if (foodIds == null || foodQuantities == null || foodIds.length == 0 || foodQuantities.length == 0) {
            System.out.println("No food selected");
        } else {
            List<Food> foods = new ArrayList<>();
            for (int i = 0; i < foodIds.length; i++) {
                try {
                    int id = Integer.parseInt(foodIds[i]);
                    int quantity = Integer.parseInt(foodQuantities[i]);
                    foods.add(foodService.getFoodByIdAndQuantity(id, quantity));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            List<Integer> quantities = new ArrayList<>();
            for (String quantity : foodQuantities) {
                quantities.add(Integer.parseInt(quantity));
            }
            req.setAttribute("foods", foods);
            req.getRequestDispatcher("/view/user/bill.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "delete":
                deleteFood(req, resp);
                break;
            default:
                showAllFood(req, resp);
                break;
        }
    }

    private void deleteFood(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        List<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
        cart.removeIf(idFood -> idFood.equals(id));
        session.setAttribute("cart", cart);
        System.out.println(cart);
        resp.sendRedirect("/cart-user");
    }

    private void showAllFood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
        List<Food> foods = new ArrayList<>();
        for (Integer id : cart) {
            foods.add(foodService.getFoodById(id));
        }
        req.setAttribute("foods", foods);
        req.getRequestDispatcher("/view/user/cart.jsp").forward(req, resp);
    }
}
