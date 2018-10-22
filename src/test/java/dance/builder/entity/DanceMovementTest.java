package dance.builder.entity;

import dance.builder.persistence.GenericDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DanceMovementTest {

    GenericDAO<DanceMovement> genericDAODanceMovement;

    @BeforeEach
    void setUp() {

        genericDAODanceMovement = new GenericDAO<>(DanceMovement.class);
    }

    @Test
    void getByPropertyEqualSuccess() {

        List<DanceMovement> list = genericDAODanceMovement.getByPropertyEqual("danceName", "Waltz");
        assertEquals(1, list.size());

    }
}