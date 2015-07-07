/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String edit(Model model) {
        //на странице радактирования все поля привязаны к содержащемуся в 
        //модели атрибуту document, для корректной работы его надо добавить в модель
        model.addAttribute(new Document());
        return "editDocument";
    }

    /**
     * Обработка данных с формы
     * анотация @Valid означает, что данные должны соответвтвовать ограничениям в классе Document
     *
     * @param document документ, который редактировали
     * @param errors список ошибок валидации
     * @return "redirect: /documents/{documentID}" если все впорядке, возврат на форму, если есть ошибки
     */
    @RequestMapping(value = "/edit", method = POST)
    public String processEdit(@Valid Document document, Errors errors) {
        if(errors.hasErrors()){
             return "editDocument";
        }
        Document saved = documentRepository.save(document);
        return "redirect:/documents/" + saved.getId();
    }

}
