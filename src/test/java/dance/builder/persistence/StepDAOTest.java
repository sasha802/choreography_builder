package dance.builder.persistence;

import dance.builder.entity.Dance;
import dance.builder.entity.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StepDAOTest {

    StepDAO stepDAO;
    GenericDAO genericDAO;

    @BeforeEach
    void setUp() {
        stepDAO = new StepDAO();
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
    void getStepByDanceSuccess() {

        List<Step> steps = stepDAO.getStepByDance("dance", "level", "basic", 1, 3);
        assertEquals(3, steps.size());
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
    void getStepByDanceGenericSuccess() {

        List<String> properties = new ArrayList<>();
        properties.add("dance");
        properties.add("level");

        List<Step> step = genericDAO.getStepByDanceGeneric(properties, "basic", 1, 3);

        assertEquals(3, step.size());

    }



}