package usermanagement.user;

import usermanagement.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete_user")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserDAO userDAO = new UserDAO();
        try {
            if( userDAO.deleteUser(id) ){
                // Set success message
                req.getSession().setAttribute("toastMessage", "User information deleted successfully!");
                req.getSession().setAttribute("toastType", "success");
            } else {
                // Set error message
                req.getSession().setAttribute("toastMessage", "Failed to delete user information. Please try again.");
                req.getSession().setAttribute("toastType", "error");
            }
            resp.sendRedirect("/");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
