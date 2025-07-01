package com.EnaaSkills.EnaaSkills.Controller;

import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Models.SousCompetence;
import com.EnaaSkills.EnaaSkills.Services.CompetenceService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    CompetenceService service;

    @GetMapping("/dashboard")
    public List<CompetenceStatusDTO> dashboard() {
        return service.listerToutes().stream().map(c ->
                new CompetenceStatusDTO(c.getNom(), c.isValide(),
                        c.getSousCompetences().stream()
                                .map(sc -> new SousStatusDTO(sc.getNom(), sc.isValide()))
                                .collect(Collectors.toList())
                )
        ).collect(Collectors.toList());
    }

    @GetMapping("/export")
    public void exportCSV(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/csv");
        resp.setHeader("Content-Disposition", "attachment; filename=\"progression.csv\"");
        try (CSVPrinter printer = new CSVPrinter(resp.getWriter(),
                CSVFormat.DEFAULT.withHeader("competence","sous","valide"))) {
            for (Competence c : service.listerToutes()) {
                for (SousCompetence sc : c.getSousCompetences()) {
                    printer.printRecord(c.getNom(), sc.getNom(), sc.isValide());
                }
            }
        }
    }
}
