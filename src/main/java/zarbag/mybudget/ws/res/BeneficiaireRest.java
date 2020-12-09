package zarbag.mybudget.ws.res;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zarbag.mybudget.bean.Beneficiaire;
import zarbag.mybudget.service.BeneficiaireService;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
@RestController
@RequestMapping("/beneficiaire")
@CrossOrigin(origins = "http://localhost:4200")
public class BeneficiaireRest {

        @Autowired
        HttpServletRequest request;

        @Autowired
        BeneficiaireService beneficiaireService;
    @PostMapping("/")
        public int saveBeneficiaire(@RequestBody Beneficiaire ben){
            String token=request.getHeader(AUTHORIZATION);
            token= StringUtils.removeStart(token, "Bearer").trim();
            return  beneficiaireService.save(ben,token);
        }
    @GetMapping("/")
    public List<Beneficiaire> getByClient(){
        String token=request.getHeader(AUTHORIZATION);
        token= StringUtils.removeStart(token, "Bearer").trim();
        return  beneficiaireService.findByClient(token);
    }
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable long id){
        String token=request.getHeader(AUTHORIZATION);
        token= StringUtils.removeStart(token, "Bearer").trim();
        return  beneficiaireService.deleteByID(id,token);
    }


}
