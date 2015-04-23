package rzd.vivc.documentexamination.model.dto.security;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import rzd.vivc.documentexamination.model.dto.base.BaseEntity;

/**
 * Описание аккаунта пользователя. логин-пароль, права(тип пользователя) Для
 * БД. Анотации под хибернейт
 *
 * @author Zdislava
 *
 */
@Entity
@Table(name = "ACCOUNT")
public class Account extends BaseEntity implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Поля">
    //e-mail
    @Column(name = "EMAIL   ")
    private String email = "";

    //логин
    @NaturalId(mutable = true)
    @Column(name = "LOGIN")
    private String login;
    //пароль
    @Column(name = "PASSWORD")
    private String password;

    //тип пользователя
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_TYPE_ID", nullable = false)
    private Role userType;
    //</editor-fold>
    
    public Account() {
        super();
    }

    //<editor-fold defaultstate="collapsed" desc="get-set">
//<editor-fold defaultstate="collapsed" desc="email - контактная информация">
   
    /**
     * E-mail
     *
     * @return E-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * E-mail
     *
     * @param email E-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="login, password - авторизация">
    /**
     * возвращает логин
     *
     * @return логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * назначает логин
     *
     * @param login логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * возвращает пароль
     *
     * @return пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * назначает пароль
     *
     * @param password пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="userType - права">
    /**
     * Тип пользователя
     *
     * @return тип пользователя
     */
    public Role getUserType() {
        return userType;
    }

    /**
     * Тип пользователя
     *
     * @param userType Тип пользователя
     */
    public void setUserType(Role userType) {
        this.userType = userType;
    }

//</editor-fold>

    //</editor-fold>
    @Override
    public String toString() {
        return "User{" + super.toString() + ", email=" + email + ", login=" + login + ", password=" + password + ", userType=" + (userType == null ? "" : userType.getName()) + '}';
    }
}
