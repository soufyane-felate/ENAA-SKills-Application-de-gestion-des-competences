package com.EnaaSkills.EnaaSkills.Controller;



import com.EnaaSkills.EnaaSkills.Dto.SousCompetenceDTO;
import com.EnaaSkills.EnaaSkills.Models.SubCompetence;
import com.EnaaSkills.EnaaSkills.Services.SousCompetenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Sub competence", description = "API for generate sub competence")
@RestController
@RequestMapping("/api/sous-competences")
@RequiredArgsConstructor
public class SubCompetenceController {

    private final SousCompetenceService sousCompetenceService;
    @Operation(summary = "Create a new sub-skill")
    @PostMapping
    public SubCompetence createSousCompetence(@RequestBody SousCompetenceDTO sousCompetenceDTO) {
        return sousCompetenceService.createSousCompetence(sousCompetenceDTO.getCompetenceId(), sousCompetenceDTO);
    }
    @Operation(summary = "get all sub-skill")
    @GetMapping("/{id}")
    public SubCompetence getSousCompetenceById(@PathVariable Long id) {
        return sousCompetenceService.getSousCompetenceById(id);
    }

    @PutMapping("/{id}")
    public SubCompetence updateSousCompetence(@PathVariable Long id, @RequestBody SousCompetenceDTO sousCompetenceDTO) {
        return sousCompetenceService.updateSousCompetence(id, sousCompetenceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSousCompetence(@PathVariable Long id) {
        sousCompetenceService.deleteSousCompetence(id);
    }
}