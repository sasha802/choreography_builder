package dance.builder.persistence;

import dance.builder.entity.CustomSteps;
import dance.builder.entity.Step;
import dance.builder.entity.User;
import dance.builder.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class CustomStepsDAOTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDAO genericDAO;
    StepDAO stepDAO;
    User user;

    @BeforeEach
    void setUp() {

        genericDAO = new GenericDAO(CustomSteps.class);
        stepDAO = new StepDAO();
        user = new User();
        Database database = Database.getInstance();
        database.runSQL("customStepsCleandb.sql");

    }

    @Test
    void getAllCustomStepsSuccess() {
        List<CustomSteps> users = genericDAO.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void insertSuccess() {

        GenericDAO genericDAOUser = new GenericDAO(User.class);
        User user = (User)genericDAOUser.getById(2);

        CustomSteps newCustomStep = new CustomSteps("Box", "Rumba", "test", "test", "basic", user);

        int id = genericDAO.insert(newCustomStep);
        assertNotEquals(id, 0);
        CustomSteps customSteps = (CustomSteps) genericDAO.getById(id);
        assertEquals("Box", customSteps.getStepName());
        assertEquals("Rumba", customSteps.getDanceName());
        assertEquals("test", customSteps.getLeadDescription());
        assertEquals("test", customSteps.getFollowerDescription());
        assertEquals("basic", customSteps.getLevel());
        assertEquals(3, customSteps.getId());


    }

    @Test
    void updateSuccess() {

        String newCustomStep = "Turning Top";
        CustomSteps stepToUpdate = (CustomSteps) genericDAO.getById(1);
        stepToUpdate.setStepName(newCustomStep);
        genericDAO.saveOrUpdate(stepToUpdate);
        CustomSteps retrievedCustomStep = (CustomSteps) genericDAO.getById(1);
        assertEquals(stepToUpdate, retrievedCustomStep);
    }


    @Test
    void removeCustomStepSuccess() {

        int deleted = 1;
        CustomSteps stepToUpdate = (CustomSteps) genericDAO.getById(2);
        stepToUpdate.setDeleted(deleted);
        genericDAO.saveOrUpdate(stepToUpdate);
        CustomSteps retrievedCustomStep = (CustomSteps) genericDAO.getById(2);
        assertEquals(stepToUpdate, retrievedCustomStep);
    }

    @Test
    void deleteSuccess() {

        genericDAO.delete(genericDAO.getById(1));
        assertNull(genericDAO.getById(1));
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<CustomSteps> customSteps = genericDAO.getByPropertyEqual("level", "basic");
        assertEquals(1, customSteps.size());
        assertEquals(1, customSteps.get(0).getId());
    }


    @Test
    void getByPropertyLikeSuccess() {
        List<CustomSteps> customSteps = genericDAO.getByPropertyLike("stepName", "Turn");
        assertEquals(1, customSteps.size());
    }

    @Test
    void getByCustomStepsPropertyEqualSuccess() {

        CustomStepsDAO customStepsDAO = new CustomStepsDAO();
        GenericDAO genericDAOUser = new GenericDAO(User.class);
        User user = (User)genericDAOUser.getById(2);

        List<CustomSteps> customSteps = customStepsDAO.getByCustomStepsPropertyEqual("user", user);
        assertEquals(1, customSteps.size());
    }





}

