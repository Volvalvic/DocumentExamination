package rzd.vivc.documentexamination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import rzd.vivc.documentexamination.form.DateFilter;
import rzd.vivc.documentexamination.form.ExaminationLine;
import rzd.vivc.documentexamination.form.service.DateFilterService;
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
    @Autowired
    private DateFilterService dateFilterService;

    /**
     * Конструктор.
     *
     */
    public DocumentsForUserController() {
    }

    /**
     * Гет запросы к странице списка ознакомлений для пользователя
     *
     * @param model модель
     * @return documentsForUser
     */
    @RequestMapping(method = RequestMethod.GET)
    public String examinations(Model model) {
        DateFilter dateFilter = dateFilterService.createFirstAndLastDayOfCurrentMonth();
        dateFilter.setName("");
        
        List<ExaminationLine> findFiltered = examinationRepository.findByUserAndDate(authenticationInfoService.getLogin(), dateFilter);
        
        model.addAttribute(findFiltered);
        model.addAttribute(dateFilter);
        
        return "documentsForUser";
    }

    /**
     * Обрабатывает запрос на получение списка ознакомлений с заданным фильтром
     *
     * @param model модель
     * @param dateFilter фильтр
     * @return documentsForUser
     */
    @RequestMapping(method = POST)
    public String filteredExaminations(Model model, DateFilter dateFilter) {
        List<ExaminationLine> findFiltered = examinationRepository.findByUserAndDate(authenticationInfoService.getLogin(), dateFilter);
        
        model.addAttribute(findFiltered);
        
        return "documentsForUser";
    }
}
