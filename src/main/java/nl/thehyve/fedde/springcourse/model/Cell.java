package nl.thehyve.fedde.springcourse.model;

import java.io.Serializable;

public class Cell implements Serializable {

    private static final long serialVersionUID = 5880720490948937867L;
    private Chromosome[] genome;

    public Chromosome[] getGenome() {
        return genome;
    }

    public void setGenome(Chromosome[] genome) {
        this.genome = genome;
    }
}
