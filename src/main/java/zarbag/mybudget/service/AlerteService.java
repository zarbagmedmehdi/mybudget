package zarbag.mybudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zarbag.mybudget.bean.Alerte;
import zarbag.mybudget.bean.Beneficiaire;
import zarbag.mybudget.bean.Client;
import zarbag.mybudget.dao.AlerteDao;
import zarbag.mybudget.dao.BeneficiaireDao;
import zarbag.mybudget.dao.ClientDao;

import javax.persistence.*;
import java.util.List;

@Service
public class AlerteService {

  @Autowired
  ClientDao clientDao;
  @Autowired
  AlerteDao alerteDao;

  public int save(Alerte g, String token){
    Client client=clientDao.findByToken(token);
    g.setClient(client);
    alerteDao.save(g);
    return 1;
  }
  public List<Alerte> findByClient(String token) {
    Client client=clientDao.findByToken(token);
    return alerteDao.findByClient(client);
  }

  public int deleteByID(long id,String token) {
    Client client=clientDao.findByToken(token);
    if(client==null) return -1;
    Alerte b=alerteDao.findById(id);
    if(b==null) return -2;
    if(b.getClient().getId()!=client.getId())
      return -3;
    alerteDao.delete(b);
    return 1;

  }

  }
