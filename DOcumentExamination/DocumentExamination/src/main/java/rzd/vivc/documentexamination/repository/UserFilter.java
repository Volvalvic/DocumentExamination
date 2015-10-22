/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import rzd.vivc.documentexamination.model.dto.users.User;

/**
 * Дополнительные методы для пользователей
 * @author VVolgina
 */
public interface UserFilter {

    /**
     * пользователь с информацией об отделе
     * @param userID id пользователя
     * @return пользователь с информацией об отделе
     */
   User findWithDependencies(Long userID);

    /**
     * Общее к-во зарегистрированных пользователй
     * @return Общее к-во зарегистрированных пользователй
     */
    int getTotalCount();
}
