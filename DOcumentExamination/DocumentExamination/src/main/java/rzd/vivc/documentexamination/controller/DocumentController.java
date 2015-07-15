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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestPart;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.repository.DocumentRepository;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rzd.vivc.documentexamination.controller.exception.FileLoadingException;
import rzd.vivc.documentexamination.model.dto.exception.ExistingUserException;
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

    //для сохранения загруженных файлов
    @Autowired
    private FileSavingService fileSavingService;

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
     * Обработка данных с формы анотация @Valid означает, что данные должны
     * соответвтвовать ограничениям в классе Document
     *
     * @param file Загружаемый файл
     * @param document документ, который редактировали
     * @param errors список ошибок валидации
     * @param model модель с данными, нужна чтобы вставить в редирект знасение через placeholder
     * если в модель засунуть какие-то простые атрибуты, не вызываемые в плейсхолдерах, они добавятся в качестве параметров сами
     * @return "redirect: /documents/{documentID}" если все впорядке, возврат на
     * форму, если есть ошибки
     */
    @RequestMapping(value = "/edit", method = POST)
    public String processEdit(@RequestPart(value="file", required=false) Part file, @Valid Document document, Errors errors, RedirectAttributes model) {
        if (errors.hasErrors()) {
            return "editDocument";
        }
        //обрабока файла
        String fileName = "";
        try {
            fileName = fileSavingService.saveUploadedFile(file);
        } catch (IOException e) {
            //если не удалось сохранить файл
            throw new FileLoadingException();
        }

        //если удалось загрузить файл, добавляем его имя в информацию о документе
        if (!fileName.isEmpty()) {
            document.setFile(fileName);
        }

        Document saved = documentRepository.save(document);
        model.addAttribute("documentID", saved.getId());
        //ключ в модели будет document
        model.addFlashAttribute(saved);
        return "redirect:/documents/{documentID}";
    }

}
