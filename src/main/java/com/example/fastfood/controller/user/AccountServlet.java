package com.example.fastfood.controller.user;

import com.example.fastfood.model.User;
import com.example.fastfood.service.UserService;
import com.example.fastfood.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/account")
public class AccountServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch (action) {
            case "edit":
                editInformUser (req, resp);
                break;
            default:
                break;
        }
    }

    private void editInformUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        int id = user.getId();
        String phone = req.getParameter("phone");
        String fullName = req.getParameter("fullName");
        req.getSession().setAttribute("user", new User(id, phone, fullName));
        resp.sendRedirect("/account");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch (action) {
            case "edit":
                showEditView (req, resp);
                break;
            default:
                showAccount (req, resp);
                break;
        }
    }

    private void showAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/user/account.jsp").forward(req, resp);
    }

    private void showEditView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/user/accountEdit.jsp").forward(req, resp);
    }
}
