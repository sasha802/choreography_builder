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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Servlet to get steps from the database that user saved previously
 * @author oponomarova
 */
@WebServlet(
        urlPatterns = {"/displayCustomSteps"}
)
public class DisplayCustomSteps extends HttpServlet {


    /**
     * Method to get users steps that had been saved previously
     * To pass data to the jsp page for the display
     * @param request Servlet request
     * @param response Servlet response
     * @throws ServletException Throws Servlet Exception error
     * @throws IOException Throws IO Exception error
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getUserPrincipal().getName();
        GenericDAO genericDAOCustomSteps = new GenericDAO(CustomSteps.class);
        GenericDAO genericDAOUser = new GenericDAO(User.class);
        List<User> user = genericDAOUser.getByPropertyEqual("email", username);
        int userId = user.get(0).getId();


        Map<String, Map<String, String>> entity = new HashMap<>();
        Map<String, String> userProperty = new HashMap<>();
        Map<String, String> customStepProperty = new HashMap<>();

        userProperty.put("id", Integer.toString(userId));
        customStepProperty.put("deleted", "0");
        entity.put("user", userProperty);
        entity.put("", customStepProperty);

        request.setAttribute("customSteps", genericDAOCustomSteps.getByMultiplePropertiesTopClause(entity, 0));


        RequestDispatcher dispatcher = request.getRequestDispatcher("/danceManager.jsp");
        dispatcher.forward(request, response);

    }

}
