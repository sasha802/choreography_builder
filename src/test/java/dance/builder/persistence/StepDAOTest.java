package dance.builder.persistence;

import dance.builder.entity.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.StepProcessor;


import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StepDAOTest {

    GenericDAO genericDAO;

    @BeforeEach
    void setUp() {
        genericDAO = new GenericDAO(Step.class);
    }

    @Test
    void getAllStepsSuccess() {
        List<Step> steps = genericDAO.getAll();
        assertEquals(15, steps.size());
    }

    @Test
    void getStepsByLevelSuccess() {
        List<Step> steps = genericDAO.getByPropertyLike("level", "basic");
        assertEquals(5, steps.size());
    }

    @Test
    void getByIdSuccess() {

        Step retrievedStep = (Step) genericDAO.getById(9);
        assertNotNull(retrievedStep);
        assertEquals("Curl", retrievedStep.getStepName());

    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Step> steps = genericDAO.getByPropertyEqual("level", "basic");
        assertEquals(5, steps.size());
        assertEquals(1, steps.get(0).getId());

    }

    @Test
    void updateSuccess() {

        String newStep = "My New Step";
        Step stepToUpdate = (Step) genericDAO.getById(1);
        stepToUpdate.setStepName(newStep);
        genericDAO.saveOrUpdate(stepToUpdate);
        Step retrievedCustomStep = (Step) genericDAO.getById(1);
        assertEquals(stepToUpdate, retrievedCustomStep);
    }

    @Test
    void getByMultiplePropertiesTopClauseSuccess() {

        Map<String, Map<String, String>> entities = new HashMap<>();
        Map<String, String> propertiesOne = new HashMap<>();
        Map<String, String> propertiesTwo = new HashMap<>();

        propertiesOne.put("id", "1");
        propertiesTwo.put("level", "basic");

        entities.put("dance", propertiesOne);
        entities.put("", propertiesTwo);


        List<Step> step = genericDAO.getByMultiplePropertiesTopClause(entities, 3);

        assertEquals(3, step.size());

    }

    @Test
    void getStepService() {

        StepProcessor stepProcessor = new StepProcessor();
        Response response = stepProcessor.getStepData("Curl");
        Step step = (Step) response.getEntity();

        assertEquals("Curl", step.getStepName());

    }



}