package metier;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Commande")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCom")
    private int idCom;

    @Column(name = "StatutCom")
    private String statutCom;

    @Column(name = "DateCom")
    private Date dateCom;

    @Column(name = "PrioriteCom")
    private int prioriteCom;

    @ManyToOne
    @JoinColumn(name = "IdPanier")
    private Panier panier;

    @ManyToOne
    @JoinColumn(name = "IdUser")
    private Client client;

    // Getters and Setters

    public Commande() {
    }

    public Commande(String statutCom, Date dateCom, int prioriteCom, Panier panier, Client client) {
        this.statutCom = statutCom;
        this.dateCom = dateCom;
        this.prioriteCom = prioriteCom;
        this.panier = panier;
        this.client = client;
    }

    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public String getStatutCom() {
        return statutCom;
    }

    public void setStatutCom(String statutCom) {
        this.statutCom = statutCom;
    }

    public Date getDateCom() {
        return dateCom;
    }

    public void setDateCom(Date dateCom) {
        this.dateCom = dateCom;
    }

    public int getPrioriteCom() {
        return prioriteCom;
    }

    public void setPrioriteCom(int prioriteCom) {
        this.prioriteCom = prioriteCom;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
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
        Commande commande = (Commande) o;
        return idCom == commande.idCom && prioriteCom == commande.prioriteCom && Objects.equals(statutCom, commande.statutCom) && Objects.equals(dateCom, commande.dateCom) && Objects.equals(panier, commande.panier) && Objects.equals(client, commande.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCom, statutCom, dateCom, prioriteCom, panier, client);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCom=" + idCom +
                ", statutCom='" + statutCom + '\'' +
                ", dateCom=" + dateCom +
                ", prioriteCom=" + prioriteCom +
                ", panier=" + panier +
                ", client=" + client +
                '}';
    }
}

