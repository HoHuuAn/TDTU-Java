package com.hohuuan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private HashMap<String, String> accounts;
    public void init() throws ServletException{
        super.init();
        accounts = new HashMap<>();
        accounts.put("admin", "123456");
        accounts.put("hohuuan", "123qwe");
        accounts.put("cupinsiuway", "qweasd");
        accounts.put("user1", "password1");
        accounts.put("user2", "password2");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        if( username == null ){
            out.println("<h1>Please input username</h1>");
        } else if (username.isEmpty()) {
            out.println("<h1>Username must not be empty</h1>");
        } else if( password == null ){
            out.println("<h1>Please input password</h1>" );
        } else if (password.isEmpty()) {
            out.println("<h1>Password must not be empty</h1>");
        } else if (! accounts.containsKey(username)) {
            out.println("<h1>Wrong username</h1>");
        } else if (!accounts.get(username).equals(password)) {
            out.println("<h1>Wrong password");
        } else if (accounts.containsKey(username) && accounts.get(username).equals(password)){
            out.println("<h1>Name/Password match</h1>");
        }
    }

}
