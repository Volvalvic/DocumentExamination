/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import rzd.vivc.documentexamination.configuration.WebConfig;

/**
 * первая страница авторизации. контроллер. работает с запросами на адрес /.
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * при первом запросе к / посылает на страницу автризации index на самом
     * деле она лежит в /WEB-INF/views/index.jsp поиск адреса происходит с
     * помощью ViewResolver, настройка которого в классе
     *
     * @see WebConfig
     *
     * @return index
     */
    @RequestMapping(method = GET)
    public String home() {
        return "index";
    }
}
