/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.form;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Life
 */
public class ExaminationLine {
//<editor-fold defaultstate="collapsed" desc="поля">
    //id строки ознакомления
    private long id;
    //Название документа
    private String name;
    //номер документа
    private String number;
    //Название файла для отображения в качестве галочки
    private String picture;
    //ФИО пользователя
    private String fio;
    //признак заполнения
    private boolean checked;
    private long documentID;
    private long userID;
    private Date startDate;
//</editor-fold>

    /**
     *id строки ознакомления
     * @return id строки ознакомления
     */
    public long getId() {
        return id;
    }

    /**
     *id строки ознакомления
     * @param id id строки ознакомления
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Название документа 
     * @return Название документа
     */
    public String getName() {
        return name;
    }

    /**
     * Название документа
     * @param name Название документа
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public boolean isChecked() {
        return checked;
    }

    public final void setChecked(boolean checked) {
        this.checked = checked;
        picture=checked?"check.png":"cross.png";
    }

    public long getDocumentID() {
        return documentID;
    }

    public void setDocumentID(long documentID) {
        this.documentID = documentID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    

    public ExaminationLine(long id, String name, String number, String fio, boolean checked, long documentID, long userID, Date startDate) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.fio = fio;
        setChecked(checked);
        this.documentID = documentID;
        this.userID = userID;
        this.startDate = startDate;
    }
    
    
}
