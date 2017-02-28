package nl.thehyve.fedde.springcourse.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nl.thehyve.fedde.springcourse.model.Cell;


@Repository
public interface CellRepository extends CrudRepository<Cell, Long> {

    @Modifying
    @Query("DELETE FROM Cell")
    public Integer clear();

    // TODO: query by a simple attribute, test if it needs to be findByName
    //public Cell bluh(String name);

}
