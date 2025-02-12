package metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Composer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPro;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPanier;

    private int quantiteP;

    @ManyToOne
    @JoinColumn(name = "idPro", referencedColumnName = "IdPro", insertable = false, updatable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "idPanier", referencedColumnName = "IdPanier", insertable = false, updatable = false)
    private Panier panier;

    public Composer() {
    }

    public Composer(int idPro, int idPanier, int quantiteP, Produit produit, Panier panier) {
        this.idPro = idPro;
        this.idPanier = idPanier;
        this.quantiteP = quantiteP;
        this.produit = produit;
        this.panier = panier;
    }

    // getters and setters
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

    public int getQuantiteP() {
        return quantiteP;
    }

    public void setQuantiteP(int quantiteP) {
        this.quantiteP = quantiteP;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
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
        Composer composer = (Composer) o;
        return idPro == composer.idPro && idPanier == composer.idPanier && Objects.equals(quantiteP, composer.quantiteP) && Objects.equals(produit, composer.produit) && Objects.equals(panier, composer.panier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPro, idPanier, quantiteP, produit, panier);
    }

    @Override
    public String toString() {
        return "Composer{" +
                "idPro=" + idPro +
                ", idPanier=" + idPanier +
                ", quantiteP='" + quantiteP + '\'' +
                ", produit=" + produit +
                ", panier=" + panier +
                '}';
    }
}

