package dance.builder.controller;

import dance.builder.entity.User;
import dance.builder.persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to get user information to update in the database
 * Pass updated data to the jsp for the display
 */
@WebServlet(
        urlPatterns = {"/editUserProfile"}
)
public class EditUserProfile extends HttpServlet {

    /**
     * Method to get user name and pass it to the jsp for the display
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO genericDAO = new GenericDAO(User.class);
        GetUser getUser = new GetUser(request);
        User user = (User) genericDAO.getById(getUser.getUserData().get(0).getId());

        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editProfile.jsp");
        dispatcher.forward(request, response);
    }


    /**
     * Method to get user info from the jsp and update it in the database
     * Method will validate user input
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO genericDAO = new GenericDAO(User.class);
        GetUser getUser = new GetUser(request);
        User userToUpdate = (User)genericDAO.getById(getUser.getUserData().get(0).getId());
        String newLastName = request.getParameter("lastName");
        String newFirstName = request.getParameter("firstName");
        String newEmail = request.getParameter("email");
        String password = request.getParameter("password");

        if ( newFirstName.trim().length() > 0 && newLastName.trim().length() > 0 && newEmail.trim().length() > 0
                && password.trim().length() > 0 ) {


            userToUpdate.setLastName(newLastName);
            userToUpdate.setFirstName(newFirstName);
            userToUpdate.setEmail(newEmail);
            userToUpdate.setPassword(password);
            userToUpdate.setRoleId(1);
            genericDAO.saveOrUpdate(userToUpdate);

            request.setAttribute("user", userToUpdate);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/editProfile.jsp");
            dispatcher.forward(request, response);

        } else {

            request.setAttribute("firstName", newFirstName);
            request.setAttribute("lastName", newLastName);
            request.setAttribute("email", newEmail);
            request.setAttribute("formValidation", false);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/editProfile.jsp");
            dispatcher.forward(request, response);
        }
    }

}
