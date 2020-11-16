package zarbag.mybudget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.Alerte;

@Repository
public interface AlerteDao extends JpaRepository<Alerte,Long> {
}
