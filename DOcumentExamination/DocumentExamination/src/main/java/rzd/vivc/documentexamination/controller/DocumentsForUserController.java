package rzd.vivc.documentexamination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.vivc.documentexamination.form.ExaminationLine;
import rzd.vivc.documentexamination.repository.ExaminationRepository;

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
