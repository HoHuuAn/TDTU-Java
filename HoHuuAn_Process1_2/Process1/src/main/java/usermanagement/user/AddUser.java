package usermanagement.user;

import usermanagement.dao.UserDAO;
import usermanagement.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/add")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user_add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int activatedValue = (Objects.equals(req.getParameter("activated"), "true"))?1:0;
        HttpSession session = req.getSession();

        RequestDispatcher dispatcher = req.getRequestDispatcher("user_add.jsp");

        //send to jsp
        req.setAttribute("user", new User(id, name, email, phone, activatedValue));
        UserDAO userDAO = new UserDAO();
        if(userDAO.selectAllId().contains(id)){
            session.setAttribute("error", "ID was exist");
            dispatcher.forward(req, resp);
        } else if (id == null || id.isEmpty()){
            session.setAttribute("error", "Please provided id");
            dispatcher.forward(req, resp);
        } else if (name == null || name.isEmpty()) {
            session.setAttribute("error", "Please input name");
            dispatcher.forward(req, resp);
        } else if (email == null || email.isEmpty()) {
            session.setAttribute("error", "Please input email");
            dispatcher.forward(req, resp);
        } else if (phone == null || phone.isEmpty()) {
            session.setAttribute("error", "Please input phone");
            dispatcher.forward(req, resp);
        } else {
            try {
                if( userDAO.insertUser(new User(id, name, email, phone, activatedValue)) == 1 ){
                    // Set success message
                    req.getSession().setAttribute("toastMessage", "User information added successfully!");
                    req.getSession().setAttribute("toastType", "success");
                } else {
                    // Set error message
                    req.getSession().setAttribute("toastMessage", "Failed to add user information. Please try again.");
                    req.getSession().setAttribute("toastType", "error");
                }
                resp.sendRedirect("/");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
