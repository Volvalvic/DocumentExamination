/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.form;

import java.util.Date;
import javax.persistence.Temporal;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.model.dto.documents.DocumentType;
import rzd.vivc.documentexamination.model.dto.users.Department;

/**
 * Документ для формы редактирования
 *
 * @author VVolgina
 */
public class DocumentForm {

    //<editor-fold defaultstate="collapsed" desc="поля">
    //id документа
    private long id;
    //Название документа
    //сообщения для валидайии сожержатся в файле
    //ValidationMessages в корне
    @NotNull(message = "{valid.exists}")
    @Size(min = 1, max = 100, message = "{valid.size}")
    private String name;
    //номер документа
    @NotNull(message = "{valid.exists}")
    @Size(min = 1, max = 100, message = "{valid.size}")
    private String number;
    @DateTimeFormat(pattern = "dd-MM-yy")
    private Date startDate;
    //краткое описание
    @Size(max = 255, message = "{valid.size}")
    private String description;
    //прикрепленный файл
    private Part file;
    //Название прикрепленного фала
    private String fileName;
    //ссылка к файлу
    private String filePath;
    //тип документа
    private long typeID;
    //подразделение
    private long departmentID;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="get-set">
    /**
     * id
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * id
     *
     * @param id id
     */
    public void setId(long id) {
        this.id = id;
    }

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
    public Part getFile() {
        return file;
    }

    /**
     * прикрепленный файл
     *
     * @param file прикрепленный файл
     */
    public void setFile(Part file) {
        this.file = file;
    }

    /**
     * Название прикрепленного файла
     *
     * @return название прикрепленного файла
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Название прикрепленного файла
     *
     * @param fileName Название прикрепленного файла
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * ссылка к файлу
     * @return ссылка к файлу
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * ссылка к файлу
     * @param filePath ссылка к файлу
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="documentType - тип документа">
    /**
     * тип документа
     *
     * @return тип документа
     */
    public long getTypeID() {
        return typeID;
    }

    /**
     * тип документа
     *
     * @param typeID тип документа
     */
        public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    /**
     * подразделение
     * @return подразделение
     */
    public long getDepartmentID() {
        return departmentID;
    }

    /**
     * подразделение 
     * @param departmentID подразделение
     */
    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
    }    
//</editor-fold>

//</editor-fold>

    public DocumentForm() {
    }

    public DocumentForm(Document document) {
        this.id = document.getId();
        this.name = document.getName();
        this.number = document.getNumber();
        this.startDate = document.getStartDate();
        this.description = document.getDescription();
        this.fileName = document.getFile();
        this.typeID = document.getDocumentType()==null?0:document.getDocumentType().getId();
        this.departmentID=document.getDepartment()==null?0:document.getDepartment().getId();
    }
    
    
    
    /**
     * создает экземпляр документа из данных формы
     *
     * @return экземпляр документа из данных формы
     */
    public Document toDocument() {
        return new Document(name, number, startDate, description, fileName, typeID==0?null:new DocumentType(typeID), departmentID==0?null:new Department(departmentID), id);
    }

    @Override
    public String toString() {
        return "DocumentForm{" + "id=" + id + ", name=" + name + ", number=" + number + ", startDate=" + startDate + ", description=" + description +", fileName=" + fileName + ", typeID=" + typeID + '}';
    }   
}
