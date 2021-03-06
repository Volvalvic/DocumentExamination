/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.model.dto.documents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import rzd.vivc.documentexamination.model.dto.base.BaseEntity;
import rzd.vivc.documentexamination.model.dto.users.Department;
import rzd.vivc.documentexamination.model.dto.users.User;

/**
 * Документы для ознакомления. Для БД. Анотации под хибернейт
 *
 * @author VVolgina
 */
//TODO Разбить на 2 класса, один с ограничениями для web, второй для bd
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
    private String name;
    //номер документа
    @Column(name = "NUMBER", length = 100)
    private String number;
    //дата подписания, должна быть в прошлом
    @Column(name = "START_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;

    //краткое описание
    @Column(name = "DESCRIPTION")
    private String description;
    //прикрепленный файл
    @Column(name = "FILE", nullable = true)
    private String file;

    //тип документа
    @ManyToOne
    @JoinColumn(name = "DOCUMENT_TYPE_ID")
    private DocumentType documentType;
    
    //список ознакомлений для документа
    @OneToMany(mappedBy = "document")
    private List<Examination> examinations=new ArrayList<>();
    
    //Группа пользователей, для которых предназначен документ
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", nullable = true)
    private Department department;

//</editor-fold>epartment

    public Document() {
    }

    public Document(long i) {
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

    public Document(String name, String number, Date startDate, String description, DocumentType documentType, long id) {
        super(id);
        this.name = name;
        this.number = number;
        this.startDate = startDate;
        this.description = description;
        this.documentType = documentType;
    }

    public Document(String name, String number, Date startDate, String description, String file, DocumentType documentType, long id) {
        super(id);
        this.name = name;
        this.number = number;
        this.startDate = startDate;
        this.description = description;
         this.file = file;
        this.documentType = documentType;
    }

    public Document(String name, String number, Date startDate, String description, String file, DocumentType documentType, Department department, long id) {
        super(id);
        this.name = name;
        this.number = number;
        this.startDate = startDate;
        this.description = description;
        this.file = file;
        this.documentType = documentType;
        this.department = department;
    }
    
    

//<editor-fold defaultstate="collapsed" desc="get-set">
    //<editor-fold defaultstate="collapsed" desc="name, number, startDate - идентификационные данные документа">
    /**
     * Название документа
     *
     * @return Название документа
     */
    public String getName() {
        return name;
    }

    /**
     * Название документа
     *
     * @param name Название документа
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * номер документа
     *
     * @return номер документа
     */
    public String getNumber() {
        return number;
    }

    /**
     * номер документа
     *
     * @param number номер документа
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * дата подписания
     *
     * @return дата подписания
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * дата подписания
     *
     * @param startDate дата подписания
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="desription, file - содержание документа">
    /**
     * краткое описание
     *
     * @return краткое описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * краткое описание
     *
     * @param description краткое описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * прикрепленный файл
     *
     * @return прикрепленный файл
     */
    public String getFile() {
        return file;
    }

    /**
     * прикрепленный файл
     *
     * @param file прикрепленный файл
     */
    public void setFile(String file) {
        this.file = file;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="documentType - тип документа">
    /**
     * тип документа
     *
     * @return тип документа
     */
    public DocumentType getDocumentType() {
        return documentType;
    }

    /**
     * тип документа
     *
     * @param documentType тип документа
     */
    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
//</editor-fold>

    /**
     * Список ознакомлений
     * @return Список ознакомлений
     */
    public List<Examination> getExaminations() {
        return Collections.unmodifiableList(examinations);
    }

    /**
     * Список ознакомлений
     * @param examinations Список ознакомлений
     */
    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    /**
     *Группа пользователей, для которых предназначен документ
     * @return Группа пользователей, для которых предназначен документ
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Группа пользователей, для которых предназначен документ
     * @param department Группа пользователей, для которых предназначен документ
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "Document{" + super.toString() + "name=" + name + ", number=" + number + ", startDate=" + getStringService().getDateString(startDate) + ", description=" + description + ", file=" + file + /*", documentType=" +(documentType==null?" ":documentType.getName()) +*/ '}';
    }
}
