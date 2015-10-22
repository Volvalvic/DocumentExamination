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
import rzd.vivc.documentexamination.form.DateFilter;
import rzd.vivc.documentexamination.form.DocumentLine;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.model.dto.documents.DocumentType;

/**
 * Реализация репозитория для документов
 *
 * @author VVolgina
 */
public class DocumentRepositoryImpl implements DocumentFilter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Document> findFiltered(String name, String number, Date startDate, String description, long documentTypeID) {
        return getFilteredAll(name, number, startDate, description, documentTypeID, null);
    }

    @Override
    public List<Document> findFiltered(String name, String number, Date startDate, String description, long documentTypeID, DateFilter dateFilter) {
        return getFilteredAll(name, number, startDate, description, documentTypeID, dateFilter);
    }

    @Override
    public List<Document> findFiltered(DateFilter dateFilter) {
        return getFilteredAll(null, null, null, null, 0, dateFilter);
    }

    @Override
    public List<DocumentLine> getFilteredLines(DateFilter documentFilter) {
        StringBuilder query = new StringBuilder("SELECT new rzd.vivc.documentexamination.form.DocumentLine(d.id, d.name, d.number, d.startDate, (select count(e.id) from d.examinations e where e.checked=true)) FROM Document AS d ");
        //Если присутствуют даннные для фильтра добавляем where. все необходимые условия добавляем в строку запроса
        if (documentFilter != null) {
            query.append("WHERE ");
            query.append("d.startDate>=:start AND d.startDate<=:finish  ");
            if (!documentFilter.getName().isEmpty()) {
                query.append("AND d.name like :name ");
            }
        }

        Query createQuery = em.createQuery(query.toString());
        if (documentFilter != null) {
            createQuery.setParameter("start", documentFilter.getFrom(), TemporalType.DATE);
            createQuery.setParameter("finish", documentFilter.getTo(), TemporalType.DATE);
            if (!documentFilter.getName().isEmpty()) {
                createQuery.setParameter("name", '%'+documentFilter.getName()+'%');
            }
        }
        return (List<DocumentLine>) createQuery.getResultList();
    }

    private List<Document> getFilteredAll(String name, String number, Date startDate, String description, long documentTypeID, DateFilter documentFilter) {
        StringBuilder query = new StringBuilder("SELECT d FROM Document AS d ");
        //Если присутствуют даннные для фильтра добавляем where. все необходимые условия добавляем в строку запроса
        if (name != null && !name.isEmpty() || number != null && !number.isEmpty() || startDate != null || description != null && !description.isEmpty() || documentTypeID != 0 || documentFilter != null) {
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
            if (description != null && !description.isEmpty()) {
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
            if (documentFilter != null) {
                query.append("d.startDate>=:start AND d.startDate<=:finish  ");
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
        if (description != null && !description.isEmpty()) {
            createQuery.setParameter("description", "%" + description + "%");
        }
        if (documentTypeID != 0) {
            createQuery.setParameter("type", type);
        }
        if (documentFilter != null) {
            createQuery.setParameter("start", documentFilter.getFrom(), TemporalType.DATE);
            createQuery.setParameter("finish", documentFilter.getTo(), TemporalType.DATE);
        }
        return (List<Document>) createQuery.getResultList();
    }
}
