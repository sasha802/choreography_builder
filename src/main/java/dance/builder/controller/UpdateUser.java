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
        urlPatterns = {"/updateUser"}
)
public class UpdateUser extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDAO genericDAO = new GenericDAO(User.class);
        request.setAttribute("user", genericDAO.getAll());


        RequestDispatcher dispatcher = request.getRequestDispatcher("/editProfile.jsp");
        dispatcher.forward(request, response);

    }
}


