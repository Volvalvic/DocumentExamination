/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;

/**
 * Для document.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/document")
public class DocumentController {

    //автоматически привязываемая реализация репозитория для документов
    private final DocumentRepository documentRepository;

    /**
     * конструктор
     *
     * @param documentRepository репозиторий
     */
    @Autowired
    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    /**
     * переход к странице редактирования
     *
     * @return view Для страницы редактирования
     */
    @RequestMapping(value = "/edit", method = GET)
    public String edit() {
        return "editDocument";
    }

    /**
     * Обработка данных с формы
     *
     * @param document документ, который редактировали
     * @return "redirect: /documents/{documentID}"
     */
    @RequestMapping(value = "/edit", method = POST)
    public String processEdit(Document document) {
        Document saved = documentRepository.save(document);
        return "redirect:/documents/" + saved.getId();
    }

}
