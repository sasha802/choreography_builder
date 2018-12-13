package dance.builder.controller;

import dance.builder.entity.User;
import dance.builder.persistence.GenericDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Class to pull username from database.
 * @author oponomarova
 */
class GetUser {

    private HttpServletRequest request;

    public GetUser() {}

    public GetUser(HttpServletRequest request) {
        this.request = request;
    }


    /**
     * Get user data based on requested property name
     * @return username.
     */
    public List<User> getUserData() {

        String username = request.getUserPrincipal().getName();
        GenericDAO genericDAOUser = new GenericDAO(User.class);
        return (List<User>) genericDAOUser.getByPropertyEqual("email", username);
    }

}
