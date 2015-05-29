package rzd.vivc.documentexamination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;

/**
 * Контроллер для страницы documents.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentRepository documentRepository;

    /**
     * Конструктор. Репозиторий вводится через него в тестовых целях
     *
     * @param documentRepository репозиторий
     */
    @Autowired
    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    /**
     * При GET запросе к /documents в модель добавляется список документов с
     * ключом documentList - название берется в соотвествии с вовращаемым типом
     * в качестве view берется documents, так как контроллер обрабатывает
     * запросы к /documents
     *
     * @return список документо
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Document> documents() {
        return documentRepository.findAll();
    }
}
