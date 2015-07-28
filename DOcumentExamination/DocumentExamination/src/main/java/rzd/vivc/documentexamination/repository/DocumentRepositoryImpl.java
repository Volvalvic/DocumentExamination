/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.model.dto.documents.DocumentType;

/**
 * Реализация репозитория для документов
 *
 * @author VVolgina
 */
public class DocumentRepositoryImpl implements DocumentFilter{
    
    

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Document> findFiltered(String name, String number, Date startDate, String description, long documentTypeID) {
        StringBuilder query = new StringBuilder("SELECT d FROM Document AS d ");
        //Если присутствуют даннные для фильтра добавляем where. все необходимые условия добавляем в строку запроса
        if (name != null && !name.isEmpty() || number != null && !number.isEmpty() || startDate != null || description != null && !description.isEmpty() || documentTypeID != 0) {
            query.append("WHERE ");
            boolean firstLine = true;
            if (name != null && !name.isEmpty()) {
                query.append("d.name LIKE :name ");
                firstLine = false;
            }
            if (number != null && !number.isEmpty()) {
                if (!firstLine) {
                    query.append("AND ");
                    firstLine = false;
                }
                query.append("d.number LIKE :number ");
            }
            if (startDate != null) {
                if (!firstLine) {
                    query.append("AND ");
                    firstLine = false;
                }
                query.append("d.startDate = :startDate ");
            }
            if ( description != null && !description.isEmpty()) {
                if (!firstLine) {
                    query.append("AND ");
                    firstLine = false;
                }
                query.append("d.description LIKE :description ");
            }
            if (documentTypeID != 0) {
                if (!firstLine) {
                    query.append("AND ");
                }
                query.append("d.documentType =:type ");
            }
        }
        query.append("ORDER BY d.name");
        
        DocumentType type = new DocumentType(documentTypeID);
        Query createQuery = em.createQuery(query.toString());
         if (name != null && !name.isEmpty()) {
             createQuery.setParameter("name", name);
            }
            if (number != null && !number.isEmpty()) {
                createQuery.setParameter("number", number);
            }
            if (startDate != null) {
                createQuery.setParameter("startDate", startDate, TemporalType.DATE);
            }
            if ( description != null && !description.isEmpty()) {
                createQuery.setParameter("description", "%" + description + "%");
            }
            if (documentTypeID != 0) {
                createQuery.setParameter("type", type);
            }
        return (List<Document>) createQuery.getResultList();
  
    }
    
}
