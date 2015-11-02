/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import rzd.vivc.documentexamination.form.DateFilter;
import rzd.vivc.documentexamination.form.ExaminationLine;
import rzd.vivc.documentexamination.model.dto.documents.Examination;

/**
 *
 * @author Life
 */
public class ExaminationRepositoryImpl implements ExaminationFilter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ExaminationLine> findByUserAndDate(String login, DateFilter dateFilter) {
        StringBuilder queryString=new StringBuilder("SELECT new rzd.vivc.documentexamination.form.ExaminationLine(ex.id, ex.document.name, ex.document.number, ex.document.name, ex.checked, ex.document.id, ex.user.id, ex.startDate) FROM Examination ex ")
                                                              .append("WHERE ex.user.account.login LIKE :login AND ex.document.startDate>=:start AND ex.document.startDate<=:finish AND (ex.document.department=ex.user.department OR ex.document.department is null)");
        String name=dateFilter.getName();
        if(!name.isEmpty()){
            queryString.append(" AND ex.document.name like :name");
        }
        Query createQuery = em.createQuery(queryString.toString());
        createQuery.setParameter("login", login).setParameter("start", dateFilter.getFrom(), TemporalType.DATE).setParameter("finish", dateFilter.getTo(), TemporalType.DATE);
        if(!name.isEmpty()){
            createQuery.setParameter("name",'%'+ name+'%');
        }
        return (List<ExaminationLine>) createQuery.getResultList();
    }

    @Override
    public Examination findWithDependencies(long id) {
        Query createQuery = em.createQuery("SELECT ex FROM Examination ex LEFT JOIN FETCH ex.document LEFT JOIN FETCH ex.user WHERE ex.id=:id");
        createQuery.setParameter("id", id);
        return (Examination) createQuery.getResultList().get(0);
    }

    @Override
    public List<ExaminationLine> findByDocument(long documentID) {
        Query createQuery = em.createQuery("SELECT new rzd.vivc.documentexamination.form.ExaminationLine(ex.id, ex.document.name, ex.document.number, ex.user.surname || ' ' ||ex.user.name || ' ' ||ex.user.patronomicname, ex.checked, ex.document.id, ex.user.id, ex.startDate) FROM Examination ex WHERE ex.document.id=:userID and (ex.document.department is null or ex.document.department=ex.user.department)");
        createQuery.setParameter("userID", documentID);
        List<ExaminationLine> examinationLines = (List<ExaminationLine>) createQuery.getResultList();
        return examinationLines;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); // это будет начало месяца
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date start = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date finish = calendar.getTime();

    }
}
