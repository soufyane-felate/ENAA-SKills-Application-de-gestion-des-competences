package com.EnaaSkills.EnaaSkills.Controller;

import com.EnaaSkills.EnaaSkills.Dto.CreateDTO;
import com.EnaaSkills.EnaaSkills.Dto.UpdateDTO;
import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Models.SousCompetence;
import com.EnaaSkills.EnaaSkills.Services.CompetenceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences")
@Api(tags = "Gestion des compétences")
public class CompetenceController {
    @Autowired
    private CompetenceService service;

    @PostMapping
    @ApiOperation("Créer une compétence avec sous-compétences")
    public ResponseEntity<Competence> creer(@RequestBody CreateDTO dto) {
        Competence c = service.createAvecSous(dto.nomSous, dto.nomCompetence);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @PatchMapping("/sous/{id}")
    @Operation("Mettre à jour validation d'une sous-compétence")
    public SousCompetence majSC(@PathVariable Long id, @RequestParam boolean valide) {
        return service.miseAJourValidation(id, valide);
    }

    @GetMapping
    @ApiOperation("Lister toutes les compétences")
    public List<Competence> toutes() { return service.listerToutes(); }

    @PutMapping("/{id}")
    @ApiOperation("Modifier une compétence")
    public Competence maj(@PathVariable Long id, @RequestBody UpdateDTO dto) {
        return service.majCompetence(id, dto.nouveauNom, dto.nomSous);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Supprimer une compétence")
    public void del(@PathVariable Long id) { service.supprimerCompetence(id); }
}
