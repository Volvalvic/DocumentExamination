/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import rzd.vivc.documentexamination.model.dto.security.Account;

/**
 * Дополнительные методы для  аккаунтов
 * @author VVolgina
 */
public interface AccountFilter {

    /**
     * аккаунт с информацией об отделе
     * @param accountID id пользователя
     * @return пользователь с информацией об отделе
     */
    Account findWithDependencies(Long userID);

}
