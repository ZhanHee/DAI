package metier;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Administratif {
    @Id
    @Column(name = "IdUser")
    private int idUser;
    @Column(name = "DateEntree")
    private Date dateEntree;
    @Column(name = "Departement", length = 50)
    private String departement;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Utilisateur utilisateur;

    public Administratif() {
    }

    public Administratif(int idUser, Date dateEntree, String departement, Utilisateur utilisateur) {
        this.idUser = idUser;
        this.dateEntree = dateEntree;
        this.departement = departement;
        this.utilisateur = utilisateur;
    }
    // getters and setters

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Administratif that = (Administratif) o;
        return idUser == that.idUser && Objects.equals(dateEntree, that.dateEntree) && Objects.equals(departement, that.departement) && Objects.equals(utilisateur, that.utilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, dateEntree, departement, utilisateur);
    }

    @Override
    public String toString() {
        return "Administratif{" +
                "idUser=" + idUser +
                ", dateEntree=" + dateEntree +
                ", departement='" + departement + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
