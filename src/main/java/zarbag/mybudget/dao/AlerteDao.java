package zarbag.mybudget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.Alerte;
import zarbag.mybudget.bean.Beneficiaire;
import zarbag.mybudget.bean.Client;

import java.util.List;

@Repository
public interface AlerteDao extends JpaRepository<Alerte,Long> {
    List<Alerte> findByClient(Client user);
    Alerte  findById(long id);
}
