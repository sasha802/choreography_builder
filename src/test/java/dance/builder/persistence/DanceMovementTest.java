package dance.builder.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import dance.builder.entity.Dance;
import dance.builder.entity.DanceMovement;
import dance.builder.persistence.GenericDAO;
import dance.movement.MovementResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DanceMovementProcessor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class DanceMovementTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDAO<DanceMovement> genericDAODanceMovement;

    @BeforeEach
    void setUp() {

        genericDAODanceMovement = new GenericDAO<>(DanceMovement.class);
    }

    @Test
    void getByPropertyEqualSuccess() {

        List<DanceMovement> list = genericDAODanceMovement.getByPropertyEqual("danceName", "Waltz");
        logger.info(list.get(0).getDanceMovement());
        assertEquals(1, list.size());

    }

    @Test
    void getByPropertyLikeSuccess() {

        String danceTechnique = "Footwork: Forward walking steps are normally taken with the heel first in contact with" +
                " the floor, with the toe lowering as the body moves over it.";

        String dancePosition = "Slow Waltz is danced using a normal ballroom-style closed position dance hold.";

        DanceMovement danceMovement = genericDAODanceMovement.getById(1);
        logger.info(danceMovement);
        assertEquals(1, danceMovement.getId());
        assertEquals("Waltz", danceMovement.getDanceName());
        assertEquals(danceTechnique, danceMovement.getDanceMovement());
        assertEquals(dancePosition, danceMovement.getDancePosition());

    }

    @Test
    void insertSuccess() {

        DanceMovement newDanceMovement = new DanceMovement("Cha-Cha-Cha", "dance technique", "dance position");
        int id = genericDAODanceMovement.insert(newDanceMovement);
        assertNotEquals(0, id);

        DanceMovement newDanceMovementRetried = genericDAODanceMovement.getById(id);
        assertEquals(newDanceMovement, newDanceMovementRetried);


    }

}