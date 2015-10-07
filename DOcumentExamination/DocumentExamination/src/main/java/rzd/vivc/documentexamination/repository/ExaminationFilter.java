/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.util.List;
import rzd.vivc.documentexamination.form.DateFilter;
import rzd.vivc.documentexamination.form.ExaminationLine;
import rzd.vivc.documentexamination.model.dto.documents.Examination;

/**
 * Фильтрация списка документов по разным параметрам
 * @author VVolgina
 */
public interface ExaminationFilter {

    /**
     * Извлекает из БД список ознакомлений для пользователя
     * @param login логин вошедшего в систему пользователя
     * @param dateFilter Даты, с и по для поиска документа по дате подписания
     * @return список документов
     */
    List<ExaminationLine> findByUserAndDate(String login, DateFilter dateFilter);
    Examination findWithDependencies(long id);
    List<ExaminationLine> findByDocument(long documentID);
}
