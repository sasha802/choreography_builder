package dance.builder.controller;


import dance.builder.entity.Dance;
import dance.builder.persistence.GenericDAO;
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
        GenericDAO<Dance> genericDAO = new GenericDAO<>(Dance.class);


        String beatsNumber = request.getParameter("beatsNumber");
        Integer beatsPerMinute = Integer.valueOf(beatsNumber);
        String levelType = request.getParameter("level");
        String numberOfStepsUserInput = request.getParameter("numberOfSteps");
        Integer numberOfSteps = Integer.valueOf(numberOfStepsUserInput);
        String submit = request.getParameter("submit");

        if ( submit.equals("submit") ) {

            if ( beatsPerMinute <= 90 ) {

                request.setAttribute("dance", genericDAO.getByPropertyLike("danceName","Waltz"));
                request.setAttribute("step", stepDAO.getStepByDance(levelType, 2 , numberOfSteps));


            } else if ( beatsPerMinute > 91 && beatsPerMinute <= 119 ) {


                request.setAttribute("dance", genericDAO.getByPropertyLike("danceName", "Rumba"));
                request.setAttribute("step", stepDAO.getStepByDance(levelType, 1, numberOfSteps));


            } else if ( beatsPerMinute > 120 && beatsPerMinute <= 250 ) {


                request.setAttribute("dance", genericDAO.getByPropertyLike("danceName", "Swing"));
                request.setAttribute("step", stepDAO.getStepByDance(levelType, 3, numberOfSteps));

            } else {

                request.setAttribute("steps", genericDAO.getAll());
            }

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/buildDance.jsp");
        dispatcher.forward(request, response);

    }
}
