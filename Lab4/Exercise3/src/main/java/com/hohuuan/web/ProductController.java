package com.hohuuan.web;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {

    private List<Product> products;
    private Gson gson;
    public ProductController() {
        gson = new Gson();
        products = new ArrayList<>();
        products.add(new Product(1, "Samsung J7", 500));
        products.add(new Product(2, "Samsung 8 Prime", 400));
        products.add(new Product(3, "Samsung 9", 700));
        products.add(new Product(4, "Samsung Galaxy note s10", 1500));
        products.add(new Product(5, "Samsung Galaxy s20 ultra", 2000));
        products.add(new Product(6, "Samsung Galaxy note 22", 2100));
        products.add(new Product(7, "Samsung Galaxy s22 ultra", 2300));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idValue = req.getParameter("id");

        if (idValue == null || idValue.isEmpty()){
            sendResponse(resp,new Package(0, "Read products successfully", products));
        } else if (!idValue.matches("\\d+")) {
            sendResponse(resp,new Package(0, "Invalid id = " + idValue));
        } else if (getProductById(Integer.parseInt(idValue)) != null ) {
            int id = Integer.parseInt(idValue);
            sendResponse(resp, new Package(0, "Product with id = " + idValue, getProductById(id)));
        } else{
            sendResponse(resp,new Package(1, "Not find product with id = " + idValue));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");

        if (id == null || id.isEmpty()){
            sendResponse(resp, Package.error(2, "Invalid or missing id"));
        } else if (name == null || name.isEmpty()) {
            sendResponse(resp, Package.error(2, "Invalid or missing name"));
        } else if (price == null || price.isEmpty()) {
            sendResponse(resp, Package.error(2, "Invalid or missing price"));
        } else if (getProductById(Integer.parseInt(id)) != null ) {
            sendResponse(resp, Package.error(2, "Id " + id + " existed"));
        } else {
            int idValue = Integer.parseInt(id);
            int priceValue = Integer.parseInt(price);
            Product product = new Product(idValue, name, priceValue);
            products.add(product);
            sendResponse(resp, Package.success("Add product successfully", product));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        if (id == null || id.isEmpty()){
            sendResponse(resp, Package.error(2, "Invalid or missing id"));
        } else if (getProductById(Integer.parseInt(id)) == null) {
            sendResponse(resp, Package.error(2, "Id " + id + " is not existed"));
        } else if (name == null || name.isEmpty()) {
            sendResponse(resp, Package.error(2, "Invalid or missing name"));
        } else if (price == null || price.isEmpty()) {
            sendResponse(resp, Package.error(2, "Invalid or missing price"));
        } else {
            Product product = getProductById(Integer.parseInt(id));
            product.setName(name);
            product.setPrice(Integer.parseInt(price));

            sendResponse(resp, Package.success("Update product successfully", product));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id == null || id.isEmpty()){
            sendResponse(resp, Package.error(2, "Invalid or missing id"));
        } else if (getProductById(Integer.parseInt(id)) == null) {
            sendResponse(resp, Package.error(2, "Id " + id + " is not existed"));
        } else {
            Product product = getProductById(Integer.parseInt(id));
            products.remove(product);
            sendResponse(resp, Package.success("Delete product successfully", product));
        }

    }

    private void sendResponse(HttpServletResponse resp, Package data)throws ServletException, IOException{
        resp.setContentType("application/json");
        resp.getWriter().println(gson.toJson(data));
    }

    private Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
