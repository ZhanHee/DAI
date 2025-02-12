package metier;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class RetraitId implements Serializable {

    @Column(name = "IdMag")
    private int idMag;

    @Column(name = "IdCom")
    private int idCom;

    @Column(name = "IdUser")
    private int idUser;

    // Default constructor
    public RetraitId() {}

    // Constructor with parameters
    public RetraitId(int idMag, int idCom, int idUser) {
        this.idMag = idMag;
        this.idCom = idCom;
        this.idUser = idUser;
    }

    // Getters and Setters
    public int getIdMag() {
        return idMag;
    }

    public void setIdMag(int idMag) {
        this.idMag = idMag;
    }

    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    // Overriding equals and hashCode methods to compare objects properly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetraitId retraitId = (RetraitId) o;
        return idMag == retraitId.idMag && idCom == retraitId.idCom && idUser == retraitId.idUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMag, idCom, idUser);
    }

    @Override
    public String toString() {
        return "RetraitId{" +
                "idMag=" + idMag +
                ", idCom=" + idCom +
                ", idUser=" + idUser +
                '}';
    }
}
