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


/**
 * Class to test data manipulation of the Step entity
 * @author oponomarova
 */
class StepDAOTest {

    private GenericDAO genericDAO;


    /**
     * Create GenericDAO instance type Step
     */
    @BeforeEach
    void setUp() {
        genericDAO = new GenericDAO(Step.class);
    }


    /**
     * Test for getting number of existing steps in the database
     */
    @Test
    void getAllStepsSuccess() {
        List<Step> steps = genericDAO.getAll();
        assertEquals(15, steps.size());
    }


    /**
     * Test for getting step by id
     */
    @Test
    void getByIdSuccess() {

        int stepId = 9;
        Step genericStep = (Step) genericDAO.getById(stepId);
        genericStep.setId(stepId);
        Step retrievedStep = (Step) genericDAO.getById(stepId);

        assertNotNull(retrievedStep);
        assertEquals(genericStep, retrievedStep);

    }


    /**
     * Getting step information using equals clause
     */
    @Test
    void getByPropertyEqualSuccess() {

        List<Step> steps = genericDAO.getByPropertyEqual("level", "basic");
        Step step = (Step) genericDAO.getById(steps.get(0).getId());

        assertEquals(step.getStepName(), steps.get(0).getStepName());
        assertEquals(step.getId(), steps.get(0).getId());
        assertEquals(step.getFollowerDescription(), steps.get(0).getFollowerDescription());
        assertEquals(step.getLeadDescription(), steps.get(0).getLeadDescription());
        assertEquals(5, steps.size());

    }


    /**
     * Testing the ability to update the step infos
     */
    @Test
    void updateSuccess() {

        String newStep = "My New Step";
        Step stepToUpdate = (Step) genericDAO.getById(1);
        stepToUpdate.setStepName(newStep);
        genericDAO.saveOrUpdate(stepToUpdate);
        Step retrievedCustomStep = (Step) genericDAO.getById(1);
        assertEquals(stepToUpdate, retrievedCustomStep);
    }


    /**
     * Testing getting steps based on the multiple condition (properties)
     * Testing for limit clause (Optional)
     */
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


    /**
     * Testing Step service for the weekly lab assignment
     */
    @Test
    void getStepService() {

        String stepName = "Curl";
        StepProcessor stepProcessor = new StepProcessor();
        Response response = stepProcessor.getStepData(stepName);
        Step step = (Step) response.getEntity();

        List<Step> getStepName = genericDAO.getByPropertyEqual("stepName", stepName);

        assertEquals(getStepName.get(0).getStepName(), step.getStepName());

    }



}