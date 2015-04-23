/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * Собраны методы для модификации строковых переменных
 *
 * @author VVolgina
 */
@Component
public class StringImprover implements IStringService {

    @Override
    public String getCutedString(String str, int length) {
        if (str.length() <= length) {
            return str;
        } else {
            return str.substring(0, length - 1);
        }
    }

    @Override
    public String getDateString(Date dat) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return dat == null ? "Для формирования даты необходимо ввести информацию по всем видам ресурсов" : format.format(dat);
    }


}
