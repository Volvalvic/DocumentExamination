/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.util.List;
import rzd.vivc.documentexamination.form.DateFilter;
import rzd.vivc.documentexamination.form.DocumentLine;
import rzd.vivc.documentexamination.form.ExaminationLine;

/**
 * Генератор отчетов
 * @author VVolgina
 */
public interface ReportGeneratorService {

    /**
     * Список документов и к-во пользователей, озщнакомленных и не ознакомленных с ними
     * @param documentLines документы
     * @param i к-во пользователей
     * @param dateFilter
     * @return адрес файла с отчетом
     */
    String generateReportDoc(List<DocumentLine> documentLines, DateFilter dateFilter);

    /**
     * Список пользователей, не озщнакомленных с документом
     * @param examinationLines список озщнакомлений
     * @param percentage ПРоцент ознакомившихся
     * @return адрес файла с отчетом
     */
    String generateReportUsersForDoc( List<ExaminationLine> examinationLines, int percentage);
}
