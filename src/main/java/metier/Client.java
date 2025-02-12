package metier;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Client")
public class Client implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "IdUser")
    private Utilisateur utilisateur;

    @Column(name = "TelCli")
    private String telCli;

    @Column(name = "AdresseCli")
    private String adresseCli;

    @ManyToOne
    @JoinColumn(name = "IdPC")
    private ProfilConsommateur profilConsommateur;

    // Getters and Setters

    public Client() {
    }

    public Client(Utilisateur utilisateur, String telCli, String adresseCli, ProfilConsommateur profilConsommateur) {
        this.utilisateur = utilisateur;
        this.telCli = telCli;
        this.adresseCli = adresseCli;
        this.profilConsommateur = profilConsommateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getTelCli() {
        return telCli;
    }

    public void setTelCli(String telCli) {
        this.telCli = telCli;
    }

    public String getAdresseCli() {
        return adresseCli;
    }

    public void setAdresseCli(String adresseCli) {
        this.adresseCli = adresseCli;
    }

    public ProfilConsommateur getProfilConsommateur() {
        return profilConsommateur;
    }

    public void setProfilConsommateur(ProfilConsommateur profilConsommateur) {
        this.profilConsommateur = profilConsommateur;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(utilisateur, client.utilisateur) && Objects.equals(telCli, client.telCli) && Objects.equals(adresseCli, client.adresseCli) && Objects.equals(profilConsommateur, client.profilConsommateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur, telCli, adresseCli, profilConsommateur);
    }

    @Override
    public String toString() {
        return "Client{" +
                "utilisateur=" + utilisateur +
                ", telCli='" + telCli + '\'' +
                ", adresseCli='" + adresseCli + '\'' +
                ", profilConsommateur=" + profilConsommateur +
                '}';
    }
}
