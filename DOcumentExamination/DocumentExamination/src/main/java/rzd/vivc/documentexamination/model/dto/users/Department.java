/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.model.dto.users;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import rzd.vivc.documentexamination.model.dto.base.NamedEntity;

/**
 * Отдел/служба/подразделение
 * @author VVolgina
 */
@Entity
@Table(name = "Department")
public class Department extends NamedEntity implements Serializable{
    @Override
    public String toString() {
        return "Department{" + super.toString()+ '}';
    }
}

