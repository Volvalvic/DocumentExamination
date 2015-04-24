/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rzd.vivc.documentexamination.repository.DocumentRepository;

/**
 * Создает БД, из которой можно вытащить срипт
 * @author VVolgina
 */
public class NewClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringDateConfigMySQL.class);
        DocumentRepository rep=context.getBean(DocumentRepository.class);
        System.out.println(rep.count());
    }
}
