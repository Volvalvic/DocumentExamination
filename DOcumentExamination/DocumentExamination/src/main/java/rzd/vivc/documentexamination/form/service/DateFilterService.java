/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.form.service;

import java.util.Date;
import rzd.vivc.documentexamination.form.DateFilter;

/**
 * Проставляем даты в фильтр
 * @author VVolgina
 */
public interface DateFilterService {

    /**
     * СОздат фильтр для даты с началом и концом укакзанного месяца
     * @param dayOfMonth дата из нужного месяца
     * @return фильтр
     */
    DateFilter createFirstAndLastDayOfMonth(Date dayOfMonth);

    /**
     *  СОздает фильтр для даты с началом и концом текущего месяца
     * @return фильтр
     */
    DateFilter createFirstAndLastDayOfCurrentMonth();
}
