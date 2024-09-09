package usermanagement.manager;

import usermanagement.dao.ManagerDAO;
import usermanagement.model.Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class Register extends HttpServlet {
    ManagerDAO managerDAO = new ManagerDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Manager loginManager = (Manager) session.getAttribute("manager");

        if(loginManager != null){
            resp.sendRedirect("/");
            return;
        }

        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("manager/manager_register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");

        HttpSession session = req.getSession();
        RequestDispatcher dispatcher = req.getRequestDispatcher("manager/manager_register.jsp");

        req.getParameterMap().forEach((key, values) -> {
            req.setAttribute(key, values[0]);
        });

        if (id == null ||fullname == null || email == null || password == null || passwordConfirm == null){
            session.setAttribute("error", "Please provide enough information");
            dispatcher.forward(req, resp);
        } else if (id.isEmpty() || fullname.isEmpty() || email.isEmpty()|| password.isEmpty() || passwordConfirm.isEmpty()){
            session.setAttribute("error", "Please fill out all the form fields");
            dispatcher.forward(req, resp);
        } else if (fullname.equals("admin")) {
            session.setAttribute("error", "Please choose another full name");
            dispatcher.forward(req, resp);
        } else {
            try {
                if (managerDAO.getAllId().contains(id)) {
                    session.setAttribute("error", "ID was existed");
                    dispatcher.forward(req, resp);
                } else if (password.length() < 6 ){
                    session.setAttribute("error", "Password must be or more than 6 letters");
                    dispatcher.forward(req, resp);
                } else if (!password.equals(passwordConfirm)) {
                    session.setAttribute("error", "Password does not match");
                    dispatcher.forward(req, resp);
                } else {
                    Manager account = new Manager(id, fullname, email, password);
                    try {
                        if (managerDAO.add(account)){
                            req.getSession().setAttribute("toastMessage", "Register successfully!");
                            req.getSession().setAttribute("toastType", "success");
                            resp.sendRedirect("/login");
                        } else {
                            session.setAttribute("error", "Creat account Failed");
                            dispatcher.forward(req, resp);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
