package nl.thehyve.fedde.springcourse.model;

import java.io.Serializable;

public class Chromosome implements Serializable {

    private static final long serialVersionUID = 9220788117776802135L;
    private String sequence;

    public Chromosome() {
    }

    public Chromosome(String sequence) {
        setSequence(sequence);
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

}
