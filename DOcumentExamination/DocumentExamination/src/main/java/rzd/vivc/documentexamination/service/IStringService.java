/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.util.Date;

/**
 * Собраны методы для модификации строковых переменных
 *
 * @author VVolgina
 */
public interface IStringService {

    /**
     * Возвращает строку обрезанную до заданной длины.
     *
     * @param str начальная строка
     * @param length заданная длина
     * @return обрезанная строка
     */
    String getCutedString(String str, int length);

    /**
     * Строковое представление даты в формате dd.MM.yyyy Если dat==null, выдает
     * сообщение об отсутстви данных
     *
     * @param dat дата
     * @return строковое представление
     */
    String getDateString(Date dat);
}
