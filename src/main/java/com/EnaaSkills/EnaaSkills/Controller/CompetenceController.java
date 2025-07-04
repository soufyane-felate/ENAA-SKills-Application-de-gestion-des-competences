package com.EnaaSkills.EnaaSkills.Controller;

import com.EnaaSkills.EnaaSkills.Dto.CompetenceDTO;
import com.EnaaSkills.EnaaSkills.Dto.SousCompetenceDTO;
import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Services.CompetenceService;
import com.EnaaSkills.EnaaSkills.Services.ExcelExportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Tag(name = "Competence", description = "API for managing competences")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/competences")
public class CompetenceController {

    @Autowired
    private CompetenceService competenceService;
    @Autowired
    private ExcelExportService excelExportService;

    @Operation(summary = "Get all competences")
    @GetMapping
    public List<Competence> getAllCompetences() {
        return competenceService.getAllCompetences();

    }

    @Operation(summary = "Get a competence by ID")
    @GetMapping("/{id}")
    public CompetenceDTO getCompetenceById(@PathVariable Long id) {
        Competence competence = competenceService.getCompetenceById(id);

        List<SousCompetenceDTO> subCompetences = competence.getSubCompetences().stream()
                .map(sc -> new SousCompetenceDTO(sc.getId(), sc.getName(), sc.isValidated(), competence.getId(), competence.getName()))
                .toList();

        return new CompetenceDTO(
                competence.getId(),
                competence.getName(),
                competence.isValidated(),
                competence.getDescription(),
                subCompetences
        );
    }


    @Operation(summary = "Create a new competence")
    @PostMapping
    public Competence createCompetence(@RequestBody Competence competence) {
        return competenceService.createCompetence(competence);
    }

    @Operation(summary = "Update an existing competence")
    @PutMapping("/{id}")
    public Competence updateCompetence(@PathVariable Long id, @RequestBody Competence competence) {
        return competenceService.updateCompetence(id, competence);
    }

    @Operation(summary = "Delete a competence by ID")
    @DeleteMapping("/{id}")
    public void deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=rapport_competences_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Competence> competences = competenceService.getAllCompetences();
        excelExportService.exportCompetencesToExcel(competences, response.getOutputStream());
    }

}