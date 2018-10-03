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


@WebServlet(
        urlPatterns = {"/removeCustomStep"}
)
public class removeCustomStep extends HttpServlet {
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



