package metier;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ListeAchete")
public class ListeAchete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLA")
    private int idLA;

    @Column(name = "Sujet")
    private String sujet;

    @Column(name = "DescriptionLA")
    private String descriptionLA;

    @ManyToOne
    @JoinColumn(name = "IdPanier")
    private Panier panier;

    public ListeAchete() {
    }

    public ListeAchete(int idLA, String sujet, String descriptionLA, Panier panier) {
        this.idLA = idLA;
        this.sujet = sujet;
        this.descriptionLA = descriptionLA;
        this.panier = panier;
    }
    // Getters and Setters


    public int getIdLA() {
        return idLA;
    }

    public void setIdLA(int idLA) {
        this.idLA = idLA;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescriptionLA() {
        return descriptionLA;
    }

    public void setDescriptionLA(String descriptionLA) {
        this.descriptionLA = descriptionLA;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ListeAchete that = (ListeAchete) o;
        return idLA == that.idLA && Objects.equals(sujet, that.sujet) && Objects.equals(descriptionLA, that.descriptionLA) && Objects.equals(panier, that.panier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLA, sujet, descriptionLA, panier);
    }

    @Override
    public String toString() {
        return "ListeAchete{" +
                "idLA=" + idLA +
                ", sujet='" + sujet + '\'' +
                ", descriptionLA='" + descriptionLA + '\'' +
                ", panier=" + panier +
                '}';
    }

}

