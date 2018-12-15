package dance.builder.persistence;

import dance.builder.entity.CustomSteps;
import dance.builder.entity.User;
import dance.builder.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * To test Custom Steps data operation
 * @author oponomarova
 */
class CustomStepsDAOTest {

    private GenericDAO genericDAO;


    /**
     * Create instance of the GenericDAO type CustomStep
     * Perform database cleanup.
     */
    @BeforeEach
    void setUp() {

        genericDAO = new GenericDAO(CustomSteps.class);
        Database database = Database.getInstance();
        database.runSQL("customStepsCleandb.sql");
    }


    /**
     * Method to test for getting all the steps
     */
    @Test
    void getAllCustomStepsSuccess() {

        List<CustomSteps> users = genericDAO.getAll();
        assertEquals(2, users.size());
    }


    /**
     * Method to test step insertion
     */
    @Test
    void insertSuccess() {

        GenericDAO genericDAOUser = new GenericDAO(User.class);
        User user = (User)genericDAOUser.getById(2);

        CustomSteps newCustomStep = new CustomSteps("Box", "Rumba", "test", "test", "basic", user);

        int id = genericDAO.insert(newCustomStep);
        CustomSteps customSteps = (CustomSteps) genericDAO.getById(id);

        assertNotEquals(id, 0);
        assertEquals(newCustomStep, customSteps);
        assertEquals(newCustomStep.getId(), customSteps.getId());
        assertEquals(newCustomStep.getDanceName(), customSteps.getDanceName());
        assertEquals(newCustomStep.getFollowerDescription(), customSteps.getFollowerDescription());
        assertEquals(newCustomStep.getLeadDescription(), customSteps.getLeadDescription());
    }


    /**
     * Method to test if step will be updated
     */
    @Test
    void updateSuccess() {

        String newCustomStep = "Turning Top";
        CustomSteps stepToUpdate = (CustomSteps) genericDAO.getById(1);
        stepToUpdate.setStepName(newCustomStep);
        genericDAO.saveOrUpdate(stepToUpdate);
        CustomSteps retrievedCustomStep = (CustomSteps) genericDAO.getById(1);
        assertEquals(stepToUpdate, retrievedCustomStep);
    }


    /**
     * Method to test soft deleting of the step
     */
    @Test
    void removeCustomStepSuccess() {

        int deleted = 1;
        CustomSteps stepToUpdate = (CustomSteps) genericDAO.getById(2);
        stepToUpdate.setDeleted(deleted);
        genericDAO.saveOrUpdate(stepToUpdate);
        CustomSteps retrievedCustomStep = (CustomSteps) genericDAO.getById(2);
        assertEquals(stepToUpdate, retrievedCustomStep);
    }


    /**
     * Method to test hard deleting of the step
     */
    @Test
    void deleteSuccess() {

        genericDAO.delete(genericDAO.getById(1));
        assertNull(genericDAO.getById(1));
    }


    /**
     * Method to test selection of the specific step base on the equal condition
     */
    @Test
    void getByPropertyEqualSuccess() {

        List<CustomSteps> customSteps = genericDAO.getByPropertyEqual("level", "basic");
        CustomSteps stepToUpdate = (CustomSteps) genericDAO.getById(1);
        assertEquals(1, customSteps.size());
        assertEquals(stepToUpdate.getId(), customSteps.get(0).getId());
    }


    /**
     * Method to test selection of the specific step base on the like condition
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<CustomSteps> customSteps = genericDAO.getByPropertyLike("stepName", "Turn");
        assertEquals(1, customSteps.size());
    }


    /**
     * Method to test selection of the specific step base on the multiple condition
     */
    @Test
    void getByMultiplePropertiesTopClauseSuccess() {

        Map<String,  Map<String, String>> entity = new HashMap<>();
        Map<String, String> propertyOne = new HashMap<>();
        Map<String, String> propertyTwo = new HashMap<>();

        propertyOne.put("id", "2");
        propertyTwo.put("deleted", "0");
        entity.put("user", propertyOne);
        entity.put("", propertyTwo);


        List<CustomSteps> customSteps = genericDAO.getByMultiplePropertiesTopClause(entity, 0);
        assertEquals(1, customSteps.size());
    }
}

