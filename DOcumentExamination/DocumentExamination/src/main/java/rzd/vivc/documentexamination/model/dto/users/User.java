package rzd.vivc.documentexamination.model.dto.users;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import rzd.vivc.documentexamination.model.dto.base.BaseEntity;

/**
 * Описание пользователя системы. ФИО Для
 * БД. Анотации под хибернейт
 *
 * @author Zdislava
 *
 */
@Entity
@Table(name = "USER")
public class User extends BaseEntity implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Поля">
    //имя
    @Column(name = "NAME")
    private String name = "";
    //фамилия
    @Column(name = "SURNAME")
    private String surname = "";
    //отчество
    @Column(name = "PATRONOMICNAME")
    private String patronomicname = "";

    //номер телефона
    @Column(name = "PHONE")
    private String phoneNumber = "";

    //дополнительная информация
    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo = "";

    //подразделение
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department", nullable = false)
    private Department department = new Department();
    //</editor-fold>

    public User() {
        super();
    }

    public User(long i) {
        super(i);
    }

    //<editor-fold defaultstate="collapsed" desc="get-set">
//<editor-fold defaultstate="collapsed" desc="name, surname, patronomicname - ФИО">
    /**
     * возвращвет имя пользователя
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * назначает имя пользователя
     *
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * возвращает фамилию пользователя
     *
     * @return фамилия
     */
    public String getSurname() {
        return surname;
    }

    /**
     * назначает фамилию пользователя
     *
     * @param surname фамилия
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * возвращает отчество пользователя
     *
     * @return отчество
     */
    public String getPatronomicname() {
        return patronomicname;
    }

    /**
     * назначает отчество пользователя
     *
     * @param patronomicname отчество
     */
    public void setPatronomicname(String patronomicname) {
        this.patronomicname = patronomicname;
    }

    /**
     * Возвращает ФИО пользователя
     *
     * @return ФИО
     */
    public String getFIO() {
        return surname + " " + name + " " + patronomicname;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="phoneNumber, email - контактная информация">
    /**
     * Номер телефона
     *
     * @return номер телефона
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Номер телефона
     *
     * @param phoneNumber номер телефона
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="additionalInfo - Дополнительная информация">
    /**
     * Дополнительная информация
     *
     * @return Дополнительная информация
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Дополнительная информация
     *
     * @param additionalInfo Дополнительная информация
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="department - служба, в которой работает пользователь">
    /**
     * Возвращает службу, в которой работает пользователь
     *
     * @return служба, в которой работает пользователь
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * служба, в которой работает пользователь
     *
     * @param department служба, в которой работает пользователь
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
//</editor-fold>

    //</editor-fold>
    @Override
    public String toString() {
        return "User{" + super.toString() + "name=" + name + ", surname=" + surname + ", patronomicname=" + patronomicname + ", phoneNumber=" + phoneNumber + ", additionalInfo=" + additionalInfo + ", department=" + (department == null ? "" : department.getId() + " " + department.getName()) + '}';
    }
}
