package zarbag.mybudget.bean;
import javax.persistence.*;

@Entity

public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nom ;
    private String codeBarre;
    @ManyToOne
    @JoinColumn(name = "type_produit_id")
    private TypeProduit typeProduit;

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

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit = typeProduit;
    }
}
