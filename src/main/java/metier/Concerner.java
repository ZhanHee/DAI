package metier;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Concerner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPro;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idR;

    @ManyToOne
    @JoinColumn(name = "idPro", referencedColumnName = "IdPro", insertable = false, updatable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "idR", referencedColumnName = "IdR", insertable = false, updatable = false)
    private Recommandation recommandation;

    public Concerner() {
    }

    public Concerner(Recommandation recommandation, Produit produit, int idR, int idPro) {
        this.recommandation = recommandation;
        this.produit = produit;
        this.idR = idR;
        this.idPro = idPro;
    }

    // getters and setters
    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Recommandation getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(Recommandation recommandation) {
        this.recommandation = recommandation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Concerner concerner = (Concerner) o;
        return idPro == concerner.idPro && idR == concerner.idR && Objects.equals(produit, concerner.produit) && Objects.equals(recommandation, concerner.recommandation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPro, idR, produit, recommandation);
    }

    @Override
    public String toString() {
        return "Concerner{" +
                "idPro=" + idPro +
                ", idR=" + idR +
                ", produit=" + produit +
                ", recommandation=" + recommandation +
                '}';
    }
}

