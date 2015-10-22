/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

/**
 * Содержит информацию об общем к-ве пользователей системы
 * @author VVolgina
 */
public interface UserCreatedService {

    /**
     *Получить общее к-во пользователей
     * @return  общее к-во пользователей
     */
    int getTotalCount();

    /**
     * Обновить  общее к-во пользователей
     */
    void updateTotalCount();
}
