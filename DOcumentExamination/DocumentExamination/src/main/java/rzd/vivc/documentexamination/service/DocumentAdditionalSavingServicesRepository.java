/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import rzd.vivc.documentexamination.model.dto.documents.Document;

/**
 *
 * @author Life
 */
public interface DocumentAdditionalSavingServicesRepository {
       Document saveWythExaminations(Document document);
}
