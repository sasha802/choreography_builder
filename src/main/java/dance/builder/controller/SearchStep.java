package dance.builder.controller;

import dance.builder.entity.Dance;
import dance.builder.entity.Step;
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

/**
 * Servlet to perform search of the user requested steps based on the beat per minute
 */
@WebServlet(
        urlPatterns = {"/searchStep"}
)
public class SearchStep extends HttpServlet {

    /**
     * Method to get info from the form
     * perform validation
     * Pass search results to the jsp or, error msg
     * @param request HttpServletRequest request
     * @param response HttpServletResponse response
     * @throws ServletException throws ServletException
     * @throws IOException throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GetUser getUser = new GetUser(request);

        int userId = getUser.getUserData().get(0).getId();

        GenericDAO<Dance> danceGenericDAO = new GenericDAO<>(Dance.class);
        GenericDAO genericDAO = new GenericDAO(Step.class);

        RequestDispatcher dispatcher;

        String rumbaId = "1";
        String waltzId = "2";
        String swingId = "3";

        String userName = request.getParameter("userName");
        String beatsNumber = request.getParameter("beatsNumber").trim();
        String levelType = request.getParameter("level");
        String numberOfStepsUserInput = request.getParameter("numberOfSteps");
        int numberOfSteps = Integer.parseInt(numberOfStepsUserInput);


        if ( beatsNumber.length() != 0 ) {

            Integer beatsPerMinute = Integer.valueOf(beatsNumber);

            if ( beatsPerMinute <= 90 ) {

                request.setAttribute("dance", danceGenericDAO.getByPropertyLike("danceName","Waltz"));
                request.setAttribute("step", genericDAO.getByMultiplePropertiesTopClause(generateEntitiesMap(waltzId, levelType), numberOfSteps));

            } else if ( beatsPerMinute >= 91 && beatsPerMinute <= 119 ) {

                request.setAttribute("dance", danceGenericDAO.getByPropertyLike("danceName", "Rumba"));
                request.setAttribute("step", genericDAO.getByMultiplePropertiesTopClause(generateEntitiesMap(rumbaId, levelType), numberOfSteps));


            } else if ( beatsPerMinute >= 120 && beatsPerMinute <= 250 ) {

                request.setAttribute("dance", danceGenericDAO.getByPropertyLike("danceName", "Swing"));
                request.setAttribute("step", genericDAO.getByMultiplePropertiesTopClause(generateEntitiesMap(swingId, levelType), numberOfSteps));

            }

            request.setAttribute("beats", beatsNumber);
            request.setAttribute("numberOfSteps", numberOfSteps);
            request.setAttribute("level", levelType);
            request.setAttribute("userId", Integer.toString(userId));
            request.setAttribute("userFirstName", userName);

            dispatcher = request.getRequestDispatcher("/buildDance.jsp");
            dispatcher.forward(request, response);

        } else {

            request.setAttribute("formValidation", false);
            request.setAttribute("user", getUser.getUserData().get(0).getFirstName());
            request.setAttribute("userFirstName", userName);
            dispatcher = request.getRequestDispatcher("/buildDance.jsp");
            dispatcher.include(request, response);

        }

    }


    /**
     * Method to get user name form the database and pass it to the jsp for the welcome msg
     * @param request HttpServletRequest request
     * @param response HttpServletResponse response
     * @throws ServletException throws ServletException
     * @throws IOException throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        GetUser getUser = new GetUser(request);

        request.setAttribute("userFirstName", getUser.getUserData().get(0).getFirstName());
        dispatcher = request.getRequestDispatcher("/buildDance.jsp");
        dispatcher.include(request, response);

    }


    /**
     * Method to get map with entities
     * @param danceId String dance id
     * @param levelType String dance level type
     * @return Map with the step entities
     */
    private Map<String, Map<String, String>> generateEntitiesMap(String danceId, String levelType) {

        Map<String, Map<String, String>> entities = new HashMap<>();
        Map<String, String> propertiesOne = new HashMap<>();
        Map<String, String> propertiesTwo = new HashMap<>();

        propertiesOne.put("id", danceId);
        propertiesTwo.put("level", levelType);
        entities.put("dance", propertiesOne);
        entities.put("", propertiesTwo);

        return entities;

    }
}
