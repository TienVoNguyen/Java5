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

@WebServlet(urlPatterns = {"/update"})
public class UpdateController extends HttpServlet {
    IUserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        Long id = Long.parseLong(strId);
        User user = userDAO.findById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/views/editprofile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = new User();
            BeanUtils.populate(user, request.getParameterMap());
            user = userDAO.update(user);
            request.setAttribute("user", user);
            request.setAttribute("message", "Update thanh cong");
            request.getRequestDispatcher("/views/editprofile.jsp").forward(request, response);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
