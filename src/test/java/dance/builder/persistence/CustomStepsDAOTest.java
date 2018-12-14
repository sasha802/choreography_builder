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


class CustomStepsDAOTest {

    private GenericDAO genericDAO;

    @BeforeEach
    void setUp() {

        genericDAO = new GenericDAO(CustomSteps.class);
        Database database = Database.getInstance();
        database.runSQL("customStepsCleandb.sql");

    }


    /**
     * Method to test for getting all the steps.ss
     */
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
        CustomSteps customSteps = (CustomSteps) genericDAO.getById(id);

        assertNotEquals(id, 0);
        assertEquals(newCustomStep, customSteps);
        assertEquals(newCustomStep.getId(), customSteps.getId());
        assertEquals(newCustomStep.getDanceName(), customSteps.getDanceName());
        assertEquals(newCustomStep.getFollowerDescription(), customSteps.getFollowerDescription());
        assertEquals(newCustomStep.getLeadDescription(), customSteps.getLeadDescription());


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
        CustomSteps stepToUpdate = (CustomSteps) genericDAO.getById(1);
        assertEquals(1, customSteps.size());
        assertEquals(stepToUpdate.getId(), customSteps.get(0).getId());
    }


    @Test
    void getByPropertyLikeSuccess() {
        List<CustomSteps> customSteps = genericDAO.getByPropertyLike("stepName", "Turn");
        assertEquals(1, customSteps.size());
    }

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

