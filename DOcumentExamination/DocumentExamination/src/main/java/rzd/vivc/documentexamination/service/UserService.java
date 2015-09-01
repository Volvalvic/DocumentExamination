/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import rzd.vivc.documentexamination.model.dto.security.Account;
import rzd.vivc.documentexamination.repository.AccountRepository;

/**
 * загрузка информации для авторизации пользователей
 * @author VVolgina
 */
public class UserService implements UserDetailsService{

    private final AccountRepository accountRepository;

    public UserService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Account account=accountRepository.findByLogin(username);
       if(account!=null){
           List<GrantedAuthority> autiriries=new ArrayList<>();
           autiriries.add(new SimpleGrantedAuthority(account.getUserType().getAutority()));
           return new User(account.getLogin(), account.getPassword(), autiriries);
           
       }
       throw new UsernameNotFoundException("Пользователь "+username+" не найден.");
    }
    
}
