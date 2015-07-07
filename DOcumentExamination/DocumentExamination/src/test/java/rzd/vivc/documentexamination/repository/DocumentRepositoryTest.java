/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import rzd.vivc.documentexamination.model.dto.documents.Document;

/**
 *
 * @author VVolgina
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDateConfig.class)
public class DocumentRepositoryTest {

    public DocumentRepositoryTest() {
    }

    @Autowired
    DocumentRepository documentRepository;

    @Before
    public void setUp() {
    }

    @Test
    @Transactional
    public void count() {
        assertEquals(2, documentRepository.count());
    }

    @Test
    @Transactional
    public void save() {
        Document document = new Document();
        document.setName("1");
        document.setNumber("1");
        documentRepository.save(document);
        assertEquals(3, documentRepository.count());
        System.out.println(document);
    }

    @Test
    @Transactional
    public void saveExisted() {
        Document document = new Document(1);
        document.setName("new");
        document.setNumber("1");
        documentRepository.save(document);
        assertEquals(2, documentRepository.count());

        document = documentRepository.getOne(1l);
        assertEquals("new", document.getName());
        System.out.println(document);
    }
    
     @Test
    @Transactional
    public void findFIltered() throws ParseException {
         SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse("2015-04-22");
        List<Document> findFiltered = documentRepository.findFiltered("12q", "12-54", parse, "st ", 1);
        assertDocument(1, findFiltered.get(0));
         assertEquals(1, findFiltered.size());
         List<Document> findAll = documentRepository.findFiltered(null, null, null, null, 0);
        assertDocument(1, findAll .get(0));
        assertDocument(2, findAll .get(1));
         assertEquals(2, findAll.size());
    }

    private static void assertDocument(int expectedID, Document actual) {
        assertEquals(expectedID, actual.getId());
    }
}
