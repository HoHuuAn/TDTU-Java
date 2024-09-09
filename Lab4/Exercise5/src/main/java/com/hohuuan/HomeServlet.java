package com.hohuuan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");

        if (page != null && (page.equals("about") || page.equals("contact") || page.equals("help"))) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/" + page + ".jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.getWriter().println("<!DOCTYPE html><html lang=\"en\"><body><h1>Welcome to our website</h1></body></html>");
        }
    }
}
