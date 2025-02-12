package metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Table(name = "retirer")
public class Retirer implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "IdMag")
    private Magasin magasin;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdCom")
    private Commande commande;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdUser")
    private Client client;

    @Column(name = "CreneauRetrait")
    private String creneauRetrait;

    public Retirer() {
    }

    public Retirer(Magasin magasin, Commande commande, Client client, String creneauRetrait) {
        this.magasin = magasin;
        this.commande = commande;
        this.client = client;
        this.creneauRetrait = creneauRetrait;
    }
    // Getters and Setters

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCreneauRetrait() {
        return creneauRetrait;
    }

    public void setCreneauRetrait(String creneauRetrait) {
        this.creneauRetrait = creneauRetrait;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Retirer retirer = (Retirer) o;
        return Objects.equals(magasin, retirer.magasin) && Objects.equals(commande, retirer.commande) && Objects.equals(client, retirer.client) && Objects.equals(creneauRetrait, retirer.creneauRetrait);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magasin, commande, client, creneauRetrait);
    }

    @Override
    public String toString() {
        return "Retirer{" +
                "magasin=" + magasin +
                ", commande=" + commande +
                ", client=" + client +
                ", creneauRetrait='" + creneauRetrait + '\'' +
                '}';
    }
}
