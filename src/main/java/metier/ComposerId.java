package metier;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class ComposerId implements Serializable {

    @Column(name = "IdPro")
    private int idPro;

    @Column(name = "IdPanier")
    private int idPanier;

    // Default constructor
    public ComposerId() {}

    // Constructor with parameters
    public ComposerId(int idPro, int idPanier) {
        this.idPro = idPro;
        this.idPanier = idPanier;
    }

    // Getters and Setters
    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    // Overriding equals and hashCode methods to compare objects properly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposerId that = (ComposerId) o;
        return idPro == that.idPro && idPanier == that.idPanier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPro, idPanier);
    }

    @Override
    public String toString() {
        return "ComposerId{" +
                "idPro=" + idPro +
                ", idPanier=" + idPanier +
                '}';
    }
}
