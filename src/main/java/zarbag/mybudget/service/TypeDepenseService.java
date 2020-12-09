package zarbag.mybudget.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zarbag.mybudget.bean.Client;
import zarbag.mybudget.bean.Gain;
import zarbag.mybudget.bean.TypeDepense;
import zarbag.mybudget.dao.ClientDao;
import zarbag.mybudget.dao.TypeDepenseDao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Service
public class TypeDepenseService {

    @Autowired
    TypeDepenseDao typeDepenseDao;

    public List<TypeDepense> findAll() {
        return typeDepenseDao.findAll();
    }
}
