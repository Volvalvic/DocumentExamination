/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.model.dto.documents;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import rzd.vivc.documentexamination.model.dto.base.BaseEntity;
import rzd.vivc.documentexamination.model.dto.users.User;

/**
 * Документы для ознакомления. Для БД. Анотации под хибернейт
 *
 * @author VVolgina
 */
@Entity
@Table(name = "DOCUMENT")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Document extends BaseEntity implements Serializable {

//<editor-fold defaultstate="collapsed" desc="поля">
    //Название документа
    //сообщения для валидайии сожержатся в файле
    //ValidationMessages в корне
    @Column(name = "NAME", length = 100)
    @NotNull(message = "{valid.exists}")
    @Size(min = 1,max=100, message = "{valid.size}")
    private String name;
    //номер документа
    @Column(name = "NUMBER", length = 100)
    @NotNull(message = "{valid.exists}")
    @Size(min = 1,max=100, message = "{valid.size}")
    private String number;
    //дата подписания, должна быть в прошлом
    @Column(name = "START_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    //краткое описание
    @Column(name = "DESCRIPTION")
    @Size(max=255, message = "{valid.size}")
    private String description;
    //прикрепленный файл
    @Column(name = "FILE")
    private String file;
    
    //тип документа
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_TYPE_ID")
    private DocumentType documentType;
//</editor-fold>

    public Document() {
    }

    public Document(int i) {
        super(i);
    }

    public Document(String name, String number, Date startDate, String description, String file, DocumentType documentType, long id, Date dateUpdate, User userCreator, User userUpdater) {
        super(id, dateUpdate, userCreator, userUpdater);
        this.name = name;
        this.number = number;
        this.startDate = startDate;
        this.description = description;
        this.file = file;
        this.documentType = documentType;
    }
    
    
    

//<editor-fold defaultstate="collapsed" desc="get-set">
    //<editor-fold defaultstate="collapsed" desc="name, number, startDate - идентификационные данные документа">
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
    
    /**
     * номер документа
     * @return номер документа
     */
    public String getNumber() {
        return number;
    }
    
    /**
     * номер документа
     * @param number номер документа
     */
    public void setNumber(String number) {
        this.number = number;
    }
    
    /**
     * дата подписания
     * @return дата подписания
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * дата подписания
     * @param startDate дата подписания
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="desription, file - содержание документа">
    /**
     * краткое описание
     * @return краткое описание
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * краткое описание
     * @param description краткое описание
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * прикрепленный файл
     * @return прикрепленный файл
     */
    public String getFile() {
        return file;
    }
    
    /**
     * прикрепленный файл
     * @param file прикрепленный файл
     */
    public void setFile(String file) {
        this.file = file;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="documentType - тип документа">
    /**
     * тип документа
     * @return тип документа
     */
    public DocumentType getDocumentType() {
        return documentType;
    }
    
    /**
     * тип документа
     * @param documentType тип документа
     */
    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
//</editor-fold>
//</editor-fold>

    @Override
    public String toString() {
        return "Document{" +super.toString()+ "name=" + name + ", number=" + number + ", startDate=" + getStringService().getDateString(startDate) + ", description=" + description + ", file=" + file + /*", documentType=" +(documentType==null?" ":documentType.getName()) +*/ '}';
    }
}
