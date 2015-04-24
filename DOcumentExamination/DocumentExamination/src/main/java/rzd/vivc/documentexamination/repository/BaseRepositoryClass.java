/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.util.Date;
import rzd.vivc.documentexamination.model.dto.base.BaseEntity;
import rzd.vivc.documentexamination.model.dto.users.User;

/**
 *Базовый кдасс для репозиториев. ПОзволяет добавлять данные по времени сохранения в БД
 * @author VVolgina
 */
public abstract class BaseRepositoryClass implements SaverWIthAdditionalInfo{

    @Override
    public void addAdditionalInfo(BaseEntity entity) {
       entity.setDateUpdate(new Date());
        User user = new User(1);
       entity.setUserCreator(user);
       entity.setUserUpdater(user);
    }
    
}
