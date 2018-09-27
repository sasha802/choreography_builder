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


@WebServlet(
        urlPatterns = {"/insertUser"}
)
public class InsertUser extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;

        GenericDAO genericDAO = new GenericDAO(User.class);

        int userRole = 1;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String submit = request.getParameter("submit");

        if ( submit.equals(submit) ) {

            if ( firstName.trim().length() > 0 && lastName.trim().length() > 0 && email.trim().length() > 0 && password.trim().length() > 0 ) {

                User user = new User(lastName, firstName, email, password, userRole);
                int id = genericDAO.insert(user);

                User insertedUser = (User) genericDAO.getById(id);

                request.setAttribute("user", insertedUser.getFirstName());

                dispatcher = request.getRequestDispatcher("buildDance.jsp");
                dispatcher.forward(request, response);

            } else {

                dispatcher = request.getRequestDispatcher("/signup.jsp");
                dispatcher.forward(request, response);

            }

        }
    }
}
