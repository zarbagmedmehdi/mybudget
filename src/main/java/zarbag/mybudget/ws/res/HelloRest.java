package zarbag.mybudget.ws.res;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import zarbag.mybudget.bean.Client;
import zarbag.mybudget.service.ClientService;
import zarbag.mybudget.z.bean.ResetPassword;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class HelloRest {

    @Autowired
    ClientService clientService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }


    @GetMapping("/token")
    public Client findByToken( ) {
        String token=request.getHeader(AUTHORIZATION);
        token= StringUtils.removeStart(token, "Bearer").trim();
        return clientService.findNameByToken(token);
    }
    @PostMapping("/profile")
    public int updateProfile( @RequestBody Client user) {
      return clientService.update(user);
    }
    @PostMapping("/password")
    public int changePassword(@RequestBody ResetPassword rs) {
        return clientService.changePassword(rs);
    }



    @GetMapping("/connected")
    public List<Client> findConnected() {
        return clientService.FindConnected();
    }

    @GetMapping("/username-or-email/{username}/{email}")
    public Client findByEmailOrUsername(@PathVariable String username, @PathVariable String email) {
        return clientService.findByEmailOrUsername(username, email);
    }

    @GetMapping("/username/{username}/")
    public Client findByUsername(@PathVariable String username) {
        return clientService.findByUsername(username);
    }

    @PostMapping("/signout")
    public int signout(@RequestBody Client user) {
        return clientService.signout(user.getUsername(), user.getPassword());
    }

    @PutMapping("/disable/{username}")
    public int disableUser(@PathVariable String username) {
        return clientService.disableUser(username);
    }


    @DeleteMapping("/delete/{username}/")
    public int delete(String userName) {
        return clientService.delete(userName);
    }

}
