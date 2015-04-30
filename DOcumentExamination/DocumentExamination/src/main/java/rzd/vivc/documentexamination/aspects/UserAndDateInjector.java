/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.aspects;

import java.util.Date;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import rzd.vivc.documentexamination.model.dto.base.BaseEntity;
import rzd.vivc.documentexamination.model.dto.users.User;

/**
 * Добавляет к сохраняемым объектам дату последнего обновления
 *
 * @author VVolgina
 */
@Aspect
public class UserAndDateInjector {

    /**
     * Сохранение в БД сущности
     */
    @Pointcut("execution(** rzd.vivc.documentexamination.repository.*Repository.save(..)) && args(entity)")
    private void saving(BaseEntity entity) {
    }

    @Before("saving(entity)")
    public void validateAccount(BaseEntity entity) {
        User user = new User(1);
        if(entity.getUserCreator()==null){
            entity.setUserCreator(user);
        }
        entity.setUserUpdater(user);
        entity.setDateUpdate(new Date());
    }
}
