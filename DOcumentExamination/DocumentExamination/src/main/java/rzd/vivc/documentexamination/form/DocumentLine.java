/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.form;

import java.util.Date;
import rzd.vivc.documentexamination.service.StringImprover;

/**
 * Строка для вывода в отчете по документам
 * @author VVolgina
 */
public class DocumentLine {
    private final long id;
    private final String name;
    private final String num;
    private final Date registrationDate;
    private final long checked;
    private final long unchecked;
    private final StringImprover improver=new StringImprover();

    /**
     * id
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Название документа
     * @return Название документа
     */
    public String getName() {
        return name;
    }

    /**
     * Номер документа
     * @return Номер документа
     */
    public String getNum() {
        return num;
    }

    /**
     * Дата регистрации
     * @return дата регистрации
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }
    
        /**
     * Дата регистрации в виде строки
     * @return дата регистрации в виде строки
     */
    public String getRegistrationDateString() {
        return improver.getStrangeDateString(registrationDate);
    }

    /**
     * К-во ознакомленных с документом
     * @return к-во ознакомленных с документом
     */
    public long getChecked() {
        return checked;
    }

    public long getUnchecked() {
        return unchecked;
    }


    /**
     *
     * @param id id
     * @param name Название документа
     * @param num номер
     * @param registrationDate дата регистрации
     * @param checked ознакомленные
     */
    public DocumentLine(long id, String name, String num, Date registrationDate, long checked, long unchecked) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.registrationDate = registrationDate;
        this.checked = checked;
        this.unchecked=unchecked;
    }
    
    
}
