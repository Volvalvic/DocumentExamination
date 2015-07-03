/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rzd.vivc.documentexamination.model.dto.documents.Document;

/**
 * Интерфейс репозитория для документов {@link Document}
 *
 * @author VVolgina
 */
public interface DocumentRepository extends JpaRepository<Document, Long>, DocumentFilter{

    /**
     * Выгрузка из БД всех документов данного типа
     * @param type id типа документа
     * @return список документов
     */
    @Query("SELECT d FROM Document d LEFT JOIN d.documentType as t WHERE t.id = :type")
    public List<Document> find(@Param("type") long type);
}
