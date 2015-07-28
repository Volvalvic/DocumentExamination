/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import com.sun.jndi.url.dns.dnsURLContextFactory;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.Part;
import org.springframework.stereotype.Component;
import rzd.vivc.documentexamination.form.DocumentForm;

/**
 * Сохраняет на диск загруженные файлы
 *
 * @author VVolgina
 */
@Component
public class FileSavingToDiskService implements FileSavingService {

    @Override
    public void saveUploadedFile(DocumentForm document) throws IOException {
        Part file = document.getFile();

        if (file == null || file.getSize() < 0||file.getSubmittedFileName().isEmpty()) {
            //если файл не был загружен, нет необходимости менять имя файла
        } else {
            String address = "C:" + File.separator + File.separator + "documents" + File.separator;
            String name = file.getSubmittedFileName();
            while ((new File(address + name)).exists()) {
                String[] split = name.split(".");
                name = split[split.length - 2] + UUID.randomUUID().toString() + split[split.length - 1];
            }
            file.write(address + name);
            document.setFileName(name);
        }
    }

    @Override
    public String getFileLink(String fileName) {
        return fileName==null||fileName.isEmpty()?"":"docs/"+fileName;
    }

    @Override
    public void addFileLink(DocumentForm document) {
        document.setFilePath(getFileLink(document.getFileName()));
    }

    
}
