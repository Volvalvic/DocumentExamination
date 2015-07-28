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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import rzd.vivc.documentexamination.model.dto.users.User;

/**
 * Флаг, показывающий, ознакомился ли пользователь с документом. Для БД.
 * Анотации под хибернейт
 *
 * @author VVolgina
 */
@Entity
@Table(name = "EXAMINATION")
public class Examination implements Serializable {

    //id записи
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    //документ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID")
    private Document document;

    //пользователь
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    //флаг, ознакомлен, или нет
    @Column(name = "CHECKED")
    private boolean checked=false;

    //дата ознакомления
    @Column(name = "START_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;

    //<editor-fold defaultstate="collapsed" desc="get-set">
    //<editor-fold defaultstate="collapsed" desc="id - id записи">
    /**
     * Возвращает id. Генерируется автоматически
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Назначает id. Генерируется автоматически
     *
     * @param id id
     */
    public void setId(long id) {
        this.id = id;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="User, document - связь с другими таблицами">
    /**
     * документ
     *
     * @return документ
     */
    public Document getDocument() {
        return document;
    }

    /**
     * документ
     *
     * @param document документ
     */
    public void setDocument(Document document) {
        this.document = document;
    }

    /**
     * пользователь
     *
     * @return пользователь
     */
    public User getUser() {
        return user;
    }

    /**
     * пользователь
     *
     * @param user пользователь
     */
    public void setUser(User user) {
        this.user = user;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="checked - флаг, ознакомлен, или нет">
    /**
     * флаг, ознакомлен, или нет
     *
     * @return флаг, ознакомлен, или нет
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * флаг, ознакомлен, или нет
     *
     * @param checked флаг, ознакомлен, или нет
     */
    public void setChecked(boolean checked) {  
        //TODO Засунуть это в аспект при сохранении
        if(!this.checked && checked){
            startDate=new Date();
        }
        this.checked = checked;

    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="дата ознакомления">

    /**
     *дата ознакомления
     * @return дата ознакомления
     */
        public Date getStartDate() {
        return startDate;
    }
    
    /**
     * дата ознакомления
     * @param startDate дата ознакомления
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
//</editor-fold>
    
    //</editor-fold>

    public Examination(long documentID, long userID) {
        document=new Document(documentID);
        user=new User(userID);
    }

    public Examination() {
    }
    
    

    @Override
    public String toString() {
        return "Examination{" + "id=" + id + ", document=" + (document == null ? " " : document.getName()) + ", user=" + (user == null ? " " : user.getFIO()) + ", checked=" + checked + '}';
    }

}
