/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *Тест контроллера для входа на страницу авторизации
 * @author VVolgina
 */
public class HomeControllerTest {
    
    public HomeControllerTest() {
    }

    /**
     * Test of home method, of class HomeController.
     * @throws java.lang.Exception
     */
    @Test
    public void testHome() throws Exception {
        System.out.println("home");
        HomeController controller= new HomeController();
        //собираем тестировщик для контроллера
        MockMvc mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
        //посылаем ему запрос GET на адрем / и проверяем, получили ли в ответ View index
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("index"));
        
    }
    
}
