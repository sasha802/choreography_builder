package services;

import dance.builder.entity.Step;
import dance.builder.persistence.GenericDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Class to generate json object of steps info
 * Created for the one of the weekly assignments of the Enterprise Java Course.
 * @author oponomarova
 */
@Path("/stepsData")
public class StepProcessor {


    /**
     * Build json of the step info based on the step name
     * @param stepName Name of the step
     * @return step description
     */
    @GET
    @Produces("application/json")
    @Path("/{param}")
    public Response getStepData(@PathParam("param") String stepName) {

        GenericDAO<Step> genericDAO = new GenericDAO<>(Step.class);
        Step step = genericDAO.getByPropertyEqual("stepName", stepName).get(0);

        return Response.status(200).entity(step).build();
    }
}
