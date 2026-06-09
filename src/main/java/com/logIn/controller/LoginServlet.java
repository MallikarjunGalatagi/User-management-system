package com.logIn.controller;

import java.io.IOException;

import com.logIn.dao.UserDAO;
import com.logIn.dao.impl.UserDAOImpl;
import com.logIn.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


private UserDAO dao;

@Override
public void init() throws ServletException {
    dao = new UserDAOImpl();
}

@Override
protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {

    request.getRequestDispatcher("/WEB-INF/views/login.jsp")
           .forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String loginId = request.getParameter("loginId");
    String password = request.getParameter("password");

    User user = dao.login(loginId, password);

    if(user != null) {

        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", user);

        response.sendRedirect("dashboard");

    } else {

        request.setAttribute("errorMessage",
                "Invalid Username/Email or Password");

        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
               .forward(request, response);
    }
}


}
