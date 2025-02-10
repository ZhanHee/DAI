package metier;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "Panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPanier")
    private int idPanier;

    @Column(name = "Statut")
    private String statut;

    @Column(name = "PrixTotal")
    private double prixTotal;

    @ManyToOne
    @JoinColumn(name = "IdUser")
    private Client client;

    // Getters and Setters

    public Panier() {
    }

    public Panier(int idPanier, String statut, double prixTotal, Client client) {
        this.idPanier = idPanier;
        this.statut = statut;
        this.prixTotal = prixTotal;
        this.client = client;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Panier panier = (Panier) o;
        return idPanier == panier.idPanier && Double.compare(prixTotal, panier.prixTotal) == 0 && Objects.equals(statut, panier.statut) && Objects.equals(client, panier.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPanier, statut, prixTotal, client);
    }

    @Override
    public String toString() {
        return "Panier{" +
                "idPanier=" + idPanier +
                ", statut='" + statut + '\'' +
                ", prixTotal=" + prixTotal +
                ", client=" + client +
                '}';
    }
}
