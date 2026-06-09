package com.logIn.controller;

import java.io.IOException;

import com.logIn.dao.UserDAO;
import com.logIn.dao.impl.UserDAOImpl;
import com.logIn.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {


private UserDAO dao;

@Override
public void init() throws ServletException {
    dao = new UserDAOImpl();
}

@Override
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));

    String userName = request.getParameter("userName");
    String email = request.getParameter("email");
    String mobileNo = request.getParameter("mobileNo");
    String password = request.getParameter("password");

    if(!email.matches("^[A-Za-z0-9._%+-]+@gmail\\.com$")) {

        response.getWriter().println(
                "Only Gmail addresses are allowed");
        return;
    }

    if(!mobileNo.matches("\\d{10}")) {

        response.getWriter().println(
                "Mobile Number must contain exactly 10 digits");
        return;
    }

    User user = new User();

    user.setId(id);
    user.setUserName(userName);
    user.setEmail(email);
    user.setMobileNo(mobileNo);
    user.setPassword(password);

    boolean status = dao.updateUser(user);

    if(status) {

        HttpSession session = request.getSession();

        session.setAttribute("loggedInUser", user);

        response.sendRedirect("dashboard");

    } else {

        response.getWriter()
                .println("Profile Update Failed");
    }
}


}
