package nl.thehyve.fedde.springcourse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import nl.thehyve.fedde.springcourse.model.Cell;
import nl.thehyve.fedde.springcourse.persistence.CellRepository;

@Component
@Path("/cells")
@Produces(MediaType.APPLICATION_JSON)
public class CellEndpoint {

    @Autowired
    private CellRepository cellRepository;

    @GET
    public Response list() {
        Iterable<Cell> payload = cellRepository.findAll();
        return Response.ok(payload).build();
    }

}
