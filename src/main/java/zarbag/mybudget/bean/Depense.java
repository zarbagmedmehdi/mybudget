package zarbag.mybudget.bean;

import java.util.Date;
import javax.persistence.*;

@Entity

public class Depense {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String libelle;
    private String description;
    @ManyToOne
    @JoinColumn(name = "beneficiaire_id")
    private Beneficiaire beneficiaire;
    private Date dateDepense;
    @ManyToOne
    @JoinColumn(name = "groupe_depense_id")
    private Groupe groupeDepense;
    @ManyToOne
    @JoinColumn(name = "type_depense_id")
    private TypeDepense typeDepense;
    private Double valeurDepense;
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }

    public Groupe getGroupeDepense() {
        return groupeDepense;
    }

    public void setGroupeDepense(Groupe groupeDepense) {
        this.groupeDepense = groupeDepense;
    }

    public TypeDepense getTypeDepense() {
        return typeDepense;
    }

    public void setTypeDepense(TypeDepense typeDepense) {
        this.typeDepense = typeDepense;
    }

    public Double getValeurDepense() {
        return valeurDepense;
    }

    public void setValeurDepense(Double valeurDepense) {
        this.valeurDepense = valeurDepense;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
