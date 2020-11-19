package zarbag.mybudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import zarbag.mybudget.bean.AuthentificationResponse;
import zarbag.mybudget.bean.User;
import zarbag.mybudget.dao.UserDao;
import zarbag.mybudget.security.Util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Service

public class UserService  {
    @Autowired
    UserDao userDao;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private Util util;






    public List<User> findAll(){
        return userDao.findAll();
    }
    public List<User> FindConnected(){
        return userDao.findAllActiveUsers();
    }
    public String login(String username,String password) throws Exception {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            System.out.println(username +password);
        }
        catch (BadCredentialsException e){
            final String jwt="-1";
            return  jwt;
        }
        final UserDetails userDetails=myUserDetailsService.loadUserByUsername(username);
        final String jwt=util.generateToken(userDetails);
        return  jwt;
        }

    public int signout(String username,String password){
        User user =userDao.findByUsername(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                userDao.save(user);

                return 1;}
            else {return -2;}
        }
        else {
            return -1;}
    }
    public User findByEmailOrUsername(String email, String username){
        return userDao.findByEmailOrUsername(email,username);
    }
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
    public User findByNom(String nom){
        return userDao.findByUsername(nom);
    }

    public int save(User user)
    {
        User user1=userDao.findByEmailOrUsername
                (user.getEmail(),user.getUsername());
        if(user1!=null){
            return -1;
        }
        else {
            user.setEnabled(true);
            user.setNbTentifRest(3);
            userDao.save(user);
            return 1;
        }
    }
    public int disableUser(String username){
        User user=userDao.findByUsername(username);
        if(user!=null){
            user.setEnabled(false);
            userDao.save(user);
            return 1;
        }
        else {
            return -1;
        }

    }
    public int delete(String userName)
    {
        User user1=userDao.findByUsername(userName);
        if(user1!=null){
            userDao.delete(user1);
            return 1;
        }
        else {

            return -1;
        }
    }   }
