package zarbag.mybudget.ws.res;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zarbag.mybudget.bean.Client;
import zarbag.mybudget.service.ClientService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginRest {

    @Autowired
    ClientService clientService;
    @PostMapping("/login")
    public String getToken(@RequestBody Client client){
        String token= clientService.login(client.getUsername(),client.getPassword());
        if(StringUtils.isEmpty(token)){
            return "-1";
        }
        return token;
    }
    @PostMapping("/signup")
    public int signup(@RequestBody  Client client) {

        return clientService.save(client);
    }






}
