/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rzd.vivc.documentexamination.model.dto.exception.ExistingUserException;

/**
 * В этом классе собраны обработчики оштбок для всех страниц
 * @author VVolgina
 */
@ControllerAdvice
public class AppWideExceptionHandler {
        
    //Обработка ошибки при попытке создать второго пользователя с таким же логином.
    @ExceptionHandler(ExistingUserException.class)
    public String handleExisingUserException(){
        return "error/duplicate";
    }
}
