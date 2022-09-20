package com.example.lab01_java5.controller;

import com.example.lab01_java5.dao.IUserDAO;
import com.example.lab01_java5.dao.impl.UserDAO;
import com.example.lab01_java5.models.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	IUserDAO userDAO = new UserDAO();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/register.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());
			userDAO.save(user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect(req.getContextPath()+"/user");
	}

}
