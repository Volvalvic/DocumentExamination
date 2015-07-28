package rzd.vivc.documentexamination.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.hasItems;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;

/**
 * страницп documents
 * @author VVolgina
 */
public class DocumentsControllerTest {

    /**
     * Тест вывода всего списка документов через web страницу
     *
     * @throws Exception
     */

    public void testFindAll() throws Exception {
        System.out.println("allDocs");

        //заглушка для репозитория
        List<Document> expectedDocuments = createList(20);
        DocumentRepository mockRepository = mock(DocumentRepository.class);
        when(mockRepository.findFiltered(null, null, null, null, 0))
                .thenReturn(expectedDocuments);

        //настройка ViewResolver, чтобы тест понял, как совместить возвращаемое имя view и реальную страницу
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        //СОздаем контроллер и запихиваем в фреймворк
        DocumentsController controller = new DocumentsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setViewResolvers(resolver)
                .build();

        mockMvc.perform(get("/documents"))
                .andExpect(view().name("documents"))
                .andExpect(model().attributeExists("documentList"))
                .andExpect(model().attribute("documentList",
                                hasItems(expectedDocuments.toArray())));
    }

    /**
     * Тест вывода всех документов данного типа
     *
     * @throws Exception
     */

    public void testFindByType() throws Exception {
        System.out.println("typeDocs");

        //заглушка для репозитория
        List<Document> expectedDocuments = createList(10);
        DocumentRepository mockRepository = mock(DocumentRepository.class);
        when(mockRepository.findFiltered(null, null, null, null, 1))
                .thenReturn(expectedDocuments);

        //настройка ViewResolver, чтобы тест понял, как совместить возвращаемое имя view и реальную страницу
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        //СОздаем контроллер и запихиваем в фреймворк
        DocumentsController controller = new DocumentsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setViewResolvers(resolver)
                .build();

        mockMvc.perform(get("/documents?type=1"))
                .andExpect(view().name("documents"))
                .andExpect(model().attributeExists("documentList"))
                .andExpect(model().attribute("documentList",
                                hasItems(expectedDocuments.toArray())));
    }
    
    /**
     * Тест вывода одного документа
     *
     * @throws Exception
     */

    public void testFindOne() throws Exception {
        System.out.println("oneDocs");

        //заглушка для репозитория
       Document expectedDocument = new Document(15);
        DocumentRepository mockRepository = mock(DocumentRepository.class);
        when(mockRepository.findOne(15l))
                .thenReturn(expectedDocument);

        //настройка ViewResolver, чтобы тест понял, как совместить возвращаемое имя view и реальную страницу
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        //СОздаем контроллер и запихиваем в фреймворк
        DocumentsController controller = new DocumentsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setViewResolvers(resolver)
                .build();

        mockMvc.perform(get("/documents/15"))
                .andExpect(view().name("document"))
                .andExpect(model().attributeExists("document"))
                .andExpect(model().attribute("document",expectedDocument));
    }
    
    
    private List<Document> createList(int count) {
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            documents.add(new Document(i));
        }
        return documents;
    }
}
