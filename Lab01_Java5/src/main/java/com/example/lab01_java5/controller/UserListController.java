package com.example.lab01_java5.controller;

import com.example.lab01_java5.dao.IUserDAO;
import com.example.lab01_java5.dao.impl.UserDAO;
import com.example.lab01_java5.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/listUser"})
public class UserListController extends HttpServlet {
    IUserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users= userDAO.findAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/views/userlist.jsp").forward(request, response);
    }
}
