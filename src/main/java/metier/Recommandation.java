package metier;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Recommandation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdR")
    private int idR;
    @Column(name = "Raison", length = 50)
    private String raison;

    @OneToMany(mappedBy = "recommandation")
    private List<Concerner> concerners;

    @OneToMany(mappedBy = "recommandation")
    private List<Recommander> recommenders;

    public Recommandation() {
    }

    public Recommandation(int idR, String raison, List<Concerner> concerners, List<Recommander> recommenders) {
        this.idR = idR;
        this.raison = raison;
        this.concerners = concerners;
        this.recommenders = recommenders;
    }
    // getters and setters

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public List<Concerner> getConcerners() {
        return concerners;
    }

    public void setConcerners(List<Concerner> concerners) {
        this.concerners = concerners;
    }

    public List<Recommander> getRecommenders() {
        return recommenders;
    }

    public void setRecommenders(List<Recommander> recommenders) {
        this.recommenders = recommenders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recommandation that = (Recommandation) o;
        return idR == that.idR && Objects.equals(raison, that.raison) && Objects.equals(concerners, that.concerners) && Objects.equals(recommenders, that.recommenders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idR, raison, concerners, recommenders);
    }

    @Override
    public String toString() {
        return "Recommandation{" +
                "idR=" + idR +
                ", raison='" + raison + '\'' +
                ", concerners=" + concerners +
                ", recommenders=" + recommenders +
                '}';
    }
}
