/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import rzd.vivc.documentexamination.model.dto.security.Account;
import rzd.vivc.documentexamination.model.dto.users.User;

/**
 *
 * @author Life
 */
@Transactional(readOnly = true)
public class AccountRepositoryImpl implements AccountFilter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Account findWithDependencies(Long userID) {
        TypedQuery createQuery = em.createQuery("SELECT a FROM Account a LEFT JOIN FETCH a.user u LEFT JOIN FETCH u.department  WHERE u.id=:id", Account.class);
         createQuery.setParameter("id",userID);
         return (Account)createQuery.getResultList().get(0);
    }
}
