package nl.thehyve.fedde.springcourse.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cell implements Serializable {

    private static final long serialVersionUID = 5880720490948937867L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Chromosome genome;

    public long getId() {
        return id;
    }

    public Chromosome getGenome() {
        return genome;
    }

    public void setGenome(Chromosome genome) {
        this.genome = genome;
    }

}
