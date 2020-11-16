package zarbag.mybudget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.Beneficiaire;

@Repository
public interface BeneficiaireDao extends JpaRepository<Beneficiaire,Long> {
}
