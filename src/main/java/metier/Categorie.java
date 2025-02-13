package metier;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
    public class Categorie implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "IdCtg")
        private int idCtg;
        @Column(name = "NomCtg", length = 50)
        private String nomCtg;

        @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
        private List<Produit> produits;


        // getters and setters


    public Categorie() {
    }

    public Categorie(String nomCtg, List<Produit> produits) {
        this.nomCtg = nomCtg;
        this.produits = produits;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public String getNomCtg() {
        return nomCtg;
    }

    public void setNomCtg(String nomCtg) {
        this.nomCtg = nomCtg;
    }

    public int getIdCtg() {
        return idCtg;
    }

    public void setIdCtg(int idCtg) {
        this.idCtg = idCtg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return idCtg == categorie.idCtg && Objects.equals(nomCtg, categorie.nomCtg) && Objects.equals(produits, categorie.produits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCtg, nomCtg, produits);
    }

    @Override
    public String toString() {
        return "Categorie{id=" + idCtg + ", name=" + nomCtg + ", produitsCount=" + produits.size() + "}";
    }
}


