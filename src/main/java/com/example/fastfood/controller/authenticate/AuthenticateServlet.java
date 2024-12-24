package com.example.fastfood.controller.authenticate;

import com.example.fastfood.model.User;
import com.example.fastfood.service.UserService;
import com.example.fastfood.service.UserServiceImpl;
import com.sun.net.httpserver.spi.HttpServerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/authenticate")
public class AuthenticateServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

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
            case "login":
                login(req, resp);
                break;
            default:
                break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        User user = userService.login(phone, password);
        if (user != null) {
            session.setAttribute("idUser", user.getId());
            if (user.getStatus()) {
                if (user.getRole().equals("admin")) {
                    resp.sendRedirect("food");
                } else if (user.getRole().equals("user")) {
                    resp.sendRedirect("home-user");
                }
            } else {
                session.setAttribute("errorMessage", "Tài khoản đã bị khóa");
                resp.sendRedirect("/authenticate");
            }
        } else {
            session.setAttribute("errorMessage", "Tài khoản không tồn tại");
            resp.sendRedirect("/authenticate");
        }
    }

    private void setSessionWhenLogin (HttpServletRequest request, HttpServletResponse response, int idUser) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (idUser == (int) session.getAttribute("idUser")) {

            }
        } else {
            session = request.getSession(); //tạo session mới
        }
    }

    private void signup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String fullName = req.getParameter("fullName");
        req.setAttribute("user", new User(fullName, phone, password));
        req.setAttribute("confirmPassword", confirmPassword);
        if (!userService.getUserByPhone(phone)) {
            userService.registerUser(phone, password, fullName);
            resp.sendRedirect("/authenticate");
        } else {
            req.setAttribute("errorMessage", "Số điện thoại đã tồn tại");
            req.getRequestDispatcher("/view/authenticate/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "signup":
                req.getRequestDispatcher("/view/authenticate/register.jsp").forward(req, resp);
                break;
            case "login":
            default:
                showLoginView(req, resp);
                break;
        }
    }

    private void showLoginView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/authenticate/login.jsp");
        dispatcher.forward(req, resp);
    }
}
