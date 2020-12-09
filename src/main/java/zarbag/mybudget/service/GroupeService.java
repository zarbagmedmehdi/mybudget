package zarbag.mybudget.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zarbag.mybudget.bean.Groupe;
import zarbag.mybudget.bean.TypeDepense;
import zarbag.mybudget.dao.GroupeDao;
import zarbag.mybudget.dao.TypeDepenseDao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Service
public class GroupeService {
    @Autowired
    GroupeDao groupeDea;

    public List<Groupe> findAll() {
        return groupeDea.findAll();
    }
}
