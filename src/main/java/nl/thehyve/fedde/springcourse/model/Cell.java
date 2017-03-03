package nl.thehyve.fedde.springcourse.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Cell implements Serializable {

    private static final long serialVersionUID = 5880720490948937867L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Chromosome genome;
    // fetch eagerly, to have the elements at the ready when generating JSON for a cell
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Chromosome> plasmids = new ArrayList<Chromosome>();
    private Color color;
    private String name;

    @SuppressWarnings("unused")
    private Cell() {
    }

    public Cell(Chromosome genome, Color color) {
        this.genome = genome;
        this.setColor(color);
    }

    public long getId() {
        return id;
    }

    public Chromosome getGenome() {
        return genome;
    }

    @SuppressWarnings("unused")
    private void setGenome(Chromosome genome) {
        this.genome = genome;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chromosome[] getPlasmids() {
        return this.plasmids.toArray(new Chromosome[] {});
    }

    public void addPlasmid(Chromosome chromosome) {
        this.plasmids.add(chromosome);
    }

}
