/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.model.dto.security;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import rzd.vivc.documentexamination.model.dto.base.NamedEntity;

/**
 *  * Описывает возможные типы пользователей в системе. Пользователи разных типов
 * могут обладать разными правами при доступе к элементам системы Например
 * пользователь, только просмотр, администратор. Для БД. Анотации под хибернейт
 * @author VVolgina
 */
@Entity
@Table(name = "ROLE")
public class Role extends NamedEntity implements Serializable{
        @Override
    public String toString() {
        return "Role{" + super.toString()+ '}';
    }
}
