/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.io.IOException;
import rzd.vivc.documentexamination.form.DocumentForm;

/**
 * Сервис сохранения загруженных файлов 
 * @author VVolgina
 */
public interface FileSavingService {

    /**
     * Сохранение загруженной на сайт информации
     * @param document документ
     * @throws IOException ошибки при сохранении
     */
    void saveUploadedFile(DocumentForm document) throws IOException;
    
    /**
     * Возвращает ссылку для доступа к файлу
     * @param fileName имя файла
     * @return ссылка для доступа к файлу
     */
    String getFileLink(String fileName);
    
    /**
     * Проставляет в документе путь к файлу
     * @param document документ
     */
    void addFileLink(DocumentForm document);
}
