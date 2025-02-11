import metier.FournirID;

import metier.Magasin;
import metier.Produit;

import javax.persistence.*;

@Entity
@Table(name = "founir")
public class Fournir {

    @EmbeddedId
    private FournirID id;

    @ManyToOne
    @MapsId("idPro")
    @JoinColumn(name = "IdPro")
    private Produit produit;

    @ManyToOne
    @MapsId("idMag")
    @JoinColumn(name = "IdMag")
    private Magasin magasin;

    @Column(name = "QuantiteStock")
    private String quantiteStock;

    public Fournir() {}

    public FournirID getId() {
        return id;
    }

    public void setId(FournirID id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public String getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(String quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
}
