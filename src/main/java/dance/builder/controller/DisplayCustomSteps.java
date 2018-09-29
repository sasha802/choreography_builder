package dance.builder.controller;


import dance.builder.entity.CustomSteps;
import dance.builder.persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/customSteps"}
)
public class DisplayCustomSteps extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO genericDAO = new GenericDAO(CustomSteps.class);
        List<CustomSteps> customSteps = genericDAO.getByPropertyEqual("userId", "2");
        request.setAttribute("customSteps", customSteps);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/danceManager.jsp");
        dispatcher.forward(request, response);

    }

}
