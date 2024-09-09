package usermanagement.user;

import usermanagement.dao.UserDAO;
import usermanagement.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/update_user")
public class UpdateUser extends HttpServlet {
    String id = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getParameter("id");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.selectUser(id);
        // to jsp
        req.setAttribute("user", user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("user_edit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int activatedValue = (Objects.equals(req.getParameter("activated"), "true"))?1:0;

        UserDAO userDAO = new UserDAO();

        try {
            if (userDAO.updateUser(new User(id, name, email, phone, activatedValue))) {
                // Set success message
                req.getSession().setAttribute("toastMessage", "User information updated successfully!");
                req.getSession().setAttribute("toastType", "success");
            } else {
                // Set error message
                req.getSession().setAttribute("toastMessage", "Failed to update user information. Please try again.");
                req.getSession().setAttribute("toastType", "error");
            }
            resp.sendRedirect("/");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}