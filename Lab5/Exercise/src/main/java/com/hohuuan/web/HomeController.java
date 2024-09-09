package com.hohuuan.web;

import com.hohuuan.web.dao.ProductDAO;
import com.hohuuan.web.model.Account;
import com.hohuuan.web.dao.AccountDAO;
import com.hohuuan.web.db.HibernateUtils;
import com.hohuuan.web.model.Product;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class HomeController extends HttpServlet {
    Session session = HibernateUtils.getSession();
    AccountDAO accountDAO = new AccountDAO(session);

    ProductDAO productDAO = new ProductDAO(session);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/home/index.jsp");

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
        Account acc = accountDAO.get(savedUsername,savedPassword);
        if (acc != null) {
            List<Product> productList = productDAO.getAll();
            HttpSession session = req.getSession();
            session.setAttribute("user", acc);
            req.setAttribute("products", productList);
            dispatcher.forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();

        Account user = (Account) session.getAttribute("user");

        if( user == null ){
            resp.sendRedirect("/login");
            return;
        }

        List<Product> productList = productDAO.getAll();
        req.setAttribute("products", productList);
        System.out.println("list: "+ productList);
        resp.setContentType("text/html");
        dispatcher.forward(req, resp);
    }
}
