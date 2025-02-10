package metier;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "NomUser", length = 50)
    private String nomUser;

    @Column(name = "PrenomUser", length = 50)
    private String prenomUser;

    @Column(name = "EmailUser", length = 50)
    private String emailUser;

    @Column(name = "MotPasse", length = 50)
    private String motPasse;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DateCreation")
    private Date dateCreation;

    @OneToOne(mappedBy = "utilisateur")
    private Administratif administratif;

    @OneToOne(mappedBy = "utilisateur")
    private Preparateur préparateur;

    @OneToOne(mappedBy = "utilisateur")
    private Client client;


    public Utilisateur() {
    }

    public Utilisateur(int idUser, String nomUser, String prenomUser, String emailUser, String motPasse, Date dateCreation) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.emailUser = emailUser;
        this.motPasse = motPasse;
        this.dateCreation = dateCreation;
    }

    // Getters and Setters

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return idUser == that.idUser && Objects.equals(nomUser, that.nomUser) && Objects.equals(prenomUser, that.prenomUser) && Objects.equals(emailUser, that.emailUser) && Objects.equals(motPasse, that.motPasse) && Objects.equals(dateCreation, that.dateCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, nomUser, prenomUser, emailUser, motPasse, dateCreation);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUser=" + idUser +
                ", nomUser='" + nomUser + '\'' +
                ", prenomUser='" + prenomUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", motPasse='" + motPasse + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
