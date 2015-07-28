/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rzd.vivc.documentexamination.model.dto.documents.Document;
import rzd.vivc.documentexamination.model.dto.documents.Examination;
import rzd.vivc.documentexamination.model.dto.users.User;
import rzd.vivc.documentexamination.repository.DocumentRepository;
import rzd.vivc.documentexamination.repository.ExaminationRepository;
import rzd.vivc.documentexamination.repository.UserRepository;

/**
 *
 * @author Life
 */
@Repository
@Transactional
public class DocumentsAdditionalSavingServicesRepositoryImpl implements DocumentAdditionalSavingServicesRepository {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExaminationRepository examinationRepository;

    @Override
    public Document saveWythExaminations(Document document) {
        Document save;
        if (document.getId() == 0) {
            save = documentRepository.save(document);
            List<User> findAll = userRepository.findAll();
            for (User user : findAll) {
                Examination examination = new Examination(document.getId(), user.getId());
                examinationRepository.save(examination);
            }
        } else{
            save = documentRepository.save(document);
        }

        return save;
    }

}
