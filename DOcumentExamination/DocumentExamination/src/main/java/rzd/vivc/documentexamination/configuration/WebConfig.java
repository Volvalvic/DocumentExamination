/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * настройка web
 *
 * @author VVolgina
 */
@Configuration
@EnableWebMvc
@ComponentScan("rzd.vivc.documentexamination.controller")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver() {
        /*        InternalResourceViewResolver resolver
        = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        //позволяет получать досутп из JSP КО ВСЕМ БИНАМ В КОНТЕЙНЕРЕ. пОКАМ ННЕ НУЖНО
        // resolver.setExposeContextBeansAsAttributes(true);
        //собираюсь использовать jstl, поэтому для удобства использую соответствующий тип view
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        return resolver;*/
        return new TilesViewResolver();
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tiles=new TilesConfigurer();
        tiles.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});
        tiles.setCheckRefresh(true);
        return tiles;
   }
    
}
