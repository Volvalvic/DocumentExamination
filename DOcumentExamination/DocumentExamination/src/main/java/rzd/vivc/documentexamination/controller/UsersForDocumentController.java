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
import rzd.vivc.documentexamination.form.ExaminationLine;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;
import rzd.vivc.documentexamination.repository.ExaminationRepository;
import rzd.vivc.documentexamination.service.FileSavingService;

/**
 * Контроллер для страницы documentsForUsers.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/usersForDocument")
public class UsersForDocumentController {

    @Autowired
    private ExaminationRepository examinationRepository;

    /**
     * Конструктор. Репозиторий вводится через него в тестовых целях
     *
     * @param documentRepository репозиторий
     */
    public UsersForDocumentController() {
        System.out.println("Собираем");
    }

    /**
     * При GET запросе к /documentsForUsers в модель добавляется список
     * документов удоалетворяющих параметрам, заданным в фильтре с ключом
     * documentList - название берется в соотвествии с вовращаемым типом в
     * качестве view берется documentsForUsers, так как контроллер обрабатывает
     * запросы к /documentsForUsers
     *
     * @param type фильтр Тип документа
     * @param name фильтр имя документа
     * @param number фильтр номер документа
     * @param description фильтр описание документа
     * @param date фильтр дата документа
     * @return список документов
     */
    @RequestMapping(value = "/{documentID}", method = RequestMethod.GET)
    public String examinations(@PathVariable(value = "documentID") long documentID, Model model) {
        
        List<ExaminationLine> findFiltered = examinationRepository.findByDocument(documentID);
        for (ExaminationLine findFiltered1 : findFiltered) {
            System.out.println(findFiltered1);
        }
        model.addAttribute(findFiltered);

        return "usersForDocument";
    }

}
