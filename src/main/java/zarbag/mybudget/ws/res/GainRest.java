package zarbag.mybudget.ws.res;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zarbag.mybudget.bean.Gain;
import zarbag.mybudget.bean.Groupe;
import zarbag.mybudget.service.GainService;
import zarbag.mybudget.z.bean.Pourcentage;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/gain")
@CrossOrigin(origins = "http://localhost:4200")
public class GainRest {
    @Autowired
    HttpServletRequest request;

    @Autowired
    GainService gainService;
    @PostMapping("/")
    public int getToken(@RequestBody Gain gain){
        String token=request.getHeader(AUTHORIZATION);
        token= StringUtils.removeStart(token, "Bearer").trim();
        return  gainService.save(gain,token);
    }
    @GetMapping("/")
    public List<Gain> getMyGains(){
        String token=request.getHeader(AUTHORIZATION);
        token= StringUtils.removeStart(token, "Bearer").trim();
        return  gainService.findByUser(token);
    }
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable long id){
        String token=request.getHeader(AUTHORIZATION);
        token= StringUtils.removeStart(token, "Bearer").trim();
        return  gainService.deleteByID(id,token);
    }
    @GetMapping("/pourcentage1")
    List<Pourcentage> pourcentageGainByGroupe(){
        String token=request.getHeader(AUTHORIZATION);
        token= StringUtils.removeStart(token, "Bearer").trim();
        return  this.gainService.pourcentageGainByGroupe(token);
    }
    @GetMapping("/pourcentage2")
    List<Pourcentage> pourcentageGainByDonnateur(){
        String token=request.getHeader(AUTHORIZATION);
        token= StringUtils.removeStart(token, "Bearer").trim();
        return  this.gainService.pourcentageGainByDonnateur(token);
    }
    @GetMapping("/cc/cc")
    public int save() {
        List<Date> dateList=new ArrayList<>();


        for(int i=0;i<10;i++) {
            dateList.add(new Date("23/11/2019"));
            Gain g = new Gain();
            g.setLibelle("libelle"+i);
            g.setDescription("description"+i);
            g.setDonnateur("Donnateur"+i);
            g.setValeurGain(new Double(i*1000+2*i));
            g.setDateGain(dateList.get(0));
            gainService.savew(g);
        }
        return 1;
    }
}
