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

@WebServlet(
        urlPatterns = {"/saveStep"}
)
public class SaveCustomSteps extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO genericDAO = new GenericDAO(CustomSteps.class);

        String stepName = request.getParameter("stepName").trim();
        String leadDescription = request.getParameter("leadDescription").trim();
        String followerDescription = request.getParameter("followerDescription").trim();
        String level = request.getParameter("level").trim();
        String userIdInput = request.getParameter("userId").trim();
        Integer userId = Integer.valueOf(userIdInput);

        CustomSteps customSteps = new CustomSteps(stepName, "Rumba", leadDescription, followerDescription, level, userId);
        genericDAO.insert(customSteps);

        request.setAttribute("customSteps", genericDAO.getAll());


        RequestDispatcher dispatcher = request.getRequestDispatcher("/danceManager.jsp");
        dispatcher.forward(request, response);
    }


}
