package nl.thehyve.fedde.springcourse;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import nl.thehyve.fedde.springcourse.model.Cell;
import nl.thehyve.fedde.springcourse.model.Chromosome;

@Component
@Path("/cells")
@Produces(MediaType.APPLICATION_JSON)
public class CellEndpoint {

    @GET
    public Response list() {

        List<Cell> payload = new ArrayList<Cell>();

        Chromosome chromosome1 = new Chromosome("ACGT");
        Chromosome chromosome2 = new Chromosome("AGGT");
        Chromosome chromosome3 = new Chromosome("TCATAAG");

        Cell first = new Cell();
        first.setGenome(new Chromosome[]{chromosome1, chromosome3});
        payload.add(first);

        Cell second = new Cell();
        second.setGenome(new Chromosome[]{chromosome2, chromosome3});
        payload.add(second);

        return Response.ok(payload).build();

    }

}
