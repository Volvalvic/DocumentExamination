/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.form.service;

import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Component;
import rzd.vivc.documentexamination.form.DateFilter;

/**
 * Работа с фильтрами для дат с помощью
 *
 * @see Calendar
 * @author VVolgina
 */
@Component
public class DateFilterServiceWithCalendar implements DateFilterService {

    @Override
    public DateFilter createFirstAndLastDayOfMonth(Date dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayOfMonth);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); // это будет начало месяца
        Date start = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date finish = calendar.getTime();
        return new DateFilter(start, finish);
    }

    @Override
    public DateFilter createFirstAndLastDayOfCurrentMonth() {
        return createFirstAndLastDayOfMonth(new Date());
    }

}
