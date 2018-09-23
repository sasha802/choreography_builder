package dance.builder.controller;


import dance.builder.entity.Dance;
import dance.builder.persistence.DanceDAO;
import dance.builder.persistence.StepDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/searchStep"}
)
public class SearchStep extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StepDAO stepDAO = new StepDAO();
        DanceDAO danceDAO = new DanceDAO();


        String beatsNumber = request.getParameter("beatsNumber");
        Integer beatsPerMinute = Integer.valueOf(beatsNumber);
        String levelType = request.getParameter("level");
        String submit = request.getParameter("submit");

        if ( submit.equals("submit") ) {

            if ( beatsPerMinute <= 90 ) {


                request.setAttribute("dance", danceDAO.getDanceType("Waltz"));


            } else if ( beatsPerMinute > 91 && beatsPerMinute <= 119 ) {


                request.setAttribute("dance", danceDAO.getDanceType("Rumba"));
                request.setAttribute("steps", stepDAO.getStepsByLevel(levelType));


            } else if ( beatsPerMinute > 120 && beatsPerMinute <= 250 ) {


                request.setAttribute("dance", danceDAO.getDanceType("Swing"));
                request.setAttribute("steps", stepDAO.getStepsByLevel(levelType));

            } else {
                request.setAttribute("steps", stepDAO.getAllSteps());
            }

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/buildDance.jsp");
        dispatcher.forward(request, response);

    }
}
