/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import rzd.vivc.documentexamination.aspects.UserAndDateInjector;

/**
 * Конфигурация оспектов для БД
 * @author VVolgina
 */
@Configuration
@EnableAspectJAutoProxy
public class RepositoryAspectsConfig {

     /**
     *СОхранение в БД
     * @return
     */
    @Bean
    public UserAndDateInjector userAndDateInjector(){
        return new UserAndDateInjector();
    }
}
