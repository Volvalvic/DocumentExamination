/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller;

import java.io.IOException;
import javax.servlet.http.Part;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestPart;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rzd.vivc.documentexamination.controller.exception.FileLoadingException;
import rzd.vivc.documentexamination.form.DocumentForm;
import rzd.vivc.documentexamination.repository.DocumentTypeRepository;
import rzd.vivc.documentexamination.service.DocumentAdditionalSavingServicesRepository;
import rzd.vivc.documentexamination.service.FileSavingService;

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
    //Репозиторий для типов документов
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    //для сохранения загруженных файлов
    @Autowired
    private FileSavingService fileSavingService;
    
    @Autowired
    private DocumentAdditionalSavingServicesRepository documentAdditionalSavingServicesRepository;

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
     * переход к странице редактирования Для корректировки существующего
     * документа
     *
     * @param documentID id документа для редактирования
     * @param model модель
     * @return view Для страницы редактирования
     */
    @RequestMapping(value = "/edit/{documentID}", method = GET)
    public String edit(@PathVariable(value = "documentID") long documentID, Model model) {
        addTypes(model);
        //на странице радактирования все поля привязаны к содержащемуся в 
        //модели атрибуту document, для корректной работы его надо добавить в модель
        Document document = documentRepository.findOne(documentID);
        DocumentForm documentForm = new DocumentForm(document);
        fileSavingService.addFileLink(documentForm);
        model.addAttribute(documentForm);
        return "editDocument";
    }

    /**
     * переход к странице редактирования
     *
     * @param model модель
     * @return view Для страницы редактирования
     */
    @RequestMapping(value = "/edit", method = GET)
    public String edit(Model model) {
        addTypes(model);
        //на странице радактирования все поля привязаны к содержащемуся в 
        //модели атрибуту document, для корректной работы его надо добавить в модель
        model.addAttribute(new DocumentForm());
        return "editDocument";
    }

    /**
     * Обработка данных с формы анотация @Valid означает, что данные должны
     * соответвтвовать ограничениям в классе DocumentForm
     *
     * @param file загруженнфй файл
     * @param document документ, который редактировали
     * @param errors список ошибок валидации
     * @param model модель с данными, нужна чтобы вставить в редирект знасение
     * через placeholder если в модель засунуть какие-то простые атрибуты, не
     * вызываемые в плейсхолдерах, они добавятся в качестве параметров сами
     * @return "redirect: /documents/{documentID}" если все впорядке, возврат на
     * форму, если есть ошибки
     */
    @RequestMapping(value = "/edit", method = POST)
    public String processEdit(@RequestPart Part file, @Valid DocumentForm document, Errors errors, RedirectAttributes model) {
        return processEditRealisation(file, 0, document, errors, model);
    }

    /**
     * Обработка данных с формы анотация @Valid означает, что данные должны
     * соответвтвовать ограничениям в классе DocumentForm Для редактирования
     * существующего документа
     *
     * @param documentID id Документа
     * @param file загруженный файл
     * @param document документ, который редактировали
     * @param errors список ошибок валидации
     * @param model модель с данными, нужна чтобы вставить в редирект знасение
     * через placeholder если в модель засунуть какие-то простые атрибуты, не
     * вызываемые в плейсхолдерах, они добавятся в качестве параметров сами
     * @return "redirect: /documents/{documentID}" если все впорядке, возврат на
     * форму, если есть ошибки
     */
    @RequestMapping(value = "/edit/{documentID}", method = POST)
    public String processEdit(@PathVariable(value = "documentID") long documentID, @RequestPart Part file, @Valid DocumentForm document, Errors errors, RedirectAttributes model) {
        return processEditRealisation(file, documentID, document, errors, model);
    }

    private String processEditRealisation(Part file, long documentID, DocumentForm document, Errors errors, RedirectAttributes model) {
        if (errors.hasErrors()) {
            return "editDocument";
        }
        document.setFile(file);

        //обрабока файла, приложенного к документу
        try {
            fileSavingService.saveUploadedFile(document);
        } catch (IOException e) {
            //если не удалось сохранить файл
            throw new FileLoadingException();
        }
        Document dtoDocument = document.toDocument();
        dtoDocument.setId(documentID);
        Document saved = documentAdditionalSavingServicesRepository.saveWythExaminations(dtoDocument);
        model.addAttribute("documentID", saved.getId());
        //ключ в модели будет document. этот атрибут сохранится в модели приредиректе
        model.addFlashAttribute(saved);
        return "redirect:/documents/{documentID}";
    }
    
    /**
     * ДОбавляет в модель список типов документов
     */
    private void addTypes(Model model){
       model.addAttribute("types", documentTypeRepository.findAll(new Sort(Sort.Direction.ASC, "name"))) ;
    }
}
