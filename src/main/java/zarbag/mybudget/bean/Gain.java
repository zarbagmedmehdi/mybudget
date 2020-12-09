package zarbag.mybudget.bean;


import java.util.Date;

import javax.persistence.*;

@Entity

public class Gain {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String libelle;
    private String description;
    private String donnateur;
    private Date dateGain;
    @ManyToOne
    private Groupe groupeGain;
    private Double valeurGain;
    @ManyToOne
    private Client client;
    private int mois;
    private int annee;
    private int jour;

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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

    public String getDonnateur() {
        return donnateur;
    }

    public void setDonnateur(String donnateur) {
        this.donnateur = donnateur;
    }

    public Date getDateGain() {
        return dateGain;
    }

    public void setDateGain(Date dateGain) {
        this.dateGain = dateGain;
    }

    public Groupe getGroupeGain() {
        return groupeGain;
    }

    public void setGroupeGain(Groupe groupeGain) {
        this.groupeGain = groupeGain;
    }

    public Double getValeurGain() {
        return valeurGain;
    }

    public void setValeurGain(Double valeurGain) {
        this.valeurGain = valeurGain;
    }
}
