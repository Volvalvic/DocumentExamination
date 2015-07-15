/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.Part;
import org.springframework.stereotype.Component;

/**
 * Сохраняет на диск загруженные файлы
 *
 * @author VVolgina
 */
@Component
public class FileSavingToDiskService implements FileSavingService {

    @Override
    public String saveUploadedFile(Part file) throws IOException {

        if (file==null||file.getSize() < 0) {
            //если файл не был загружен, в качестве его названия возвращаем пустую строку
            return "";
        } else {
            String address = "C:" + File.separator + File.separator + "documents" + File.separator;
            String name = file.getSubmittedFileName();
            while ((new File(address + name)).exists()) {
                String[] split = name.split(".");
                name = split[split.length - 2] + UUID.randomUUID().toString() + split[split.length - 1];
            }
            file.write(address + name);
            return name;
        }
    }

}
