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
import java.util.List;

@WebServlet(
        urlPatterns = {"/editUserProfile"}
)
public class EditUserProfile extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO genericDAO = new GenericDAO(User.class);
        User user = (User) genericDAO.getById(getId(request, genericDAO));

        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editProfile.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO genericDAO = new GenericDAO(User.class);

        String newLastName = request.getParameter("lastName");
        String newFirstName = request.getParameter("firstName");
        String newEmail = request.getParameter("email");
        String password = request.getParameter("password");

        User userToUpdate = (User)genericDAO.getById(getId(request, genericDAO));
        userToUpdate.setLastName(newLastName);
        userToUpdate.setFirstName(newFirstName);
        userToUpdate.setEmail(newEmail);
        userToUpdate.setPassword(password);
        userToUpdate.setRoleId(1);
        genericDAO.saveOrUpdate(userToUpdate);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/editProfile.jsp");
        dispatcher.forward(request, response);


    }

    private int getId(HttpServletRequest request, GenericDAO genericDAO) {

        String username = request.getUserPrincipal().getName();
        List<User> user = genericDAO.getByPropertyEqual("email", username);
        int userId = user.get(0).getId();
        return userId;

    }
}
