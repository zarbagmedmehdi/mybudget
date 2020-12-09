package zarbag.mybudget.ws.res;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zarbag.mybudget.bean.Alerte;
import zarbag.mybudget.bean.Beneficiaire;
import zarbag.mybudget.service.AlerteService;
import zarbag.mybudget.service.BeneficiaireService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequestMapping("/alerte")
@CrossOrigin(origins = "http://localhost:4200")
public class AlerteRest {
        @Autowired
        HttpServletRequest request;

        @Autowired
        AlerteService alerteService;
        @PostMapping("/")
        public int saveBeneficiaire(@RequestBody Alerte alerte){
            String token=request.getHeader(AUTHORIZATION);
            token= StringUtils.removeStart(token, "Bearer").trim();
            return  alerteService.save(alerte,token);
        }
        @GetMapping("/")
        public List<Alerte> getByClient(){
            String token=request.getHeader(AUTHORIZATION);
            token= StringUtils.removeStart(token, "Bearer").trim();
            return  alerteService.findByClient(token);
        }
        @DeleteMapping("/{id}")
        public int deleteById(@PathVariable long id){
            String token=request.getHeader(AUTHORIZATION);
            token= StringUtils.removeStart(token, "Bearer").trim();
            return  alerteService.deleteByID(id,token);
        }
}
