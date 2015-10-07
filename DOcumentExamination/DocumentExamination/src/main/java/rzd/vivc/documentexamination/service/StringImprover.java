/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        return dat == null ? " " : format.format(dat);
    }
    
    public String getStrangeDateString(Date dat) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return dat == null ? " " : format.format(dat);
    }

    @Override
    public Date getDateByyString(String str) throws IllegalArgumentException{
         SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
         Date dat;
        try {
            dat=format.parse(str);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Неверный формат строки. Необходимо ввести строку вида dd.MM.yyyy");
        }
        return dat;
    }

    public Date getDateByyStrangeString(String str) throws IllegalArgumentException{
         SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
         Date dat;
        try {
            dat=format.parse(str);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Неверный формат строки. Необходимо ввести строку вида dd.MM.yyyy");
        }
        return dat;
    }
}
