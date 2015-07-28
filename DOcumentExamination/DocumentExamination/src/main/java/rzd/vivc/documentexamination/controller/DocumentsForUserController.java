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
 * Контроллер для страницы documentsForUser.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/documentsForUser")
public class DocumentsForUserController {
    
     @Autowired
    private ExaminationRepository examinationRepository;

    /**
     * Конструктор. 
     *
     */

    public DocumentsForUserController() {
    }

    /**
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<ExaminationLine> examinations() {
        List<ExaminationLine> findFiltered = examinationRepository.findByUser(1);

 
        return findFiltered;
    }

   
}
