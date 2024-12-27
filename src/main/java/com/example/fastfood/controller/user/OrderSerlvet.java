package com.example.fastfood.controller.user;

import com.example.fastfood.model.Food;
import com.example.fastfood.model.Order;
import com.example.fastfood.model.User;
import com.example.fastfood.service.FoodService;
import com.example.fastfood.service.FoodServiceImpl;
import com.example.fastfood.service.OrderService;
import com.example.fastfood.service.OrderServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (value = "/order-user")
public class OrderSerlvet extends HttpServlet {
    private final OrderService orderService = new OrderServiceImpl();
    private final FoodService foodService = new FoodServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "inform":
                showInformOrder (req, resp);
                break;
            default:
                showOrderView(req, resp);
                break;
        }
    }

    private void showInformOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idOrder = Integer.parseInt(req.getParameter("idOrder"));
        System.out.println(idOrder);
        User user = (User) req.getSession().getAttribute("user");
        List<Food> foods = foodService.getFoodByIdUserAndIdOrder(user.getId(), idOrder);
        System.out.println(foods);
        req.setAttribute("foods", foods);
        req.getRequestDispatcher("/view/user/billInform.jsp").forward(req, resp);
    }

    private void showOrderView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Order> orders = orderService.getAllOrder(user.getId());
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/view/user/order.jsp").forward(req, resp);
    }
}
