package zarbag.mybudget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Repository
public interface UserDao   extends JpaRepository<User,Long> {
    public User findByEmailOrUsername(String email,String username);
    public User findByUsername(String username);
    public User findByNom(String nom);
    public User findByUsernameAndPassword(String username,String password);
    public List<User> findAllByEnabledTrue();
    @Query(
            value = "SELECT * FROM user u WHERE u.connected=1",
            nativeQuery = true)
    List<User> findAllActiveUsers();
}
