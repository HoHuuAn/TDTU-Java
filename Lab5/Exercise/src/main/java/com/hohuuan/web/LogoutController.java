package com.hohuuan.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Cookie usernameCookie = new Cookie("username", "");
        usernameCookie.setMaxAge(0);
        resp.addCookie(usernameCookie);

        Cookie passwordCookie = new Cookie("password", "");
        passwordCookie.setMaxAge(0);
        resp.addCookie(passwordCookie);

        session.invalidate();

        resp.sendRedirect("/login");
    }
}
