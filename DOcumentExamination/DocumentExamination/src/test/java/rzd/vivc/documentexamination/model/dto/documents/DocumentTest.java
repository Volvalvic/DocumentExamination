/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.model.dto.documents;

import java.util.Date;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rzd.vivc.documentexamination.service.IStringService;

/**
 *
 * @author VVolgina
 */        
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DocumentTestConfig.class)
public class DocumentTest {
    
    public DocumentTest() {
    }

    @Autowired
    private IStringService stringService;
    
    @Autowired
    private Document document;
    
    @Test
    public void testToString() {
        document.setDateCreate(new  Date());
        document.setDateUpdate(new Date());
        document.setDescription("Description");
        document.setDocumentType(null);
        document.setFile("file");
        document.setId(1);
        document.setName("name");
        document.setNumber("num1");
        document.setStartDate(new Date());
        document.setUserCreator(null);
        document.setUserUpdater(null);
         String res= "Document{" +"id=" + 1 + ", dateCreate=" + stringService.getDateString(new Date()) + ", dateUpdate=" + stringService.getDateString(new Date())  +  " "+ "name=" + "name" + ", number=" + "num1"+ ", startDate=" + stringService.getDateString(new Date())   + ", description=" + "Description" + ", file=" + "file" + '}';
          assertEquals(res, document.toString());
    }
    
}
