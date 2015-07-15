/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.configuration.initilizer;

import java.io.File;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import rzd.vivc.documentexamination.configuration.RootConfig;
import rzd.vivc.documentexamination.configuration.WebConfig;

/**
 * диспатчер. основные настройки web
 *
 * @author VVolgina
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    //Дополнительные насройки главного сервлета
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        //куда загружать файлы
        //максимальный рамер файла
        //vМаксимальный размер всех данных с формы
        //максимальный размер файла, который будет загружен прямо на диск, без временной директории. сейчас все сразу на диск
        registration.setMultipartConfig(new MultipartConfigElement("C:" + File.separator + File.separator + "temp", 2097152, 4194304,0));
    }

    @Override
    //список фильтров
    protected Filter[] getServletFilters() {
        //добавляем фильтр для русских букв
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return new Filter[]{filter};
    }

    
}
