/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import rzd.vivc.documentexamination.model.dto.base.BaseEntity;

/**
 * Интерфейс для простановки даты сохранения/обновления
 * @author VVolgina
 */
public interface SaverWIthAdditionalInfo{

    /**
     * Просавляет в объекте инфо о времени авторе сохранения
     * @param entity
     */
    void addAdditionalInfo(BaseEntity entity);
}
