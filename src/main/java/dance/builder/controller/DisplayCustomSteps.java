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
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        urlPatterns = {"/displayCustomSteps"}
)
public class DisplayCustomSteps extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        GenericDAO genericDAOCustomSteps = new GenericDAO(CustomSteps.class);

        String username = request.getUserPrincipal().getName();

        String userId = "2";

        Map<String, Map<String, String>> entity = new HashMap<>();
        Map<String, String> userProperty = new HashMap<>();
        Map<String, String> customStepProperty = new HashMap<>();

        userProperty.put("id", userId);
        customStepProperty.put("deleted", "0");
        entity.put("user", userProperty);
        entity.put("", customStepProperty);

        request.setAttribute("customSteps", genericDAOCustomSteps.getByMultiplePropertiesTopClause(entity, 0));


        RequestDispatcher dispatcher = request.getRequestDispatcher("/danceManager.jsp");
        dispatcher.forward(request, response);

    }

}
