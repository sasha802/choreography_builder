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

@WebServlet(
        urlPatterns = {"/searchStep"}
)
public class SearchStep extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO<Dance> danceGenericDAO = new GenericDAO<>(Dance.class);
        GenericDAO genericDAO = new GenericDAO(Step.class);

        RequestDispatcher dispatcher;

        String rumbaId = "1";
        String waltzId = "2";
        String swingId = "3";

        String beatsNumber = request.getParameter("beatsNumber").trim();
        String levelType = request.getParameter("level");
        String numberOfStepsUserInput = request.getParameter("numberOfSteps");
        Integer numberOfSteps = Integer.valueOf(numberOfStepsUserInput);


        if ( beatsNumber.length() != 0 ) {

            Integer beatsPerMinute = Integer.valueOf(beatsNumber);

            if ( beatsPerMinute <= 90 ) {

                request.setAttribute("dance", danceGenericDAO.getByPropertyLike("danceName","Waltz"));
                request.setAttribute("step", genericDAO.getByMultiplePropertiesTopClause(generateEntitiesMap(waltzId, levelType), numberOfSteps));
                request.setAttribute("beats", beatsNumber);
                request.setAttribute("stepsNumber", numberOfSteps);
                request.setAttribute("level", levelType);

            } else if ( beatsPerMinute > 91 && beatsPerMinute <= 119 ) {

                request.setAttribute("dance", danceGenericDAO.getByPropertyLike("danceName", "Rumba"));
                request.setAttribute("step", genericDAO.getByMultiplePropertiesTopClause(generateEntitiesMap(rumbaId, levelType), numberOfSteps));
                request.setAttribute("beats", beatsNumber);
                request.setAttribute("stepsNumber", numberOfSteps);
                request.setAttribute("level", levelType);

            } else if ( beatsPerMinute > 120 && beatsPerMinute <= 250 ) {

                request.setAttribute("dance", danceGenericDAO.getByPropertyLike("danceName", "Swing"));
                request.setAttribute("step", genericDAO.getByMultiplePropertiesTopClause(generateEntitiesMap(swingId, levelType), numberOfSteps));
                request.setAttribute("beats", beatsNumber);
                request.setAttribute("stepsNumber", numberOfSteps);
                request.setAttribute("level", levelType);

            }

            dispatcher = request.getRequestDispatcher("/buildDance.jsp");
            dispatcher.forward(request, response);

        } else {

            request.setAttribute("invalidForm", true);
            dispatcher = request.getRequestDispatcher("/buildDance.jsp");
            dispatcher.include(request, response);

        }



    }


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
