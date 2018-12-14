package services;

import com.fasterxml.jackson.databind.ObjectMapper;

import dance.builder.entity.DanceMovement;

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
import javax.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Class to test danceMovement service
 * @author oponomarova
 */
class DanceMovementTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDAO<DanceMovement> genericDAODanceMovement;
    private Properties properties;
    private String danceName = "Waltz";


    /**
     * Create instance of the GenericDAO type DanceMovement
     */
    @BeforeEach
    void setUp() {
        genericDAODanceMovement = new GenericDAO<>(DanceMovement.class);
    }


    /**
     * To test getting dance movement and dance position based on the dance name
     * Using database.
     */
    @Test
    void getDanceTechniqueSuccess() {

        String testDanceMovement = "Footwork: Forward walking steps are normally taken with the heel first in contact " +
                "with the floor, with the toe lowering as the body moves over it.";
        String testDancePosition = "Slow Waltz is danced using a normal ballroom-style closed position dance hold.";

        DanceMovementProcessor movementProcessor = new DanceMovementProcessor();
        Response response = movementProcessor.getDanceMovement(danceName);
        DanceMovement danceMovement = (DanceMovement) response.getEntity();

        DanceMovement danceMovementEntity = new DanceMovement(danceName, testDanceMovement, testDancePosition);

        assertEquals(danceMovementEntity.getDanceMovement(), danceMovement.getDanceMovement());
        assertEquals(danceMovementEntity.getDancePosition(), danceMovement.getDancePosition());
    }


    /**
     * Test DanceMovement service to return dance position based on the dance name
     */
    @Test
    public void testDanceMovementJson() {

        Client client = ClientBuilder.newClient();
        String serviceUrl = loadProperties();
        String dancePosition = "Slow Waltz is danced using a normal ballroom-style closed position dance hold. This " +
                "typically includes the use of body contact, although a more relaxed semi-closed hold is often used " +
                "in social dance situations, or for learning purposes.\n" +
                "In closed position the man and lady stand in front of each other, " +
                "slightly offset to the left. The lady's right hand and man's left hand are joined in an upper-hand " +
                "clasp at approximately the lady's eye level. \n" +
                "The man's right hand is placed on the lady's shoulder blade, with the lady's left arm resting easily" +
                " on his right. The resulting dance frame should be held sturdy, " +
                "but relaxed and absent of tension or strain.";

        DanceMovement danceMovementEntity = new DanceMovement(danceName, "", dancePosition);

        try {

            WebTarget target = client.target(serviceUrl + danceName);

            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper mapper = new ObjectMapper();

            MovementResults results = mapper.readValue(response, MovementResults.class);
            assertEquals(danceMovementEntity.getDancePosition(), results.getDancePosition());

        } catch (IOException ioException) {
            logger.error(ioException);
        }

    }


    /**
     * Method to get service path (url) using properties file
     * @return url String service url
     */
    private String loadProperties() {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String servicePath = rootPath + "service.properties";

        properties = new Properties();

        try {

            properties.load(new FileInputStream(servicePath));

        } catch (FileNotFoundException fileNotFoundException) {
            logger.error("Fail to find file " + fileNotFoundException);
        } catch (IOException ioException) {
            logger.error("Input Output Exception " + ioException);
        }

        return properties.getProperty("url");

    }
}