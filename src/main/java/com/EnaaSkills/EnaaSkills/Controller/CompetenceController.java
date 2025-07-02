package com.EnaaSkills.EnaaSkills.Controller;


import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    @GetMapping
    public List<Competence> getAll() {
        return competenceService.getAllCompetences();
    }

    @PostMapping
    public Competence create(@RequestBody Competence c) {
        return competenceService.createCompetence(c);
    }

    @PutMapping("/{id}")
    public Competence update(@PathVariable Long id, @RequestBody Competence c) {
        return competenceService.updateCompetence(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
    }
}