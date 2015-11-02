package rzd.vivc.documentexamination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.vivc.documentexamination.form.ExaminationLine;
import rzd.vivc.documentexamination.repository.ExaminationRepository;
import rzd.vivc.documentexamination.service.ReportGeneratorService;

/**
 * Контроллер для страницы documentsForUsers.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/director/usersForDocument")
public class UsersForDocumentController {

    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private ReportGeneratorService reportGeneratorService;

    /**
     * Конструктор. Репозиторий вводится через него в тестовых целях
     *
     */
    public UsersForDocumentController() {
    }

    /**
     * При GET запросе к /documentsForUsers в модель добавляется список
     * документов удоалетворяющих параметрам, заданным в фильтре с ключом
     * documentList - название берется в соотвествии с вовращаемым типом в
     * качестве view берется documentsForUsers, так как контроллер обрабатывает
     * запросы к /documentsForUsers
     *
     * @param documentID
     * @return список документов
     */
    @RequestMapping(value = "/{documentID}", method = RequestMethod.GET)
    public String examinations(@PathVariable(value = "documentID") long documentID, Model model) {

        List<ExaminationLine> findFiltered = examinationRepository.findByDocument(documentID);
        model.addAttribute(findFiltered);
        int checkedCount = 0;
        for (ExaminationLine findFiltered1 : findFiltered) {
            if (findFiltered1.isChecked()) {
                checkedCount++;
            }
        }
        int percentage = findFiltered.size()>0?checkedCount * 100 / findFiltered.size():100;
        model.addAttribute("percentage", percentage);

        model.addAttribute("file", reportGeneratorService.generateReportUsersForDoc(findFiltered, percentage));
        return "usersForDocument";
    }

}
