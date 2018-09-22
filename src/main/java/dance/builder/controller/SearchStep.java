package dance.builder.controller;


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

        String levelType = request.getParameter("level");
        String submit = request.getParameter("submit");

        if ( submit.equals("submit") ) {

            if ( levelType.length() > 0 ) {

                request.setAttribute("steps", stepDAO.getStepsByLevel(levelType));

            } else {
                request.setAttribute("steps", stepDAO.getAllSteps());
            }

        }



        RequestDispatcher dispatcher = request.getRequestDispatcher("/buildDance.jsp");
        dispatcher.forward(request, response);

    }
}
