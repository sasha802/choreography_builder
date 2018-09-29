package dance.builder.persistence;

import dance.builder.entity.CustomSteps;
import dance.builder.entity.Step;
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

    @BeforeEach
    void setUp() {

        genericDAO = new GenericDAO(CustomSteps.class);
        stepDAO = new StepDAO();
        Database database = Database.getInstance();
        database.runSQL("customStepsCleandb.sql");

    }

    @Test
    void getAllCustomStepsSuccess() {
        List<CustomSteps> users = genericDAO.getAll();
        assertEquals(1, users.size());
    }

    @Test
    void insertSuccess() {

        CustomSteps newCustomStep = new CustomSteps("Box", "Rumba", "test", "test", "basic", 2);

        int id = genericDAO.insert(newCustomStep);
        assertNotEquals(id, 0);
        CustomSteps customSteps = (CustomSteps) genericDAO.getById(id);
        assertEquals("Box", customSteps.getStepName());

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
    void getStepByDanceSuccess() {

        List<Step> steps = stepDAO.getStepByDance("Advanced", 1,5);
        assertEquals(5, steps.size());
    }




}

