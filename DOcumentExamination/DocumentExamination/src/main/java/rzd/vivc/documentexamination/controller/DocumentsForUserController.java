package rzd.vivc.documentexamination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.vivc.documentexamination.form.ExaminationLine;
import rzd.vivc.documentexamination.repository.ExaminationRepository;
import rzd.vivc.documentexamination.service.AuthenticationInfoService;

/**
 * Контроллер для страницы documentsForUser.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/user/documentsForUser")
public class DocumentsForUserController {
    
     @Autowired
    private ExaminationRepository examinationRepository;
     @Autowired
     private AuthenticationInfoService authenticationInfoService;

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
    public String examinations(Model model) {
        List<ExaminationLine> findFiltered = examinationRepository.findByUser(authenticationInfoService.getLogin());
        model.addAttribute(findFiltered);
        return "documentsForUser";
    }

   
}
