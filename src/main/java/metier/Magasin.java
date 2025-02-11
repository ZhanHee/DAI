package metier;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMag")
    private int idMag;

    @Column(name = "NomMag")
    private String nomMag;

    @Column(name = "AdresseMag")
    private String adresseMag;

    public Magasin() {
    }

    public Magasin(String nomMag, String adresseMag) {

        this.nomMag = nomMag;
        this.adresseMag = adresseMag;
    }

    // Getters and setters


    public String getAdresseMag() {
        return adresseMag;
    }

    public void setAdresseMag(String adresseMag) {
        this.adresseMag = adresseMag;
    }

    public String getNomMag() {
        return nomMag;
    }

    public void setNomMag(String nomMag) {
        this.nomMag = nomMag;
    }

    public int getIdMag() {
        return idMag;
    }

    public void setIdMag(int idMag) {
        this.idMag = idMag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Magasin magasin = (Magasin) o;
        return idMag == magasin.idMag && Objects.equals(nomMag, magasin.nomMag) && Objects.equals(adresseMag, magasin.adresseMag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMag, nomMag, adresseMag);
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "idMag=" + idMag +
                ", nomMag='" + nomMag + '\'' +
                ", adresseMag='" + adresseMag + '\'' +
                '}';
    }
}
