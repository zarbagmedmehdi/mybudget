package zarbag.mybudget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.Client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Repository
public interface ClientDao   extends JpaRepository<Client,Long> {
    public Client findByEmailOrUsername(String email,String username);
    public Client findByUsername(String username);
    public Client findByToken(String token);

    public Client findByNom(String nom);
    public Client findByUsernameAndPassword(String username,String password);
    public List<Client> findAllByEnabledTrue();
    @Query(
            value = "SELECT * FROM client c WHERE u.connected=1",
            nativeQuery = true)
    List<Client> findAllActiveUsers();
}
