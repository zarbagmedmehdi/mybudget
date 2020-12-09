package zarbag.mybudget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.Beneficiaire;
import zarbag.mybudget.bean.Client;

import java.util.List;

@Repository
public interface BeneficiaireDao extends JpaRepository<Beneficiaire,Long> {
    List<Beneficiaire> findByClient(Client user);
    Beneficiaire  findById(long id);

}
