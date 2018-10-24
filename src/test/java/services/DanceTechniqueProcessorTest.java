package services;

import dance.builder.entity.Dance;
import dance.builder.entity.DanceTechnique;
import dance.builder.persistence.GenericDAO;
import dance.builder.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

class DanceTechniqueProcessorTest {

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
    void getDanceTechnique() {

        DanceTechniqueProcessor processor = new DanceTechniqueProcessor();

        Response response = processor.getDanceTechnique("2");
        DanceTechnique danceTechnique = (DanceTechnique) response.getEntity();

        assertEquals(1, danceTechnique.getId());
    }
}