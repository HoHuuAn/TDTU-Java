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

@WebServlet("/login")
public class Login extends HttpServlet {
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("manager/manager_login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        RequestDispatcher dispatcher = req.getRequestDispatcher("manager/manager_login.jsp");
        //send to jsp
        req.setAttribute("username",username);
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
        } else if (username.equals("admin") && password.equals("123qwe")) {
            session.setAttribute("manager", new Manager("admin", "123qwe"));
            req.getSession().setAttribute("toastMessage", "Admin Login successfully!");
            req.getSession().setAttribute("toastType", "success");
            resp.sendRedirect("/");
        } else {
            try {
                Manager manager = managerDAO.get(username,password);
                if (manager != null) {
                    session.setAttribute("manager", manager);
                    req.getSession().setAttribute("toastMessage", "Manager Login successfully!");
                    req.getSession().setAttribute("toastType", "success");
                    resp.sendRedirect("/");
                } else {
                    session.setAttribute("error", "Invalid username or password");
                    dispatcher.forward(req, resp);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
