package rzd.vivc.documentexamination.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;
import rzd.vivc.documentexamination.service.FileSavingService;

/**
 * Контроллер для страницы documents.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/documents")
public class DocumentsController {

    private final DocumentRepository documentRepository;
    
     @Autowired
    private FileSavingService fileSavingService;

    /**
     * Конструктор. Репозиторий вводится через него в тестовых целях
     *
     * @param documentRepository репозиторий
     */
    @Autowired
    public DocumentsController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    /**
     * При GET запросе к /documents в модель добавляется список документов
     * удоалетворяющих параметрам, заданным в фильтре с ключом documentList -
     * название берется в соотвествии с вовращаемым типом в качестве view
     * берется documents, так как контроллер обрабатывает запросы к /documents
     *
     * @param type фильтр Тип документа
     * @param name фильтр имя документа
     * @param number фильтр номер документа
     * @param description фильтр описание документа
     * @param date фильтр дата документа
     * @return список документов
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Document> documents(@RequestParam(value = "type", defaultValue = "0") long type, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "number", required = false) String number, @RequestParam(value = "description", required = false) String description, @RequestParam(value = "date", required = false) Date date) {
        List<Document> findFiltered = documentRepository.findFiltered(name, number, date, description, type);
        return findFiltered;
    }

  
}
