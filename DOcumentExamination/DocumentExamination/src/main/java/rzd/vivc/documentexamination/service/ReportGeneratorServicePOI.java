/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;
import rzd.vivc.documentexamination.form.DateFilter;
import rzd.vivc.documentexamination.form.DocumentLine;
import rzd.vivc.documentexamination.form.ExaminationLine;

@Component
public class ReportGeneratorServicePOI implements ReportGeneratorService {

    @Override
    public String generateReportDoc(List<DocumentLine> documentLines, long total, DateFilter dateFilter) {
        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream("c://Documents/1/reportDoc.xls");
            wb = new HSSFWorkbook(in);
        } catch (IOException ex) {
            Logger.getLogger(ReportGeneratorServicePOI.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(2);
        cell.setCellValue(dateFilter.getFromString());
        cell = row.getCell(4);
        cell.setCellValue(dateFilter.getToString());
        int i = 2;
        for (DocumentLine line : documentLines) {
            Row createRow = sheet.createRow(i++);
            Cell createCell = createRow.createCell(0);
            createCell.setCellValue(line.getName());
            createCell = createRow.createCell(1);
            createCell.setCellValue(line.getNum());
            createCell = createRow.createCell(2);
            createCell.setCellValue(line.getRegistrationDateString());
            createCell = createRow.createCell(3);
            createCell.setCellValue(line.getChecked());
            createCell = createRow.createCell(4);
            createCell.setCellValue(total - line.getChecked());
        }

        String tail = new Date().getTime() + ".xls";
        String addr = "c://Documents/1/reportDoc" + tail;
        File file = new File(addr);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ReportGeneratorServicePOI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            wb.write(new FileOutputStream(file));
            wb.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportGeneratorServicePOI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReportGeneratorServicePOI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "docs/1/reportDoc" + tail;
    }

    @Override
    public String generateReportUsersForDoc(List<ExaminationLine> examinationLines, int percentage) {
        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream("c://Documents/1/usersDoc.xls");
            wb = new HSSFWorkbook(in);
        } catch (IOException ex) {
            Logger.getLogger(ReportGeneratorServicePOI.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(3);
        cell.setCellValue(examinationLines.get(0).getName());
        int i = 2;
        for (ExaminationLine line : examinationLines) {
            if (!line.isChecked()) {
                Row createRow = sheet.createRow(i++);
                Cell createCell = createRow.createCell(0);
                createCell.setCellValue(line.getFio());
            }
        }
        Row createRow = sheet.createRow(i);
        Cell createCell = createRow.createCell(0);
        createCell.setCellValue("Всего ознакомлено:");
        createCell = createRow.createCell(1);
        createCell.setCellValue(percentage + "%");
        String tail = new Date().getTime() + ".xls";
        String addr = "c://Documents/1/usersDoc" + tail;
        File file = new File(addr);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ReportGeneratorServicePOI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            wb.write(new FileOutputStream(file));
            wb.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportGeneratorServicePOI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReportGeneratorServicePOI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "docs/1/usersDoc" + tail;
    }

    public static void main(String[] args) {

    }

}
