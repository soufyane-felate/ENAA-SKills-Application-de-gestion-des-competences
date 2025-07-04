package com.EnaaSkills.EnaaSkills.Controller;

import com.EnaaSkills.EnaaSkills.Dto.SousCompetenceDTO;
import com.EnaaSkills.EnaaSkills.Models.SubCompetence;
import com.EnaaSkills.EnaaSkills.Services.SousCompetenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "SubCompetence", description = "API for managing sub-competences")
@RestController
@RequestMapping("/api/sous-competences")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SubCompetenceController {

    private final SousCompetenceService sousCompetenceService;

    @Operation(summary = "Create a new sub-competence")
    @PostMapping
    public SubCompetence createSousCompetence(@RequestBody SousCompetenceDTO sousCompetenceDTO) {
        return sousCompetenceService.createSousCompetence(sousCompetenceDTO.getCompetenceId(), sousCompetenceDTO);
    }

    @Operation(summary = "Get a sub-competence by ID")
    @GetMapping("/{id}")
    public SubCompetence getSousCompetenceById(@PathVariable Long id) {
        return sousCompetenceService.getSousCompetenceById(id);
    }

    @Operation(summary = "Update a sub-competence")
    @PutMapping("/{id}")
    public SubCompetence updateSousCompetence(@PathVariable Long id, @RequestBody SousCompetenceDTO sousCompetenceDTO) {
        return sousCompetenceService.updateSousCompetence(id, sousCompetenceDTO);
    }

    @Operation(summary = "Delete a sub-competence by ID")
    @DeleteMapping("/{id}")
    public void deleteSousCompetence(@PathVariable Long id) {
        sousCompetenceService.deleteSousCompetence(id);
    }
}
