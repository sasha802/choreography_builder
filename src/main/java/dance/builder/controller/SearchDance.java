package dance.builder.controller;

import com.sun.net.httpserver.HttpServer;
import dance.builder.persistence.DanceDAO;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DanceDAO danceDAO = new DanceDAO();
        request.setAttribute("dances", danceDAO.getAllDances());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

        /* String searchType = req.getParameter("searchType");

        String searchValue = req.getParameter("searchValue");

        UserData userData = new UserData();
        UserDAO userDAO = new UserDAO();
        req.setAttribute("users", userDAO.getAllUsrs());


        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);*/
    }
}

