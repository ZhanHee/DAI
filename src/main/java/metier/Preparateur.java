package metier;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Preparateur implements Serializable {
    @Id
    @Column(name = "IdUser")
    private int idUser;
    @Column(name = "Matricule", length = 50)
    private String matricule;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Utilisateur utilisateur;

    public Preparateur() {
    }

    public Preparateur(int idUser, String matricule, Utilisateur utilisateur) {
        this.idUser = idUser;
        this.matricule = matricule;
        this.utilisateur = utilisateur;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
        Preparateur that = (Preparateur) o;
        return idUser == that.idUser && Objects.equals(matricule, that.matricule) && Objects.equals(utilisateur, that.utilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, matricule, utilisateur);
    }

    @Override
    public String toString() {
        return "Preparateur{" +
                "idUser=" + idUser +
                ", matricule='" + matricule + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
