package nl.thehyve.fedde.springcourse.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import nl.thehyve.fedde.springcourse.model.Cell;


@Repository
public interface CellRepository extends CrudRepository<Cell, Long> {
}
