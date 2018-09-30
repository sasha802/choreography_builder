package dance.builder.controller;


import dance.builder.entity.CustomSteps;
import dance.builder.entity.User;
import dance.builder.persistence.CustomStepsDAO;
import dance.builder.persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/displayCustomSteps"}
)
public class DisplayCustomSteps extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        CustomStepsDAO customStepsDAO = new CustomStepsDAO();
        GenericDAO genericDAOUser = new GenericDAO(User.class);
        User user = (User)genericDAOUser.getById(2);
        List<CustomSteps> customSteps = customStepsDAO.getByCustomStepsPropertyEqual("user", user);

        request.setAttribute("customSteps", customSteps);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/danceManager.jsp");
        dispatcher.forward(request, response);

    }

}
