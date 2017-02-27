package nl.thehyve.fedde.springcourse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chromosome implements Serializable {

    private static final long serialVersionUID = 9220788117776802135L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String sequence;

    private Chromosome() {
    }

    public Chromosome(String sequence) {
        setSequence(sequence);
    }

    public long getId() {
        return id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

}
