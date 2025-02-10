package metier;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "ProfilConsommateur")
public class ProfilConsommateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPC")
    private int idPC;

    @Column(name = "BioPrefer")
    private boolean bioPrefer;

    @Column(name = "NutrisScorePrefer")
    private String nutrisScorePrefer;

    @Column(name = "MarquePrefer")
    private String marquePrefer;

    @Column(name = "CategoriePrefer")
    private String categoriePrefer;

    public ProfilConsommateur() {
    }

    public ProfilConsommateur(int idPC, boolean bioPrefer, String nutrisScorePrefer, String marquePrefer, String categoriePrefer) {
        this.idPC = idPC;
        this.bioPrefer = bioPrefer;
        this.nutrisScorePrefer = nutrisScorePrefer;
        this.marquePrefer = marquePrefer;
        this.categoriePrefer = categoriePrefer;
    }
    // Getters and Setters


    public int getIdPC() {
        return idPC;
    }

    public void setIdPC(int idPC) {
        this.idPC = idPC;
    }

    public boolean isBioPrefer() {
        return bioPrefer;
    }

    public void setBioPrefer(boolean bioPrefer) {
        this.bioPrefer = bioPrefer;
    }

    public String getNutrisScorePrefer() {
        return nutrisScorePrefer;
    }

    public void setNutrisScorePrefer(String nutrisScorePrefer) {
        this.nutrisScorePrefer = nutrisScorePrefer;
    }

    public String getMarquePrefer() {
        return marquePrefer;
    }

    public void setMarquePrefer(String marquePrefer) {
        this.marquePrefer = marquePrefer;
    }

    public String getCategoriePrefer() {
        return categoriePrefer;
    }

    public void setCategoriePrefer(String categoriePrefer) {
        this.categoriePrefer = categoriePrefer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProfilConsommateur that = (ProfilConsommateur) o;
        return idPC == that.idPC && bioPrefer == that.bioPrefer && Objects.equals(nutrisScorePrefer, that.nutrisScorePrefer) && Objects.equals(marquePrefer, that.marquePrefer) && Objects.equals(categoriePrefer, that.categoriePrefer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPC, bioPrefer, nutrisScorePrefer, marquePrefer, categoriePrefer);
    }

    @Override
    public String toString() {
        return "ProfilConsommateur{" +
                "idPC=" + idPC +
                ", bioPrefer=" + bioPrefer +
                ", nutrisScorePrefer='" + nutrisScorePrefer + '\'' +
                ", marquePrefer='" + marquePrefer + '\'' +
                ", categoriePrefer='" + categoriePrefer + '\'' +
                '}';
    }
}
