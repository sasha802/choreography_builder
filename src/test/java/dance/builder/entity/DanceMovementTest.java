package dance.builder.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import dance.builder.persistence.GenericDAO;
import dance.movement.MovementResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
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
    public void testDanceMovementJson() {

        String danceName = "Waltz";
        Client client = ClientBuilder.newClient();

        try {
            WebTarget target = client.target("http://localhost:8080/choreographybuilder/service/danceMovement/" + danceName);
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper mapper = new ObjectMapper();

            MovementResults results = mapper.readValue(response, MovementResults.class);
            assertEquals("Slow Waltz is danced using a normal ballroom-style closed position dance hold.", results.getDancePosition());

        } catch (IOException ioException) {
            logger.error(ioException);
        }

    }
}