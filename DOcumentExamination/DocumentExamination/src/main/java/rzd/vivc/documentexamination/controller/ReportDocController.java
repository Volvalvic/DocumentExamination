/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Part;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rzd.vivc.documentexamination.controller.exception.FileLoadingException;
import rzd.vivc.documentexamination.form.DocumentForm;
import rzd.vivc.documentexamination.model.dto.documents.Examination;
import rzd.vivc.documentexamination.repository.DocumentTypeRepository;
import rzd.vivc.documentexamination.service.FileSavingService;

/**
 * Для reportDoc.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/reportDoc")
public class ReportDocController {
    @Autowired
 private DocumentRepository documentRepository;
    
   

   

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
    public List<Document> documents(@RequestParam(value = "type", defaultValue = "0") long type, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "number", required = false) String number, @RequestParam(value = "description", required = false) String description, @RequestParam(value = "date", required = false) Date date) {
        List<Document> findFiltered = documentRepository.findFiltered(name, number, date, description, type);
        return findFiltered;
    }
}
