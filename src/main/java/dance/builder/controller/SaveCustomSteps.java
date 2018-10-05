package dance.builder.controller;


import dance.builder.entity.CustomSteps;
import dance.builder.entity.User;
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
        GenericDAO genericDAOUser = new GenericDAO(User.class);


        String stepName = request.getParameter("stepName").trim();
        String danceName = request.getParameter("danceName").trim();
        String leadDescription = request.getParameter("leadDescription").trim();
        String followerDescription = request.getParameter("followerDescription").trim();
        String level = request.getParameter("level").trim();
        String beatsNumber = request.getParameter("beats");
        String userIdInput = request.getParameter("userId").trim();
        Integer userId = Integer.valueOf(userIdInput);

        User user = (User)genericDAOUser.getById(userId);

        CustomSteps customSteps = new CustomSteps(stepName, danceName, leadDescription, followerDescription, level, user);
        genericDAO.insert(customSteps);

        request.setAttribute("customSteps", genericDAO.getAll());
        request.setAttribute("beats", beatsNumber);
        request.setAttribute("level", level);
       // request.setAttribute("numberOfSteps", );



        RequestDispatcher dispatcher = request.getRequestDispatcher("/buildDance.jsp");
        dispatcher.forward(request, response);
    }


}
