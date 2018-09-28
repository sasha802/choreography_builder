package dance.builder.persistence;

import dance.builder.entity.CustomSteps;
import dance.builder.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class CustomStepsTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDAO genericDAO;

    @BeforeEach
    void setUp() {
        genericDAO = new GenericDAO(CustomSteps.class);
        Database database = Database.getInstance();
        database.runSQL("customStepsCleandb.sql");
    }

    @Test
    void insertSuccess() {

        CustomSteps newCustomStep = new CustomSteps("Box", "Rumba", "test", "test", "basic", 2);

        int id = genericDAO.insert(newCustomStep);
        assertNotEquals(id, 0);
        CustomSteps customSteps = (CustomSteps) genericDAO.getById(id);
        assertEquals("Box", customSteps.getStepName());

    }
}

