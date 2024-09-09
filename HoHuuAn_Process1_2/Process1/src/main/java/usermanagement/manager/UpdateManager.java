package usermanagement.manager;

import usermanagement.dao.ManagerDAO;
import usermanagement.model.Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update_manager")
public class UpdateManager extends HttpServlet {
    String id = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getParameter("id");
        ManagerDAO managerDAO = new ManagerDAO();
        Manager manager = managerDAO.selectManager(id);
        // to jsp
        req.setAttribute("manager", manager);

        RequestDispatcher dispatcher = req.getRequestDispatcher("manager/manager_edit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        ManagerDAO managerDAO = new ManagerDAO();

        try {
            if (managerDAO.updateManager(new Manager(id, fullName, email, password))) {
                // Set success message
                req.getSession().setAttribute("toastMessage", "Manager information updated successfully!");
                req.getSession().setAttribute("toastType", "success");
            } else {
                // Set error message
                req.getSession().setAttribute("toastMessage", "Failed to update manager information. Please try again.");
                req.getSession().setAttribute("toastType", "error");
            }
            resp.sendRedirect("/managerlist");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
