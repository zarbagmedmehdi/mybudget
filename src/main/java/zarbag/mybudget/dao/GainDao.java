package zarbag.mybudget.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zarbag.mybudget.bean.Client;
import zarbag.mybudget.bean.Gain;
import zarbag.mybudget.bean.Groupe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


@Repository
public interface GainDao extends JpaRepository<Gain,Long> {

    public List<Gain> findByClientOrderByDateGainDesc(Client Client);
    public List<Gain> findByDonnateur(String  donnateur);
    @Query("SELECT DISTINCT g.donnateur FROM Gain g where g.client= (:client) ")
    List<String> findDistinctDonnateur(@Param("client")Client client);

    //  public List<Gain> findByClientAndGroupeGainOrderByDateGainDesc(Client Client, Groupe g);
    public List<Gain> findByGroupeGain( Groupe g);

    public Gain findById(long id);

}
