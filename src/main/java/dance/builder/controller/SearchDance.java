package dance.builder.controller;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/searchDance"}
)

public class SearchDance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       /* String searchType = req.getParameter("searchType");

        String searchValue = req.getParameter("searchValue");

        UserData userData = new UserData();
        UserDAO userDAO = new UserDAO();
        req.setAttribute("users", userDAO.getAllUsrs());


        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);*/
    }
}

