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
    @JoinColumn(name = "groupe_gain_id")
    private Groupe groupeGain;
    private Double valeurGain;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
