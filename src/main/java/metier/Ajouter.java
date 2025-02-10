package metier;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Ajouter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPro;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLA;

    @ManyToOne
    @JoinColumn(name = "idPro", referencedColumnName = "IdPro", insertable = false, updatable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "idLA", referencedColumnName = "IdLA", insertable = false, updatable = false)
    private ListeAchete listeAchete;

    public Ajouter() {
    }

    public Ajouter(int idPro, int idLA, Produit produit, ListeAchete listeAchete) {
        this.idPro = idPro;
        this.idLA = idLA;
        this.produit = produit;
        this.listeAchete = listeAchete;
    }

    // getters and setters
    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdLA() {
        return idLA;
    }

    public void setIdLA(int idLA) {
        this.idLA = idLA;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public ListeAchete getListeAchete() {
        return listeAchete;
    }

    public void setListeAchete(ListeAchete listeAchete) {
        this.listeAchete = listeAchete;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ajouter ajouter = (Ajouter) o;
        return idPro == ajouter.idPro && idLA == ajouter.idLA && Objects.equals(produit, ajouter.produit) && Objects.equals(listeAchete, ajouter.listeAchete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPro, idLA, produit, listeAchete);
    }

    @Override
    public String toString() {
        return "Ajouter{" +
                "idPro=" + idPro +
                ", idLA=" + idLA +
                ", produit=" + produit +
                ", listeAchete=" + listeAchete +
                '}';
    }
}
