/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rzd.vivc.documentexamination.model.dto.documents.DocumentType;
import rzd.vivc.documentexamination.model.dto.documents.Examination;

/**
 * Интерфейс репозитория для Типов документов {@link DocumentType}
 *
 * @author VVolgina
 */
public interface ExaminationRepository extends JpaRepository<Examination, Long>, ExaminationFilter {

}
