package zarbag.mybudget.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity

public class Client implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    @NotBlank(message = "username is obligatory")
    private String username ;
    @NotBlank(message = "password is obligatory")
    private String password;
    @NotBlank(message = "email is obligatory")
    private String email;
    private int nbTentifRest;
    private Boolean enabled;
    private String token;
    private String devise ;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Client() {

    }

    public Client(String nom) {
        this.nom = nom;
    }

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNbTentifRest() {
        return nbTentifRest;
    }

    public void setNbTentifRest(int nbTentifRest) {
        this.nbTentifRest = nbTentifRest;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                // "id=" + id +
                ", nom='" + nom + '\'' +
                //", username='" + username + '\'' +
                //  ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", nbTentifRest=" + nbTentifRest +
                ", enabled=" + enabled +
              //  ", token='" + token + '\'' +
                ", devise='" + devise + '\'' +
                '}';
    }
}
