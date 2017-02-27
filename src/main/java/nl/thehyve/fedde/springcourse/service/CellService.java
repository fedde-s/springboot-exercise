package nl.thehyve.fedde.springcourse.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import nl.thehyve.fedde.springcourse.model.Cell;
import nl.thehyve.fedde.springcourse.persistence.CellRepository;
import nl.thehyve.fedde.springcourse.persistence.ChromosomeRepository;

@Service
@Transactional
public class CellService {

    @Autowired
    private CellRepository cellRepository;
    @Autowired
    private ChromosomeRepository chromosomeRepository;

    public Iterable<Cell> findAll() {
        return cellRepository.findAll();
    }

    public Cell findById(long id) {
        return cellRepository.findOne(id);
    }

    public void save(Cell cell) {
        chromosomeRepository.save(cell.getGenome());
        cellRepository.save(cell);
    }

}
