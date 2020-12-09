package zarbag.mybudget.service;


import org.dom4j.util.UserDataAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zarbag.mybudget.bean.Beneficiaire;
import zarbag.mybudget.bean.Client;
import zarbag.mybudget.bean.Gain;
import zarbag.mybudget.bean.Groupe;
import zarbag.mybudget.dao.ClientDao;
import zarbag.mybudget.dao.GainDao;
import zarbag.mybudget.z.bean.Pourcentage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GainService {
   @Autowired
   GainDao gainDao;
   @Autowired
   ClientDao clientDao;
   @Autowired
   GroupeService groupeService;
   public int save(Gain g,String token){
      Client client=clientDao.findByToken(token);
      g.setClient(client);
      Calendar c = Calendar.getInstance();
      c.setTime(g.getDateGain());
      g.setAnnee(c.get(Calendar.YEAR));
      g.setMois(c.get(Calendar.MONTH)+1);
      g.setJour(c.get(Calendar.DAY_OF_MONTH));
      gainDao.save(g);
      return 1;
   }
   public int savew(Gain g){

      gainDao.save(g);
      return 1;
   }


   public List<Gain> findByUser(String token) {
      Client client=clientDao.findByToken(token);

      return gainDao.findByClientOrderByDateGainDesc(client);
   }

   public List<Pourcentage> pourcentageGainByGroupe(String token)
   {
      List<Pourcentage> pourcentages=new ArrayList<>();
      Client client=clientDao.findByToken(token);
      List<Groupe> grps= groupeService.findAll();
      List<Gain> allGains=gainDao.findByClientOrderByDateGainDesc(client);
      double allValeur=getAllValeur(allGains);
      System.out.println(allValeur);
      if(allValeur!=0){
      for(int i=0;i<grps.size();i++){
         double valeur=getAllValeur(gainDao.findByGroupeGain(grps.get(i)))/allValeur;
         Pourcentage p=new Pourcentage(valeur,grps.get(i).getDuree());
         pourcentages.add(p);
      } }
      return pourcentages;
   }

   public List<Pourcentage> pourcentageGainByDonnateur(String token)
   {
      List<Pourcentage> pourcentages=new ArrayList<>();
      Client client=clientDao.findByToken(token);

      List<String> donnateurs= gainDao.findDistinctDonnateur(client);
      List<Gain> allGains=gainDao.findByClientOrderByDateGainDesc(client);
      double allValeur=getAllValeur(allGains);
      if(allValeur!=0){
         for(int i=0;i<donnateurs.size();i++){
            double valeur=getAllValeur(gainDao.findByDonnateur(donnateurs.get(i)))/allValeur;
            Pourcentage p=new Pourcentage(valeur,donnateurs.get(i));
            pourcentages.add(p);
         } }
      return pourcentages;
   }

   public Double getAllValeur(  List<Gain> allGains){
      Double all= Double.valueOf(0);
      for(int i=0;i<allGains.size();i++){
         all+=allGains.get(i).getValeurGain();
      }
      return  all;
   }
   public int deleteByID(long id, String token) {
      Client client=clientDao.findByToken(token);
      if(client==null) return -1;
      Gain b=gainDao.findById(id);
      if(b==null) return -2;
      if(b.getClient().getId()!=client.getId())
         return -3;
      gainDao.delete(b);
      return 1;

   }
}
