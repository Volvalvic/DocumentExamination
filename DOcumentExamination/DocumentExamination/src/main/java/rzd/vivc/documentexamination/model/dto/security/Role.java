/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.model.dto.security;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import rzd.vivc.documentexamination.model.dto.base.NamedEntity;

/**
 *  * Описывает возможные типы пользователей в системе. Пользователи разных
 * типов могут обладать разными правами при доступе к элементам системы Например
 * пользователь, только просмотр, администратор. Для БД. Анотации под хибернейт
 *
 * @author VVolgina
 */
@Entity
@Table(name = "ROLE")
public class Role extends NamedEntity implements Serializable {

//<editor-fold defaultstate="collapsed" desc="поля">
    //права
    @Column(name = "AUTORITY", length = 100)
    @NotNull(message = "{valid.exists}")
    private String autority = "";
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="get-set">

    /**
     * права
     * @return права
     */
        public String getAutority() {
        return autority;
    }
    
    /**
     * права
     * @param autority права
     */
    public void setAutority(String autority) {
        this.autority = autority;
    }
//</editor-fold>

    
    
    @Override
    public String toString() {
        return "Role{" + super.toString() + '}';
    }
}
