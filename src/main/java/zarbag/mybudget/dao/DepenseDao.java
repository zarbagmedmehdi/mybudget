package zarbag.mybudget.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.Beneficiaire;
import zarbag.mybudget.bean.Depense;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Repository
public interface DepenseDao extends JpaRepository<Depense,Long> {

}
