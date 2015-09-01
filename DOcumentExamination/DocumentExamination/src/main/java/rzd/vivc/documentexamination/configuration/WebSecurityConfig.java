/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import rzd.vivc.documentexamination.repository.AccountRepository;
import rzd.vivc.documentexamination.service.UserService;

/**
 * конфигурация web security
 *
 * @author VVolgina
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserService(accountRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                 .logout().logoutSuccessUrl("/").and()
                .authorizeRequests()
                .antMatchers("/documents**").hasRole("DIRECTOR")
                .antMatchers("/users**").hasRole("ADMIN")
                .antMatchers("/documentsForUser**").hasRole("USER")
                .anyRequest().permitAll();
    }

}
