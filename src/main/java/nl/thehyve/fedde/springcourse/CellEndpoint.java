package nl.thehyve.fedde.springcourse;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import nl.thehyve.fedde.springcourse.model.Cell;
import nl.thehyve.fedde.springcourse.model.Chromosome;

@Component
@Path("/cells")
@Produces(MediaType.APPLICATION_JSON)
public class CellEndpoint {

    @Autowired
    private CellRepository cellRepository;

    private List<Cell> cells;

    public CellEndpoint() {
        cells = new ArrayList<Cell>();

        Chromosome chromosome1 = new Chromosome("TCATAAG");
        Chromosome chromosome2Hap1 = new Chromosome("ACGT");
        Chromosome chromosome2Hap2 = new Chromosome("AGGT");

        Cell first = new Cell();
        first.setGenome(chromosome2Hap1);
        cells.add(first);

        Cell second = new Cell();
        second.setGenome(chromosome2Hap2);
        cells.add(second);
    }

    @GET
    public Response list() {
        Iterable<Cell> payload = cellRepository.findAll();
        return Response.ok(payload).build();
    }

}
