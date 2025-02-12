package metier;
import metier.ComposerId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "composer")
public class Composer implements Serializable {

    @EmbeddedId
    private ComposerId id;

    @Column(name = "QuantiteP")
    private int quantiteP;  // Changed to int

    // Default constructor
    public Composer() {}

    // Constructor with parameters
    public Composer(ComposerId id, int quantiteP) {
        this.id = id;
        this.quantiteP = quantiteP;
    }

    // Getters and Setters
    public ComposerId getId() {
        return id;
    }

    public void setId(ComposerId id) {
        this.id = id;
    }

    public int getQuantiteP() {
        return quantiteP;
    }

    public void setQuantiteP(int quantiteP) {
        this.quantiteP = quantiteP;
    }

    // Overriding equals and hashCode methods to compare objects properly


    @Override
    public int hashCode() {
        return Objects.hash(id, quantiteP);
    }

    @Override
    public String toString() {
        return "Composer{" +
                "id=" + id +
                ", quantiteP=" + quantiteP +  // Updated to show int
                '}';
    }
}
