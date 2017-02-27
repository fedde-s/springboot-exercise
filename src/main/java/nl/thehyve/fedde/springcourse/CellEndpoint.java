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

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import nl.thehyve.fedde.springcourse.model.Cell;
import nl.thehyve.fedde.springcourse.persistence.CellRepository;
import nl.thehyve.fedde.springcourse.persistence.ChromosomeRepository;

@Component
@Path("/cells")
public class CellEndpoint {

    @Autowired
    private CellRepository cellRepository;
    @Autowired
    private ChromosomeRepository chromosomeRepository;
    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Iterable<Cell> payload = cellRepository.findAll();
        return Response
                .ok(payload)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response select(@PathParam("id") long id) {
        Cell payload = cellRepository.findOne(id);
        return Response
                .ok(payload)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Cell cell) {
        chromosomeRepository.save(cell.getGenome());
        cellRepository.save(cell);
        return Response
                .created(uriInfo.getAbsolutePathBuilder()
                        .path(Long.toString(cell.getId()))
                        .build())
                .build();
    }

}
