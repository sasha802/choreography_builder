package dance.builder.persistence;

import dance.builder.entity.Dance;
import dance.builder.entity.DanceTechnique;
import dance.builder.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DanceTechniqueTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDAO<DanceTechnique> genericDAO;
    GenericDAO<Dance> genericDAODance;
    Dance dance;

    @BeforeEach
    void setUp() {
        genericDAO = new GenericDAO(DanceTechnique.class);
        genericDAODance = new GenericDAO(Dance.class);

        Database database = Database.getInstance();
        database.runSQL("cleanDanceTechniqueDB.sql");

    }

    @Test
    void insertSuccess() {

        dance = genericDAODance.getById(1);

        DanceTechnique danceTechnique = new DanceTechnique("test dance movement", "test dance position", dance);
        int id = genericDAO.insert(danceTechnique);
        assertNotEquals(0, id);
        DanceTechnique insertedTechnique = genericDAO.getById(id);
        assertEquals("test dance movement", insertedTechnique.getDanceMovement());

    }

    /*@Test
    void getByPropertyEqualSuccess() {

        List<DanceTechnique> danceTechniques = genericDAO.getByPropertyEqual("dance", "2");
        assertEquals(1, danceTechniques.size());
    }*/

    @Test
    void getByMultiplePropertiesTopClauseSuccess() {

        Map<String, Map<String, String>> entity = new HashMap<>();
        Map<String, String> propertyOne = new HashMap<>();
        Map<String, String> propertyTwo = new HashMap<>();
        
        propertyOne.put("id", "2");
        propertyTwo.put("deleted", "0");

        entity.put("dance", propertyOne);
        entity.put("", propertyTwo);

        List<DanceTechnique> list = genericDAO.getByMultiplePropertiesTopClause(entity, 0);
        assertEquals(1, list.size());

    }
}