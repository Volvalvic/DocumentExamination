/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.model.dto.documents;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import rzd.vivc.documentexamination.model.dto.base.NamedEntity;

/**
 * Вид документа. Телеграмма/ распоряжение, и.т.д Для БД. Анотации под хибернейт
 *
 * @author VVolgina
 */
@Entity
@Table(name = "DOCUMENT_TYPE")
public class DocumentType extends NamedEntity implements Serializable {

    public DocumentType(long id) {
        super(id);
    }

    public DocumentType() {
    }

    @Override
    public String toString() {
        return "DocumentType{" + super.toString() + '}';
    }
}
