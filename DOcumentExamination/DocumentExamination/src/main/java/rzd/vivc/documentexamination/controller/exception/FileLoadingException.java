/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Ошибка при сохранении файла
 * @author VVolgina
 */
//какй http статус олжен возникать при данной ошибке
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Не удалось загрузить файл")
public class FileLoadingException extends RuntimeException{
    
}
