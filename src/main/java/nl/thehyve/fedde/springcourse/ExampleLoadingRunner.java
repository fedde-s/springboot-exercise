package nl.thehyve.fedde.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nl.thehyve.fedde.springcourse.model.Cell;
import nl.thehyve.fedde.springcourse.model.Chromosome;
import nl.thehyve.fedde.springcourse.persistence.CellRepository;
import nl.thehyve.fedde.springcourse.persistence.ChromosomeRepository;

//@Component
public class ExampleLoadingRunner implements CommandLineRunner {

    @Autowired
    private CellRepository cellRepository;
    @Autowired
    private ChromosomeRepository chromRepository;

    /**
     * Loads some example
     */
    @Override
    public void run(String... args) throws Exception {
        Chromosome chromosome1Hap1 = new Chromosome("ACGT");
        Chromosome chromosome1Hap2 = new Chromosome("AGGT");
        chromRepository.save(chromosome1Hap1);
        chromRepository.save(chromosome1Hap2);

        Cell first = new Cell(chromosome1Hap1);
        cellRepository.save(first);

        Cell second = new Cell(chromosome1Hap1);
        second.setGenome(chromosome1Hap2);
        cellRepository.save(second);
    }

}
