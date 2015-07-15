/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.io.IOException;
import javax.servlet.http.Part;

/**
 * Сервис сохранения загруженных файлов 
 * @author VVolgina
 */
public interface FileSavingService {

    /**
     * Сохранение загруженной на сайт информации
     * @param file загруженные данные
     * @return название сохраненного файла, либо пустую строку, если файл не был загружен
     * @throws IOException ошибки при сохранении
     */
    String saveUploadedFile(Part file) throws IOException;
}
