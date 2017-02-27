package nl.thehyve.fedde.springcourse.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import nl.thehyve.fedde.springcourse.model.Chromosome;

@Repository
public interface ChromosomeRepository extends CrudRepository<Chromosome, Long> {
}
