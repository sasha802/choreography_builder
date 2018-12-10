package dance.builder.persistence;

import dance.builder.entity.DanceMovement;
import dance.builder.persistence.GenericDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class DanceMovementTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDAO<DanceMovement> genericDAODanceMovement;

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

        List<DanceMovement> danceMovementPosition = genericDAODanceMovement.getByPropertyLike("dancePosition", dancePosition);
        List<DanceMovement> danceMovementTechnique = genericDAODanceMovement.getByPropertyLike("danceMovement", danceTechnique);
        DanceMovement danceMovement = genericDAODanceMovement.getById(1);
        logger.info(danceMovement);

        assertEquals(danceMovementPosition.get(0).getDancePosition(), danceMovement.getDancePosition());
        assertEquals(danceMovementTechnique.get(0).getDanceMovement(), danceMovement.getDanceMovement());

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