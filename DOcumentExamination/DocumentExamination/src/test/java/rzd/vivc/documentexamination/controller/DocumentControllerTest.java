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
public class DocumentControllerTest {

    /**
     * Тест вывода всего списка документов через web страницу
     *
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("allDocs");

        //заглушка для репозитория
        List<Document> expectedDocuments = createList(20);
        DocumentRepository mockRepository = mock(DocumentRepository.class);
        when(mockRepository.findAll())
                .thenReturn(expectedDocuments);

        //настройка ViewResolver, чтобы тест понял, как совместить возвращаемое имя view и реальную страницу
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        //СОздаем контроллер и запихиваем в фреймворк
        DocumentController controller = new DocumentController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setViewResolvers(resolver)
                .build();

        mockMvc.perform(get("/documents"))
                .andExpect(view().name("documents"))
                .andExpect(model().attributeExists("documentList"))
                .andExpect(model().attribute("documentList",
                                hasItems(expectedDocuments.toArray())));
    }

    private List<Document> createList(int count) {
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            documents.add(new Document(i));
        }
        return documents;
    }
}
