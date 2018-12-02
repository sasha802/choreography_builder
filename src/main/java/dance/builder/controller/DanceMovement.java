package dance.builder.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import dance.movement.MovementResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/danceMovement"}
)
public class DanceMovement extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String danceName = request.getParameter("danceName");
       // String serviceUrl = "http://localhost:8080/choreographybuilder/service/danceMovements/";
        String serviceUrl = loadProperties();
        Client client = ClientBuilder.newClient();

        RequestDispatcher dispatcher;

        try {

            WebTarget target = client.target(serviceUrl + danceName);
            String appResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper mapper = new ObjectMapper();

            MovementResults results = mapper.readValue(appResponse, MovementResults.class);

            request.setAttribute("danceMovement", results.getDanceMovement());
            request.setAttribute("dancePosition", results.getDancePosition());
            request.setAttribute("danceName", results.getDanceName());

            dispatcher = request.getRequestDispatcher("/danceMovement.jsp");
            dispatcher.forward(request, response);

        } catch (IOException ioException) {
            logger.error(ioException);
        }


    }


    private String loadProperties() {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String servicePath = rootPath + "service.properties";

        Properties properties = new Properties();

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
