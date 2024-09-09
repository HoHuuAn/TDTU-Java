package com.hohuuan.web;

import com.hohuuan.web.model.Account;
import com.hohuuan.web.dao.AccountDAO;
import com.hohuuan.web.db.HibernateUtils;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


//@WebServlet(value = "/login")
public class LoginController extends HttpServlet {
    Session session = HibernateUtils.getSession();
    AccountDAO dao = new AccountDAO(session);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String savedUsername = null;
        String savedPassword = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username") ) {
                    savedUsername = cookie.getValue();
                } else if (cookie.getName().equals("password") ) {
                    savedPassword = cookie.getValue();
                }
            }
        }
        Account acc = dao.get(savedUsername,savedPassword);
        if (acc != null) {
            resp.sendRedirect("");
            return;
        }

        HttpSession session = req.getSession();
        Account loginUser = (Account) session.getAttribute("user");
        if (loginUser != null) {
            resp.sendRedirect("");
            return;
        }
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/account/login.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        HttpSession session = req.getSession();

        System.out.println(remember);

        if ("on".equals(remember)) {
            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(30 * 24 * 60 * 60);
            resp.addCookie(usernameCookie);

            Cookie passwordCookie = new Cookie("password", password);
            passwordCookie.setMaxAge(30 * 24 * 60 * 60);
            resp.addCookie(passwordCookie);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/account/login.jsp");
        //send to jsp
        req.setAttribute("user",username);
        req.setAttribute("password",password);

        if(username == null || password == null){
            session.setAttribute("error", "Please input username and password");
            dispatcher.forward(req, resp);
        } else if (username.isEmpty()||password.isEmpty()) {
            session.setAttribute("error", "Username and password must not be empty");
            dispatcher.forward(req, resp);
        } else if (password.length() < 6) {
            session.setAttribute("error", "Password must be greater than 6 characters");
            dispatcher.forward(req, resp);
        } else{
            Account acc = dao.get(username,password);
            if (acc != null ) {
                session.setAttribute("user", acc);
                resp.sendRedirect("/");
            } else {
                session.setAttribute("error", "Invalid username or password");
                dispatcher.forward(req, resp);
            }
        }
    }
}
