/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

/**
 * Информация о текущем авторизованном пользователе
 * @author VVolgina
 */
public interface AuthenticationInfoService {
    
    /**
     * Логин авторизованного пользователя
     * @return логин авторизованного пользователя
     */
    String getLogin();
}
