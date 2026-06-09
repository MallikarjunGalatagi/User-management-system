package com.logIn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session = request.getSession(false);

    if(session == null ||
       session.getAttribute("loggedInUser") == null) {

        response.sendRedirect("login");
        return;
    }

    request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp")
           .forward(request, response);
}


}
