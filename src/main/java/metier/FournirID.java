package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class FournirID implements Serializable {

    @Column(name = "IdPro")
    private int idPro;

    @Column(name = "IdMag")
    private int idMag;

    public FournirID() {}

    public FournirID(int idPro, int idMag) {
        this.idPro = idPro;
        this.idMag = idMag;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdMag() {
        return idMag;
    }

    public void setIdMag(int idMag) {
        this.idMag = idMag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FournirID that = (FournirID) o;
        return idPro == that.idPro && idMag == that.idMag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPro, idMag);
    }
}

