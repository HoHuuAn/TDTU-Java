package com.hohuuan.web;

import com.hohuuan.web.model.Account;
import com.hohuuan.web.dao.AccountDAO;
import com.hohuuan.web.db.HibernateUtils;
import com.hohuuan.web.model.Product;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class RegisterController extends HttpServlet {
    Session session = HibernateUtils.getSession();
    AccountDAO dao = new AccountDAO(session);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Account loginUser = (Account) session.getAttribute("user");

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


        if(loginUser != null){
            resp.sendRedirect("");
            return;
        }

        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/account/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");

        HttpSession session = req.getSession();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/account/register.jsp");

        req.getParameterMap().forEach((key, values) -> {
            req.setAttribute(key, values[0]);
        });

        if (fullname == null || email == null || password == null || passwordConfirm == null){
            session.setAttribute("error", "Please provide enough information");
            dispatcher.forward(req, resp);
        } else if (fullname.isEmpty() || email.isEmpty()|| password.isEmpty() || passwordConfirm.isEmpty()){
            session.setAttribute("error", "Please fill out all the form fields");
            dispatcher.forward(req, resp);
        } else if (password.length() < 6 ){
            session.setAttribute("error", "Password must be or more than 6 letters");
            dispatcher.forward(req, resp);
        } else if (!password.equals(passwordConfirm)) {
            session.setAttribute("error", "Password does not match");
            dispatcher.forward(req, resp);
        } else {
            resp.getWriter().println(fullname + "," + email + "," + password);

            Account account = new Account(0, fullname, email, password);
            if (dao.add(account)){
                resp.sendRedirect("/login");
            } else {
                session.setAttribute("error", "Creat account Failed");
                dispatcher.forward(req, resp);
            }
        }

    }
}
