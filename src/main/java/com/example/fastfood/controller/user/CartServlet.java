package com.example.fastfood.controller.user;

import com.example.fastfood.model.Food;
import com.example.fastfood.service.FoodService;
import com.example.fastfood.service.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/cart-user")
public class CartServlet extends HttpServlet {
    private final FoodService foodService = new FoodServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null) action="";
        switch (action) {
            case "order":
                orderFood (req, resp);
                break;
            default:
                break;
        }
    }

    private void orderFood(HttpServletRequest req, HttpServletResponse resp) {
        String[] foodIds = req.getParameterValues("foodId");
        String[] foodQuantities = req.getParameterValues("foodQuantity");
        if ((foodIds==null && foodQuantities==null) || (foodIds.length==0 && foodQuantities.length==0)) {
            System.out.println("No food selected");
        }
        else {
            for (String id: foodIds) {
                System.out.println("idFood: " + id);
            }
            for (String quantity: foodQuantities) {
                System.out.println("quantity: " + quantity);
            }
            System.out.println(req.getSession().getAttribute("user"));
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
                deleteFood (req, resp);
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
