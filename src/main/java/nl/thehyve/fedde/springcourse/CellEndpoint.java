package nl.thehyve.fedde.springcourse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import nl.thehyve.fedde.springcourse.model.Cell;
import nl.thehyve.fedde.springcourse.service.CellService;

@Component
@Path("/cells")
public class CellEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(CellEndpoint.class);

    @Autowired
    private CellService service;
    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Iterable<Cell> payload = service.findAll();
        return Response
                .ok(payload)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response select(@PathParam("id") long id) {
        Cell payload = service.findById(id);
        if (payload == null) {
            LOGGER.debug("Could not find cell with ID {}", id);
            return Response
                    .status(Status.NOT_FOUND)
                    .build();
        } else {
            LOGGER.debug("Found cell: {}", payload);
            return Response
                    .ok(payload)
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Cell cell) {
        service.save(cell);
        return Response
                .created(uriInfo.getAbsolutePathBuilder()
                        .path(Long.toString(cell.getId()))
                        .build())
                .build();
    }

}
