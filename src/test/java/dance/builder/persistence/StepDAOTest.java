package dance.builder.persistence;

import dance.builder.entity.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        Step retrievedUser = (Step) genericDAO.getById(9);
        assertNotNull(retrievedUser);
        assertEquals("Curl", retrievedUser.getStepName());

    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Step> steps = genericDAO.getByPropertyEqual("level", "basic");
        assertEquals(5, steps.size());
        assertEquals(1, steps.get(0).getId());

    }

    @Test
    void getStepByDanceSuccess() {

        List<Step> steps = stepDAO.getStepByDance("basic", 1,3);
        assertEquals(3, steps.size());
    }



}