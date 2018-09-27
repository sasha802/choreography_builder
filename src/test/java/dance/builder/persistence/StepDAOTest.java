package dance.builder.persistence;

import dance.builder.entity.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StepDAOTest {

    StepDAO stepDAO;
    GenericDAO genericDAO;
    Step step;

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
    void getStepByDanceSuccess() {

        List<Step> steps = stepDAO.getStepByDance("basic", 1,3);
        assertEquals(3, steps.size());

    }


}