package com.hohuuan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Register</h1>");
        resp.getWriter().println("<p>Please submit the form below to register.</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthday = req.getParameter("birthday");
        String birthtime = req.getParameter("birthtime");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String toeicScore = req.getParameter("toeic");
        String message = req.getParameter("message");

        List<String> favoriteIdeList;

        if (name == null || name.isEmpty()) {
            resp.getWriter().println("Please enter your name.");
            return;
        }

        if (email == null || email.isEmpty()) {
            resp.getWriter().println("Please enter your email address.");
            return;
        }

        if (birthday == null || birthday.isEmpty()) {
            resp.getWriter().println("Please enter your birthday.");
            return;
        }

        if (birthtime == null || birthtime.isEmpty()) {
            resp.getWriter().println("Please enter your birthtime.");
            return;
        }

        if (gender == null || gender.isEmpty()) {
            resp.getWriter().println("Please enter your gender.");
            return;
        }

        if (country == null || country.equals("Select a country")) {
            resp.getWriter().println("Please enter your country.");
            return;
        }

        if ( req.getParameterValues("favorite_ide[]") != null ){
            favoriteIdeList = new ArrayList<>(Arrays.asList(req.getParameterValues("favorite_ide[]")));
        } else {
            resp.getWriter().println("Please choose your Favorite IDE.");
            return;
        }

        if (message == null || message.isEmpty()) {
            resp.getWriter().println("Please enter your Introduce yourself.");
            return;
        }

        req.setAttribute("name", name);
        req.setAttribute("email", email);
        req.setAttribute("birthday", birthday);
        req.setAttribute("birthtime", birthtime);
        req.setAttribute("gender", gender);
        req.setAttribute("country", country);
        req.setAttribute("toeicScore", toeicScore);
        req.setAttribute("favoriteIDE", favoriteIdeList);
        req.setAttribute("message", message);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/output.jsp");
        dispatcher.forward(req, resp);
    }
}
