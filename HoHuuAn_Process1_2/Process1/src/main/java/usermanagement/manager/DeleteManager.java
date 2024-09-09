package usermanagement.manager;

import usermanagement.dao.ManagerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete_manager")
public class DeleteManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ManagerDAO managerDAO = new ManagerDAO();
        try {
            if( managerDAO.deleteManager(id) ){
                // Set success message
                req.getSession().setAttribute("toastMessage", "Manager information deleted successfully!");
                req.getSession().setAttribute("toastType", "success");
            } else {
                // Set error message
                req.getSession().setAttribute("toastMessage", "Failed to delete Manager information. Please try again.");
                req.getSession().setAttribute("toastType", "error");
            }
            resp.sendRedirect("/managerlist");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
