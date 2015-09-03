/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import rzd.vivc.documentexamination.model.dto.documents.Examination;
import rzd.vivc.documentexamination.repository.ExaminationRepository;
import rzd.vivc.documentexamination.service.FileSavingService;

/**
 * Для document.jsp
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/user/documentRead")
public class DocumentReadController {

    //автоматически привязываемая реализация репозитория для документов
    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private FileSavingService fileSavingService;

    /**
     * конструктор
     *
     * @param documentRepository репозиторий
     */
    public DocumentReadController() {

    }

    /**
     * переход к странице редактирования Для корректировки существующего
     * документа
     *
     * @param documentID id документа для редактирования
     * @param model модель
     * @return view Для страницы редактирования
     */
    @RequestMapping(value = "/{documentID}", method = GET)
    public String view(@PathVariable(value = "documentID") long documentID, Model model) {
        //на странице радактирования все поля привязаны к содержащемуся в 
        //модели атрибуту document, для корректной работы его надо добавить в модель
        Examination examination = examinationRepository.findWithDependencies(documentID);
        model.addAttribute("link", fileSavingService.getFileLink(examination.getDocument().getFile()));
        model.addAttribute(examination);

        return "documentRead";
    }

    /**
     * Обработка данных с формы анотация @Valid означает, что данные должны
     * соответвтвовать ограничениям в классе DocumentForm Для редактирования
     * существующего документа
     *
     * @param documentID id Документа
     * @return "redirect: /documents/{documentID}" если все впорядке, возврат на
     * форму, если есть ошибки
     */
    @RequestMapping(value = "/{documentID}", method = POST)
    public String processEdit(@PathVariable(value = "documentID") long documentID, Examination examination) {
        Examination findOne = examinationRepository.findOne(documentID);
        findOne.setChecked(examination.isChecked());
        examinationRepository.save(findOne);
        return "redirect:/user/documentsForUser";
    }
}
