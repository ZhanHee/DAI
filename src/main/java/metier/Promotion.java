package metier;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPromo")
    private int idPromo;

    @Column(name = "TypePromo")
    private String typePromo;

    @Column(name = "ValeurPromo")
    private String valeurPromo;

    @Column(name = "DateDebut")
    private Date dateDebut;

    @Column(name = "DateFin")
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "IdPro")
    private Produit produit;

    // Getters and Setters


    public Promotion() {
    }

    public Promotion(int idPromo, String typePromo, String valeurPromo, Date dateDebut, Date dateFin, Produit produit) {
        this.idPromo = idPromo;
        this.typePromo = typePromo;
        this.valeurPromo = valeurPromo;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.produit = produit;
    }

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public String getTypePromo() {
        return typePromo;
    }

    public void setTypePromo(String typePromo) {
        this.typePromo = typePromo;
    }

    public String getValeurPromo() {
        return valeurPromo;
    }

    public void setValeurPromo(String valeurPromo) {
        this.valeurPromo = valeurPromo;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return idPromo == promotion.idPromo && Objects.equals(typePromo, promotion.typePromo) && Objects.equals(valeurPromo, promotion.valeurPromo) && Objects.equals(dateDebut, promotion.dateDebut) && Objects.equals(dateFin, promotion.dateFin) && Objects.equals(produit, promotion.produit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPromo, typePromo, valeurPromo, dateDebut, dateFin, produit);
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "idPromo=" + idPromo +
                ", typePromo='" + typePromo + '\'' +
                ", valeurPromo='" + valeurPromo + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", produit=" + produit +
                '}';
    }
}