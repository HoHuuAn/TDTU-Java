package usermanagement.user;

import java.io.IOException;
import java.util.List;

import usermanagement.dao.UserDAO;
import usermanagement.model.Manager;
import usermanagement.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class ListUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Manager loginManager = (Manager) session.getAttribute("manager");
        if( loginManager == null ){
            resp.sendRedirect("/login");
            return;
        }

        int page = 1;
        int recordsPerPage = 5;
        if (req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));

        UserDAO userDAO = new UserDAO();
        List<User> listUser = userDAO.selectAllUsers((page - 1) * recordsPerPage, recordsPerPage);

        int noOfRecords = userDAO.getNoOfRecords();
        int noOfPages = (int)Math.ceil(noOfRecords * 1.0 / recordsPerPage);

        req.setAttribute("listUser", listUser);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute("currentPage", page);

        RequestDispatcher dispatcher = req.getRequestDispatcher("user_list.jsp");
        dispatcher.forward(req, resp);
    }
}