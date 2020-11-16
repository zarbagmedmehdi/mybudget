package zarbag.mybudget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.Credit;


@Repository
public interface CreditDao extends JpaRepository<Credit,Long> {

}
