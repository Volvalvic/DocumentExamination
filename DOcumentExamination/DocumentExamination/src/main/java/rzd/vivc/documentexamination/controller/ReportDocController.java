/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import rzd.vivc.documentexamination.form.DateFilter;
import rzd.vivc.documentexamination.form.ExaminationLine;
import rzd.vivc.documentexamination.form.service.DateFilterService;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;

/**
 * Для reportDoc.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/director/reportDoc")
public class ReportDocController {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DateFilterService dateFilterService;

    public ReportDocController() {
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
    public String documents(@RequestParam(value = "type", defaultValue = "0") long type, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "number", required = false) String number, @RequestParam(value = "description", required = false) String description, @RequestParam(value = "date", required = false) Date date, Model model) {
        DateFilter dateFilter = dateFilterService.createFirstAndLastDayOfCurrentMonth();
        model.addAttribute(dateFilter);

        List<Document> findFiltered = documentRepository.findFiltered(name, number, date, description, type, dateFilter);
        model.addAttribute(findFiltered);

        return "reportDoc";
    }
    
    /**
     *
     * @param model
     * @param dateFilter
     * @return
     */
    @RequestMapping(method = POST)
    public String filteredDocuments(Model model, DateFilter dateFilter) {
        List<Document> findFiltered = documentRepository.findFiltered(dateFilter);
        model.addAttribute(findFiltered);
        return "reportDoc";
    }
}
