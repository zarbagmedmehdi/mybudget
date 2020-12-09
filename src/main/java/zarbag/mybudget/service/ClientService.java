package zarbag.mybudget.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import zarbag.mybudget.bean.Client;
import zarbag.mybudget.dao.ClientDao;
import zarbag.mybudget.z.bean.ResetPassword;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class ClientService  {
    @Autowired
    ClientDao clientDao;

    public String login(String username, String password) {
        Client user = clientDao.findByUsernameAndPassword(username,password);
        if(user!=null){
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            clientDao.save(user);
            return token;
        }

        return StringUtils.EMPTY;
    }

    public Optional<User> findByToken(String token) {
        Client user1= clientDao.findByToken(token);
        if(user1!=null){
            User user= new User(user1.getUsername(), user1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    public Client findNameByToken(String token) {
        Client user=  clientDao.findByToken(token);
        if(user==null)return new Client("en cours de chargement");
        return new Client(user.getNom());
    }

    public int update(Client user) {
        Client u=  clientDao.findByToken(user.getToken());
        if(user==null) return -1;
        if(!user.getEmail().equals("")) u.setEmail(user.getEmail());
        if(!user.getNom().equals("")) u.setNom(user.getNom());
        if(!user.getDevise().equals("")) u.setDevise(user.getDevise());
            clientDao.save(u);
            return 1;
    }


    public int changePassword(ResetPassword rs) {
        Client u=  clientDao.findByToken(rs.getToken());
       if(rs==null) return -1;
       if(!u.getPassword().equals(rs.getOldPass())) return -2;
       if(!rs.getNewRPass().equals(rs.getNewPass())) return -3;
       u.setPassword(rs.getNewPass());
        clientDao.save(u);
        return 1;
    }

    public List<Client> findAll(){
        return clientDao.findAll();
    }
    public List<Client> FindConnected(){
        return clientDao.findAllActiveUsers();
    }
/*    public String login(String username,String password) throws Exception {

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


 */
    public int signout(String username,String password){
        Client user =clientDao.findByUsername(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                clientDao.save(user);

                return 1;}
            else {return -2;}
        }
        else {
            return -1;}
    }
    public Client findByEmailOrUsername(String email, String username){
        return clientDao.findByEmailOrUsername(email,username);
    }
    public Client findByUsername(String username){
        return clientDao.findByUsername(username);
    }
    public Client findByNom(String nom){
        return clientDao.findByUsername(nom);
    }

    public int save(Client user)
    {
        Client user1=clientDao.findByEmailOrUsername
                (user.getEmail(),user.getUsername());
        if(user1!=null){
            return -1;
        }
        else {
            user.setEnabled(true);
            user.setNbTentifRest(3);
            clientDao.save(user);
            return 1;
        }
    }
    public int disableUser(String username){
        Client user=clientDao.findByUsername(username);
        if(user!=null){
            user.setEnabled(false);
            clientDao.save(user);
            return 1;
        }
        else {
            return -1;
        }

    }
    public int delete(String userName)
    {
        Client user1=clientDao.findByUsername(userName);
        if(user1!=null){
            clientDao.delete(user1);
            return 1;
        }
        else {

            return -1;
        }
    }   }
