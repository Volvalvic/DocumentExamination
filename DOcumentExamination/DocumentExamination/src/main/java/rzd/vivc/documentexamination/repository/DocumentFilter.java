/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.util.Date;
import java.util.List;
import rzd.vivc.documentexamination.form.DateFilter;
import rzd.vivc.documentexamination.form.DocumentLine;
import rzd.vivc.documentexamination.model.dto.documents.Document;

/**
 * Фильтрация списка документов по разным параметрам
 * @author VVolgina
 */
public interface DocumentFilter {

    /**
     * Извлекает из БД список отфильтрованных документов
     * @param name название документа
     * @param number номер документа
     * @param startDate дата начала актуальности
     * @param description описание документа
     * @param documentTypeID id типа документа
     * @return список документов
     */
    List<Document> findFiltered(String name, String number, Date startDate, String description, long documentTypeID);
    
    /**
     * Извлекает из БД список отфильтрованных документов
     * @param name название документа
     * @param number номер документа
     * @param startDate дата начала актуальности
     * @param description описание документа
     * @param documentTypeID id типа документа
     * @param dateFilter дата регистрации доумента с по
     * @return список документов
     */
    List<Document> findFiltered(String name, String number, Date startDate, String description, long documentTypeID, DateFilter dateFilter);
    
    /**
     *Извлекает из БД список отфильтрованных документов
     * @param dateFilter дата регистрации доумента с по
     * @return список документов
     */
    List<Document> findFiltered(DateFilter dateFilter);
    
    /**
     * СПисок строк с информацией по документам
     * @param documentFilter фильтр по дате регистрации
     * @return строки
     */
    List<DocumentLine> getFilteredLines(DateFilter documentFilter);
}
