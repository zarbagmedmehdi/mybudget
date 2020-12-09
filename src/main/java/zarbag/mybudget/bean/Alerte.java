package zarbag.mybudget.bean;
import javax.persistence.*;

@Entity
public class Alerte {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nom;
    private String description;
    private Double seuilMensuel;
    private boolean isGlobal;
    @ManyToOne
    private TypeDepense typeDepense;
    @ManyToOne
    private Client client;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSeuilMensuel() {
        return seuilMensuel;
    }

    public void setSeuilMensuel(Double seuilMensuel) {
        this.seuilMensuel = seuilMensuel;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setGlobal(boolean global) {
        isGlobal = global;
    }

    public TypeDepense getTypeDepense() {
        return typeDepense;
    }

    public void setTypeDepense(TypeDepense typeDepense) {
        this.typeDepense = typeDepense;
    }
}
