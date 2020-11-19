package zarbag.mybudget.ws.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import zarbag.mybudget.bean.AuthentificationResponse;
import zarbag.mybudget.bean.User;
import zarbag.mybudget.security.Util;
import zarbag.mybudget.service.MyUserDetailsService;
import zarbag.mybudget.service.UserService;

import java.util.List;

public class HelloRest {

    @Autowired
    UserService userService;
   /* @RequestMapping({"/hello"})
    public String hello(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return "hello"+currentPrincipalName;


    }

    @PostMapping(value="/authenticate")
    public ResponseEntity<?> createAuthentifcationToken(@RequestBody User user)throws Exception{
        System.out.println("cc"+user);
        String jwt=userService.login(user.getUsername(),user.getPassword());
        return  ResponseEntity.ok(new AuthentificationResponse(jwt));
    }
    @PostMapping("/signup")
    public int signup(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/connected")
    public List<User> findConnected() {
        return userService.FindConnected();
    }

    @GetMapping("/byusernameoremail/{username}/{email}")
    public User findByEmailOrUsername(@PathVariable String username, @PathVariable String email) {
        return userService.findByEmailOrUsername(username, email);
    }

    @GetMapping("/byusername/{username}/")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/signout")
    public int signout(@RequestBody User user) {
        return userService.signout(user.getUsername(), user.getPassword());
    }

    @PutMapping("/disable/{username}")
    public int disableUser(@PathVariable String username) {
        return userService.disableUser(username);
    }

    @DeleteMapping("/delete/{username}/")
    public int delete(String userName) {
        return userService.delete(userName);
    }
*/
}
