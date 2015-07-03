/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.model.dto.base;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import rzd.vivc.documentexamination.model.dto.users.User;
import rzd.vivc.documentexamination.service.IStringService;
import rzd.vivc.documentexamination.service.StringImprover;

/**
 *Базовый класс для классов под хибернейт
 * @author VVolgina
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Поля">
    //id записи
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    //дата создания
    @Column(name = "dt_create", nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreate = new Date();

    //дата последнего изменения
    @Column(name = "dt_update", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateUpdate;

    //пользователь, создавший запись
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_create", updatable = false, nullable = false)
    private User userCreator;

    //пользователь, последним изменивший запись
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_update", nullable = false)
    private User userUpdater;

    /**
     * средство для обработки строк
     */
    @Transient
    protected StringImprover stringService=new StringImprover();
    //</editor-fold>

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

    //<editor-fold defaultstate="collapsed" desc="dateCreate - дата создания">
    /**
     * Извлекает дату создания. Генерируется автоматически при создании объекта
     *
     * @return Дата создания
     */
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * Добавить дату создания
     *
     * @param dateCreate Дата создания
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * Возвращает строковое представление даты создания
     *
     * @return строковое представление даты создания
     */
    public String getDateCreateString() {
        return stringService.getDateString(dateCreate);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="dateUpdate - дата последнего изменения ">
    /**
     * дата последнего изменения
     *
     * @return дата последнего изменения
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * дата последнего изменения
     *
     * @param dateUpdate дата последнего изменения
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="userCreator - пользователь, создавший запись">
    /**
     * пользователь, создавший запись
     *
     * @return пользователь, создавший запись
     */
    public User getUserCreator() {
        return userCreator;
    }

    /**
     * пользователь, создавший запись
     *
     * @param userCreator пользователь, создавший запись
     */
    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="userUpdater - пользователь, последним изменивший запись">
    /**
     * пользователь, последним изменивший запись
     *
     * @return пользователь, последним изменивший запись
     */
    public User getUserUpdater() {
        return userUpdater;
    }

    /**
     * пользователь, последним изменивший запись
     *
     * @param userUpdater пользователь, последним изменивший запись
     */
    public void setUserUpdater(User userUpdater) {
        this.userUpdater = userUpdater;
    }
//</editor-fold>
    //</editor-fold>

    /**
     * Создание объекта
     *
     * @param userCreator пользователь, создавший объект
     */
    public BaseEntity(User userCreator) {
        this.userCreator = userCreator;
    }

    /**
     * Создание объекта
     */
    public BaseEntity() {
    }

    /**
     * Создание объекта
     *
     * @param id id объекта
     */
    public BaseEntity(long id) {
        this.id = id;
    }

    public BaseEntity(long id, Date dateUpdate, User userCreator, User userUpdater) {
        this.id = id;
        this.dateUpdate = dateUpdate;
        this.userCreator = userCreator;
        this.userUpdater = userUpdater;
    }
    
    

    //<editor-fold defaultstate="collapsed" desc="сгенерированное">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + Objects.hashCode(this.dateCreate);
        hash = 19 * hash + Objects.hashCode(this.dateUpdate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseEntity other = (BaseEntity) obj;
        return this.id == other.getId();
    }

    @Override
    public String toString() {
        return "id=" + id + ", dateCreate=" + stringService.getDateString(dateCreate) + ", dateUpdate=" + stringService.getDateString(dateUpdate)  /*+", userCreator=" + (userCreator == null ? "" : userCreator.getFIO()) + ", userUpdater=" + (userUpdater == null ? "" : userUpdater.getFIO()) */+ " ";
    }
//</editor-fold>

}
