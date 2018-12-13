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
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet to save user entered step
 */
@WebServlet(
        urlPatterns = {"/saveStep"}
)
public class SaveCustomSteps extends HttpServlet {

    /**
     * Method to get step information that user would like to save for the personal record
     * Pass the step info to the jsp for populate the form
     * @param request HttpServletRequest request
     * @param response HttpServletResponse response
     * @throws ServletException throws ServletException
     * @throws IOException throws IOException
     **/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO genericDAO = new GenericDAO(CustomSteps.class);

        String stepName = request.getParameter("stepName").trim();
        String danceName = request.getParameter("danceName").trim();
        String leadDescription = request.getParameter("leadDescription").trim();
        String followerDescription = request.getParameter("followerDescription").trim();
        String level = request.getParameter("level").trim();
        String beatsNumber = request.getParameter("beats").trim();
        String numberOfSteps = request.getParameter("numberOfSteps").trim();


        List<String> stepInfo = new ArrayList<>();
        stepInfo.add(stepName);
        stepInfo.add(danceName);
        stepInfo.add(leadDescription);
        stepInfo.add(followerDescription);
        stepInfo.add(level);

        saveStep(request, stepInfo);

        request.setAttribute("customSteps", genericDAO.getAll());
        request.setAttribute("beats", beatsNumber);
        request.setAttribute("level", level);
        request.setAttribute("numberOfSteps", Integer.valueOf(numberOfSteps));
        request.setAttribute("saved", "saved");


        RequestDispatcher dispatcher = request.getRequestDispatcher("/buildDance.jsp");
        dispatcher.forward(request, response);

    }


    /**
     * Get step information from the user form to store it as a custom step for user record
     * Perform some input validation display success or failed message
     * @param request HttpServletRequest request
     * @param response HttpServletResponse response
     * @throws ServletException throws ServletException
     * @throws IOException throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stepName = request.getParameter("stepName").trim();
        String danceName = request.getParameter("danceName").trim();
        String lDescription = request.getParameter("lDescription");
        String fDescription = request.getParameter("fDescription");
        String level = request.getParameter("level").trim();

        if ( stepName.length() > 0 && danceName.length() > 0 && level.length() > 0 ) {

            List<String> stepInfo = new ArrayList<>();
            stepInfo.add(stepName);
            stepInfo.add(danceName);
            stepInfo.add(lDescription);
            stepInfo.add(fDescription);
            stepInfo.add(level);

            saveStep(request, stepInfo);
            request.setAttribute("saved", "saved");

        } else {
            request.setAttribute("form", "empty");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/buildDance.jsp");
        dispatcher.forward(request, response);

    }


    /**
     * Method to save step record ot the database
     * @param request HttpServletRequest request
     * @param stepInfo List of with step information (name, dance name, lead description, follower description)
     */
    private void saveStep(HttpServletRequest request, List<String> stepInfo) {

        GetUser getUser = new GetUser(request);
        User user = getUser.getUserData().get(0);
        GenericDAO genericDAO = new GenericDAO(User.class);

        CustomSteps customSteps = new CustomSteps(stepInfo.get(0), stepInfo.get(1), stepInfo.get(2), stepInfo.get(3), stepInfo.get(4), user);
        genericDAO.insert(customSteps);

    }

}
