/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;

/**
 * тест контроллера для работы с отдельным документом
 *
 * @author VVolgina
 */
public class DocumentControllerTest {

    public DocumentControllerTest() {
    }

    /**
     * ПРоверка перехода на страницу редактирования
     *
     * @throws java.lang.Exception
     */
   
    public void testEdit() throws Exception {
        System.out.println("edit");
        DocumentRepository mockRepository = mock(DocumentRepository.class);

        //настройка ViewResolver, чтобы тест понял, как совместить возвращаемое имя view и реальную страницу
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        //СОздаем контроллер и запихиваем в фреймворк
        DocumentController controller = new DocumentController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setViewResolvers(resolver)
                .build();

        mockMvc.perform(get("/document/edit"))
                .andExpect(view().name("editDocument"));
    }

    /**
     * проверка работы с формой редактирования
     * @throws java.lang.Exception
     */
///TODO выяснить, как тестировать multioart
    public void testFormSubmission() throws Exception {
        //заглушка для репозитория
        Document unsavedDocument = new Document("док", "фи-34", new Date(), "тестовый документ", null, null, 0, null, null, null);
        unsavedDocument.setStartDate(null);
        Document savedDocument = new Document("док", "фи-34", new Date(), "тестовый документ", "", null, 1, new Date(), null, null);
        DocumentRepository mockRepository = mock(DocumentRepository.class);
        when(mockRepository.save(unsavedDocument))
                .thenReturn(savedDocument);

        //настройка ViewResolver, чтобы тест понял, как совместить возвращаемое имя view и реальную страницу
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        //СОздаем контроллер и запихиваем в фреймворк
        DocumentController controller = new DocumentController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setViewResolvers(resolver)
                .build();

        mockMvc.perform(post("/document/edit")
                .param("name", "док")
                .param("number", "фи-34")
                .param("description", "тестовый документ"))
                .andExpect(redirectedUrl("/documents/1"));
        verify(mockRepository, atLeastOnce()).save(unsavedDocument);
    }
}
