/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.form;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import rzd.vivc.documentexamination.service.IStringService;
import rzd.vivc.documentexamination.service.StringImprover;

/**
 * Для модели фильтра по дате документа
 * @author VVolgina
 */
public class DateFilter {

    private StringImprover stringImprover =new StringImprover();
    
    private Date from;
    private Date to;

    /**
     * Дата с
     * @return Дата с
     */
    public Date getFrom() {
        return from;
    }

    /**
     * Дата с
     * @param from Дата с
     */
    public void setFrom(Date from) {
        this.from = from;
    }

        /**
     * Дата с
     * @return Дата с
     */
    public String getFromString() {
        return stringImprover.getStrangeDateString(from);
    }

    /**
     * Дата с
     * @param from Дата с
     */
    public void setFromString(String from) throws IllegalArgumentException{
        this.from = stringImprover.getDateByyStrangeString(from);
    }
    
    /**
     * Дата по
     * @return Дата по
     */
    public Date getTo() {
        return to;
    }

    /**
     * Дата по
     * @param to Дата по
     */
    public void setTo(Date to) {
        this.to = to;
    }

      /**
     * Дата по
     * @return Дата по
     */
    public String getToString() {
        return stringImprover.getStrangeDateString(to);
    }

    /**
     * Дата по
     * @param to Дата по
     */
    public void setToString(String to) throws IllegalArgumentException{
        this.to = stringImprover.getDateByyStrangeString(to);
    }
    
    public DateFilter() {
    }

    /**
     *
     * @param from Дата с
     * @param to Дата по
     */
    public DateFilter(Date from, Date to) {
        this.from = from;
        this.to = to;
    }
    
    
    
}
