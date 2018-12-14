package dance.builder.persistence;

import dance.builder.entity.User;
import dance.builder.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Class to test data manipulation of the User entity
 * @author oleksandraponomarova
 */
class UserDAOTest {


    private GenericDAO genericDAO;


    /**
     * Create the user dao.
     * Clean up database
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

        User retrievedUser = (User)genericDAO.getById(2);
        assertNotNull(retrievedUser);
        assertEquals(2, retrievedUser.getId());
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
        assertEquals(newUser, insertedUser);
    }


    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {

        genericDAO.delete(genericDAO.getById(2));
        assertNull(genericDAO.getById(2));
    }


    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Mikels";
        User userToUpdate = (User) genericDAO.getById(2);
        userToUpdate.setLastName(newLastName);
        genericDAO.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) genericDAO.getById(2);
        assertEquals(userToUpdate, retrievedUser);
    }


    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {

         User user = new User("Thomson", "Mike", "thomson", "115", 2);
        List<User> users = genericDAO.getByPropertyEqual("email", "thomson");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
        assertEquals(user.getLastName(), users.get(0).getLastName());
        assertEquals(user.getFirstName(), users.get(0).getFirstName());
        assertEquals(user.getEmail(), users.get(0).getEmail());
        assertEquals(user.getPassword(), users.get(0).getPassword());
        assertEquals(user.getRoleId(), users.get(0).getRoleId());

    }


    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDAO.getByPropertyLike("email", "jcoyne");
        assertEquals(1, users.size());
    }
}