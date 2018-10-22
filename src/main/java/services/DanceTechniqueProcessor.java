package services;

import dance.builder.entity.DanceTechnique;
import dance.builder.persistence.GenericDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("/danceTechnique")
public class DanceTechniqueProcessor {

    @GET
    @Produces("application/json")
    @Path("{param}")
    public Response getDanceTechnique(@PathParam("param") String danceId) {

        GenericDAO genericDAO = new GenericDAO(DanceTechnique.class);
        Map<String, Map<String, String>> entity = new HashMap<>();
        Map<String, String> propertyOne = new HashMap<>();
        Map<String, String> propertyTwo = new HashMap<>();

        propertyOne.put("id", danceId);
        propertyTwo.put("deleted", "0");

        entity.put("dance", propertyOne);
        entity.put("", propertyTwo);

        List<DanceTechnique> danceTechnique = genericDAO.getByMultiplePropertiesTopClause(entity, 0);

        return Response.status(200).entity(danceTechnique.get(0)).build();
    }


}
