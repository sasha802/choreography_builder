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

/**
 * Servlet to delete user selected step from the user interface
 * @author oponomarova
 */
@WebServlet(
        urlPatterns = {"/removeCustomStep"}
)
public class removeCustomStep extends HttpServlet {


    /**
     * Method to get step id from the user
     * To perform database operation to remove selected step from the user interface
     * Method uses soft deleted
     * @param request HttpServletRequest request
     * @param response HttpServletResponse response
     * @throws ServletException throws ServletException
     * @throws IOException throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO customStepGenericDAO = new GenericDAO(CustomSteps.class);
        int deleted = 1;

        String step = request.getParameter("step");
        Integer stepId = Integer.valueOf(step);

        CustomSteps stepToUpdate = (CustomSteps) customStepGenericDAO.getById(stepId);
        stepToUpdate.setDeleted(deleted);
        customStepGenericDAO.saveOrUpdate(stepToUpdate);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/displayCustomSteps");
        dispatcher.forward(request, response);
    }
}



