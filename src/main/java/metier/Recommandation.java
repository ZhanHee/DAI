package metier;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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


    @ManyToMany(mappedBy = "recommandations")  // 指定被关联
    private Set<Client> clients = new HashSet<>();
    public Recommandation() {
    }

    @ManyToMany(mappedBy = "recommandations")  // 指定被关联
    private Set<Produit> produits = new HashSet<>();

    public Recommandation(String raison) {
        this.raison = raison;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recommandation that = (Recommandation) o;
        return idR == that.idR && Objects.equals(raison, that.raison) && Objects.equals(concerners, that.concerners) && Objects.equals(clients, that.clients) && Objects.equals(produits, that.produits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idR, raison, concerners, clients, produits);
    }
}
