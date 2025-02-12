package metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "retirer")
public class Retrait implements Serializable {

    @EmbeddedId
    private RetraitId id;

    @Column(name = "CreneauRetrait")
    private String creneauRetrait;

    // Default constructor
    public Retrait() {}

    // Constructor with parameters
    public Retrait(RetraitId id, String creneauRetrait) {
        this.id = id;
        this.creneauRetrait = creneauRetrait;
    }

    // Getters and Setters
    public RetraitId getId() {
        return id;
    }

    public void setId(RetraitId id) {
        this.id = id;
    }

    public String getCreneauRetrait() {
        return creneauRetrait;
    }

    public void setCreneauRetrait(String creneauRetrait) {
        this.creneauRetrait = creneauRetrait;
    }

    // Overriding equals and hashCode methods to compare objects properly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retrait retrait = (Retrait) o;
        return id.equals(retrait.id) &&
                creneauRetrait.equals(retrait.creneauRetrait);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creneauRetrait);
    }

    @Override
    public String toString() {
        return "Retrait{" +
                "id=" + id +
                ", creneauRetrait='" + creneauRetrait + '\'' +
                '}';
    }
}
