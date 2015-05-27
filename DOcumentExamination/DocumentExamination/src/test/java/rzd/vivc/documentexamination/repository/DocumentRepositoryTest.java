/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.model.dto.documents.DocumentTestConfig;
import rzd.vivc.documentexamination.service.IStringService;

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
        assertEquals(1, documentRepository.count());
    }

    @Test
    @Transactional
    public void save() {
        Document document = new Document();
        documentRepository.save(document);
        assertEquals(2, documentRepository.count());
        System.out.println(document);
    }
    
        @Test
    @Transactional
    public void saveExisted() {
        Document document = new Document(1);
        document.setName("new");
        documentRepository.save(document);
        assertEquals(1, documentRepository.count());
        
        document =documentRepository.getOne(1l);
        assertEquals("new", document.getName());
        System.out.println(document);
    }
}
