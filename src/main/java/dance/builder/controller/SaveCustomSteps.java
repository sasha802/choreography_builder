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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(
        urlPatterns = {"/saveStep"}
)
public class SaveCustomSteps extends HttpServlet {
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


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stepName = request.getParameter("stepName");
        String danceName = request.getParameter("danceName");
        String lDescription = request.getParameter("lDescription");
        String fDescription = request.getParameter("fDescription");
        String level = request.getParameter("level");

        request.setAttribute("saved", "saved");

        List<String> stepInfo = new ArrayList<>();
        stepInfo.add(stepName);
        stepInfo.add(danceName);
        stepInfo.add(lDescription);
        stepInfo.add(fDescription);
        stepInfo.add(level);

        saveStep(request, stepInfo);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/buildDance.jsp");
        dispatcher.forward(request, response);

    }

    private void saveStep(HttpServletRequest request, List<String> stepInfo) {

        User user = getUser(request).get(0);
        GenericDAO genericDAO = new GenericDAO(User.class);

        CustomSteps customSteps = new CustomSteps(stepInfo.get(0), stepInfo.get(1), stepInfo.get(2), stepInfo.get(3), stepInfo.get(4), user);
        genericDAO.insert(customSteps);

    }


    private List<User> getUser(HttpServletRequest request) {

        String username = request.getUserPrincipal().getName();
        GenericDAO genericDAOUser = new GenericDAO(User.class);
        List<User> user = genericDAOUser.getByPropertyEqual("email", username);
        return user;

    }


}
