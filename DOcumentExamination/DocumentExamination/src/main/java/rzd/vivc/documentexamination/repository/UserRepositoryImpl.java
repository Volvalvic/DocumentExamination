/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import rzd.vivc.documentexamination.model.dto.users.User;

/**
 *
 * @author Life
 */
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserFilter {

    @PersistenceContext
    private EntityManager em;

    @Override
    ///TODO почитать про Typed query
    public User findWithDependencies(Long userID) {
         TypedQuery createQuery = em.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.department  WHERE u.id=:id", User.class);
         createQuery.setParameter("id", userID);
         return (User)createQuery.getResultList().get(0);
    }
}
