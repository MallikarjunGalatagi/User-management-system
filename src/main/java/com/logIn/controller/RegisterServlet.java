package com.logIn.controller;

import java.io.IOException;

import com.logIn.dao.UserDAO;
import com.logIn.dao.impl.UserDAOImpl;
import com.logIn.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


private UserDAO dao;

@Override
public void init() throws ServletException {
    dao = new UserDAOImpl();
}

@Override
protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {

    request.getRequestDispatcher("/WEB-INF/views/register.jsp")
           .forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String email = request.getParameter("email");
    String mobileNo = request.getParameter("mobileNo");
    String password = request.getParameter("password");

    if(!email.matches("^[A-Za-z0-9._%+-]+@gmail\\.com$")) {

        request.setAttribute("errorMessage",
                "Only Gmail addresses are allowed");

        request.getRequestDispatcher("/WEB-INF/views/register.jsp")
               .forward(request, response);

        return;
    }

    if(!mobileNo.matches("\\d{10}")) {

        request.setAttribute("errorMessage",
                "Mobile Number must contain exactly 10 digits");

        request.getRequestDispatcher("/WEB-INF/views/register.jsp")
               .forward(request, response);

        return;
    }

    User user = new User();

    user.setUserName(userName);
    user.setEmail(email);
    user.setMobileNo(mobileNo);
    user.setPassword(password);

    boolean status = dao.addUser(user);

    if(status) {

        request.setAttribute("successMessage",
                "Account Created Successfully");

        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
               .forward(request, response);

    } else {

        request.setAttribute("errorMessage",
                "Registration Failed");

        request.getRequestDispatcher("/WEB-INF/views/register.jsp")
               .forward(request, response);
    }
}


}
