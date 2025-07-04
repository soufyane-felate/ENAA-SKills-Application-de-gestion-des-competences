package com.EnaaSkills.EnaaSkills.Services;


import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Models.SubCompetence;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExcelExportService {

    public void exportCompetencesToExcel(List<Competence> competences, OutputStream outputStream) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Rapport de Compétences");

            CellStyle headerStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeight(14);
            headerStyle.setFont(font);

            Row headerRow = sheet.createRow(0);
            String[] headers = {"Competence id", "Soub-Competence id ", "Competence name", "Soub-Competence name", "description"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (Competence competence : competences) {
                if (competence.getSubCompetences() != null && !competence.getSubCompetences().isEmpty()) {
                    for (SubCompetence sousCompetence : competence.getSubCompetences()) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(competence.getId());
                        row.createCell(1).setCellValue(sousCompetence.getId());
                        row.createCell(2).setCellValue(competence.getName());
                        row.createCell(3).setCellValue(sousCompetence.getName());
                        row.createCell(4).setCellValue(competence.getDescription());
                    }
                } else {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(competence.getId());
                    row.createCell(2).setCellValue(competence.getName());
                    row.createCell(4).setCellValue(competence.getDescription());
                }
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(outputStream);
        }
    }
}