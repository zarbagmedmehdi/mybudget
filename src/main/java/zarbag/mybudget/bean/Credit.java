package zarbag.mybudget.bean;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Credit {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String libelle;
    private String description;
    private String banque;
    private Date  dateDebut;
    private Date  dateFin;
    private int   jourPrélevement;
    private Double mensualite;
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

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
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

    public int getJourPrélevement() {
        return jourPrélevement;
    }

    public void setJourPrélevement(int jourPrélevement) {
        this.jourPrélevement = jourPrélevement;
    }

    public Double getMensualite() {
        return mensualite;
    }

    public void setMensualite(Double mensualite) {
        this.mensualite = mensualite;
    }
}
