package metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Produit")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPro")
    private int idPro;

    @Column(name = "LibellePro")
    private String libellePro;

    @Column(name = "DescriptionP")
    private String descriptionP;

    @Column(name = "PrixUnitaire")
    private double prixUnitaire;

    @Column(name = "PrixAuKg")
    private double prixAuKg;

    @Column(name = "NutrisScore")
    private String nutrisScore;

    @Column(name = "Poids")
    private int poids;

    @Column(name = "Condionnement")
    private String conditionnement;

    @Column(name = "Bio")
    private boolean bio;

    @Column(name = "Marque")
    private String marque;

    @Column(name = "ImageURL")
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "IdCtg")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Promotion> promotions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ajouter",
            joinColumns = @JoinColumn(name = "IdPro"),
            inverseJoinColumns = @JoinColumn(name = "IdLA")
    )
    private Set<ListeAchete> listeAchetes = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "concerner",
            joinColumns = @JoinColumn(name = "IdPro"),
            inverseJoinColumns = @JoinColumn(name = "IdR")
    )
    private Set<Recommandation> recommandations = new HashSet<>();


    public Produit() {
    }

    public Produit(Categorie categorie, String imageURL, String marque, boolean bio, String conditionnement, int poids, String nutrisScore, double prixAuKg, double prixUnitaire, String descriptionP, String libellePro, int idPro) {
        this.categorie = categorie;
        this.imageURL = imageURL;
        this.marque = marque;
        this.bio = bio;
        this.conditionnement = conditionnement;
        this.poids = poids;
        this.nutrisScore = nutrisScore;
        this.prixAuKg = prixAuKg;
        this.prixUnitaire = prixUnitaire;
        this.descriptionP = descriptionP;
        this.libellePro = libellePro;
        this.idPro = idPro;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getLibellePro() {
        return libellePro;
    }

    public void setLibellePro(String libellePro) {
        this.libellePro = libellePro;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setDescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixAuKg() {
        return prixAuKg;
    }

    public void setPrixAuKg(double prixAuKg) {
        this.prixAuKg = prixAuKg;
    }

    public String getNutrisScore() {
        return nutrisScore;
    }

    public void setNutrisScore(String nutrisScore) {
        this.nutrisScore = nutrisScore;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(String conditionnement) {
        this.conditionnement = conditionnement;
    }

    public boolean isBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Set<ListeAchete> getListeAchetes() {
        return listeAchetes;
    }

    public void setListeAchetes(Set<ListeAchete> listeAchetes) {
        this.listeAchetes = listeAchetes;
    }

    public Set<Recommandation> getRecommandations() {
        return recommandations;
    }

    public void setRecommandations(Set<Recommandation> recommandations) {
        this.recommandations = recommandations;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return idPro == produit.idPro && Double.compare(prixUnitaire, produit.prixUnitaire) == 0 && Double.compare(prixAuKg, produit.prixAuKg) == 0 && poids == produit.poids && bio == produit.bio && Objects.equals(libellePro, produit.libellePro) && Objects.equals(descriptionP, produit.descriptionP) && Objects.equals(nutrisScore, produit.nutrisScore) && Objects.equals(conditionnement, produit.conditionnement) && Objects.equals(marque, produit.marque) && Objects.equals(imageURL, produit.imageURL) && Objects.equals(categorie, produit.categorie) && Objects.equals(promotions, produit.promotions) && Objects.equals(listeAchetes, produit.listeAchetes) && Objects.equals(recommandations, produit.recommandations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPro, libellePro, descriptionP, prixUnitaire, prixAuKg, nutrisScore, poids, conditionnement, bio, marque, imageURL, categorie, promotions, listeAchetes, recommandations);
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idPro=" + idPro +
                ", libellePro='" + libellePro + '\'' +
                ", descriptionP='" + descriptionP + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", prixAuKg=" + prixAuKg +
                ", nutrisScore='" + nutrisScore + '\'' +
                ", poids=" + poids +
                ", conditionnement='" + conditionnement + '\'' +
                ", bio=" + bio +
                ", marque='" + marque + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", categorie=" + categorie +
                ", promotions=" + promotions +
                ", listeAchetes=" + listeAchetes +
                ", recommandations=" + recommandations +
                '}';
    }
}
