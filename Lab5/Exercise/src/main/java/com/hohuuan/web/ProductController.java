package com.hohuuan.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hohuuan.web.dao.ProductDAO;
import com.hohuuan.web.db.HibernateUtils;
import com.hohuuan.web.model.Product;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
public class ProductController extends HttpServlet {
    Session session = HibernateUtils.getSession();
    ProductDAO dao = new ProductDAO(session);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String price = req.getParameter("price");

        HttpSession httpSession = req.getSession();

        //send to jsp
        req.setAttribute("name",name);
        req.setAttribute("price",price);
        if(name == null || price == null){
//            httpSession.setAttribute("error", "Please input Name and Price");
//            resp.sendRedirect("/");

            JsonObject responseJson = new JsonObject();
            responseJson.addProperty("code", 1);
            responseJson.addProperty("message", "Please input Name and Price");

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(new Gson().toJson(responseJson));

        } else if (name.isEmpty()||price.isEmpty()) {
//            httpSession.setAttribute("error", "Name and Price must not be empty");
//            resp.sendRedirect("/");

            JsonObject responseJson = new JsonObject();
            responseJson.addProperty("code", 1);
            responseJson.addProperty("message", "Name and Price must not be empty");
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
        } else {
            Product product = new Product(name, Integer.parseInt(price));
            if(dao.add(product)){
                JsonObject responseJson = new JsonObject();
                responseJson.addProperty("code", 0);
                responseJson.addProperty("message", "Added successfully");

                responseJson.addProperty("id", product.getId());
                responseJson.addProperty("name", product.getName());
                responseJson.addProperty("price", product.getPrice());


                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(new Gson().toJson(responseJson));
//                resp.sendRedirect("/");
            } else {
                JsonObject responseJson = new JsonObject();
                responseJson.addProperty("code", 1);
                responseJson.addProperty("message", "Added unsuccessfully");

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(new Gson().toJson(responseJson));
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        boolean check = dao.delete(Long.parseLong(id));
        System.out.println(check);
        try {
            if(check){
                JsonObject jsonResponse = new JsonObject();
                jsonResponse.addProperty("code", 0);
                jsonResponse.addProperty("status", "success");
                jsonResponse.addProperty("message", "Product deleted successfully");

                System.out.println(new Gson().toJson(jsonResponse));
                resp.setContentType("application/json");
                resp.getWriter().write(new Gson().toJson(jsonResponse));
            }
        } catch (Exception e) {
            JsonObject errorResponse = new JsonObject();
            errorResponse.addProperty("status", "error");
            errorResponse.addProperty("message", "Failed to delete the product: " + e.getMessage());
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            String jsonString = new Gson().toJson(errorResponse);
            resp.setContentType("application/json");
            resp.getWriter().write(jsonString);
        }
    }
}
