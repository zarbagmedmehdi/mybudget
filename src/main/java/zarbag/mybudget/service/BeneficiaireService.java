package zarbag.mybudget.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zarbag.mybudget.bean.Beneficiaire;
import zarbag.mybudget.bean.Client;
import zarbag.mybudget.bean.Gain;
import zarbag.mybudget.dao.BeneficiaireDao;
import zarbag.mybudget.dao.ClientDao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Service

public class BeneficiaireService {
  @Autowired
  ClientDao clientDao;
  @Autowired
  BeneficiaireDao beneficiaireDao;

  public int save(Beneficiaire g, String token){
    Client client=clientDao.findByToken(token);
    g.setClient(client);
    beneficiaireDao.save(g);
    return 1;
  }

  public List<Beneficiaire> findByClient(String token) {
    Client client=clientDao.findByToken(token);
    return beneficiaireDao.findByClient(client);
  }

  public int deleteByID(long id,String token) {
    Client client=clientDao.findByToken(token);
    if(client==null) return -1;
     Beneficiaire b=beneficiaireDao.findById(id);
    if(b==null) return -2;
    if(b.getClient().getId()!=client.getId())
      return -3;
      beneficiaireDao.delete(b);
      return 1;

  }

  }

