package zarbag.mybudget.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.TypeProduit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Repository
public interface TypeProduitDao extends JpaRepository<TypeProduit,Long> {


}
