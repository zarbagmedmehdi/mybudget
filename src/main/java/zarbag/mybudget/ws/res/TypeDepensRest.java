package zarbag.mybudget.ws.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zarbag.mybudget.bean.TypeDepense;
import zarbag.mybudget.dao.TypeDepenseDao;
import zarbag.mybudget.service.TypeDepenseService;

import java.util.List;
@RequestMapping("/typedepense")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TypeDepensRest {


    @Autowired
    TypeDepenseService typeDepenseService;
    @GetMapping("/")
    public List<TypeDepense> findAll() {
        return typeDepenseService.findAll();
    }
}
