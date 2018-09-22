package dance.builder.persistence;

import dance.builder.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    UserDAO userDAO;

    /**
     * Create the user dao.
     */
    @BeforeEach
    void setUp() {
        userDAO = new UserDAO();
    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getUserSuccess() {
        List<User> users = userDAO.getUser();
        assertEquals(2, users.size());
    }

    /**
     * Verifies gets all users by id
     */
    @Test
    void getByIdSuccess() {

        User retrievedUser = userDAO.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Sasha", retrievedUser.getFirstName());

    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Fred", "Flintstone", "fflintstone", 113, 1);
        int id = userDAO.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = userDAO.getById(id);
        assertEquals("Fred", insertedUser.getLastName());

    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        userDAO.delete(userDAO.getById(3));
        assertNull(userDAO.getById(3));
    }


    @Test
    void updateSuccess() {
        String newLastName = "Thomson";
        User userToUpdate = userDAO.getById(2);
        userToUpdate.setLastName(newLastName);
        userDAO.saveOrUpdate(userToUpdate);
        User retrievedUser = userDAO.getById(2);
        assertEquals(newLastName, retrievedUser.getLastName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = userDAO.getByPropertyLike("lastName", "Thomson");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = userDAO.getByPropertyLike("lastName", "T");
        assertEquals(2, users.size());
    }
}