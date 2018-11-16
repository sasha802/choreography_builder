package services;

import dance.builder.entity.DanceMovement;
import dance.builder.persistence.GenericDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/danceMovements")
public class DanceMovementProcessor {

    @GET
    @Produces("application/json")
    @Path("/{param}")
    public Response getDanceMovement(@PathParam("param") String danceName) {

        GenericDAO<DanceMovement> movementGenericDAO = new GenericDAO<>(DanceMovement.class);
        DanceMovement danceMovement = movementGenericDAO.getByPropertyEqual("danceName", danceName).get(0);

        return Response.status(200).entity(danceMovement).build();
    }
}
