package com.example.lab01_java5.controller;

import com.example.lab01_java5.dao.IUserDAO;
import com.example.lab01_java5.dao.impl.UserDAO;
import com.example.lab01_java5.models.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(urlPatterns = {"/user"})
public class LoginController extends HttpServlet {
    IUserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            User user1 = userDAO.getUserByEmailPass(user);
            if (user1 == null) {
                request.setAttribute("message", "Email khong ton tai");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                if(!user.getPassword().equals(user1.getPassword())) {
                    request.setAttribute("email", user.getEmail());
                    request.setAttribute("messagePass", "Sai mat khau");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                }
                response.sendRedirect(request.getContextPath()+"/listUser");
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
