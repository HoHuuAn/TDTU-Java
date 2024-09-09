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
import java.util.List;

@WebServlet("/managerlist")
public class ListManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        if (req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));

        ManagerDAO managerDAO = new ManagerDAO();
        List<Manager> listManager = managerDAO.selectAllUsers((page - 1) * recordsPerPage, recordsPerPage);

        int noOfRecords = managerDAO.getNoOfRecords();
        int noOfPages = (int)Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        req.setAttribute("listManager", listManager);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute("currentPage", page);

        RequestDispatcher dispatcher = req.getRequestDispatcher("manager/manager_list.jsp");
        dispatcher.forward(req, resp);

    }
}
