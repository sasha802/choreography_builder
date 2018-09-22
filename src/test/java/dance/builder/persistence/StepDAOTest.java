package dance.builder.persistence;

import dance.builder.entity.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StepDAOTest {

    StepDAO stepDAO;

    @BeforeEach
    void setUp() {
        stepDAO = new StepDAO();
    }

    @Test
    void getAllStepsSuccess() {
        List<Step> steps = stepDAO.getAllSteps();
        assertEquals(15, steps.size());
    }

    @Test
    void getStepsByLevelSuccess() {
        List<Step> steps = stepDAO.getStepsByLevel("basic");
        assertEquals(5, steps.size());
    }


}