package dance.builder.persistence;

import dance.builder.entity.User;
import dance.builder.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {


    GenericDAO genericDAO;

    /**
     * Create the user dao.
     */
    @BeforeEach
    void setUp() {

        genericDAO = new GenericDAO(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getUserSuccess() {
        List<User> users = genericDAO.getAll();
        assertEquals(2, users.size());
    }

    /**
     * Verifies gets all users by id
     */
    @Test
    void getByIdSuccess() {

        User retrievedUser = (User)genericDAO.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Joe", retrievedUser.getFirstName());

    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Fred", "Flintstone", "fflintstone", "123", 2);
        int id = genericDAO.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User) genericDAO.getById(id);
        assertEquals("Fred", insertedUser.getLastName());

    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDAO.delete(genericDAO.getById(1));
        assertNull(genericDAO.getById(1));
    }


    @Test
    void updateSuccess() {
        String newLastName = "Mikels";
        User userToUpdate = (User) genericDAO.getById(1);
        userToUpdate.setLastName(newLastName);
        genericDAO.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) genericDAO.getById(1);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = genericDAO.getByPropertyLike("lastName", "Thomson");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDAO.getByPropertyLike("lastName", "C");
        assertEquals(1, users.size());
    }
}