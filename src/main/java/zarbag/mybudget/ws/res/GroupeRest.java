package zarbag.mybudget.ws.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zarbag.mybudget.bean.Groupe;
import zarbag.mybudget.bean.TypeDepense;
import zarbag.mybudget.service.GroupeService;
import zarbag.mybudget.service.TypeDepenseService;

import java.util.List;
@RequestMapping("/groupe")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GroupeRest {

        @Autowired
        GroupeService groupeService;
        @GetMapping("/")
        public List<Groupe> findAll() {
            return groupeService.findAll();
        }

}
