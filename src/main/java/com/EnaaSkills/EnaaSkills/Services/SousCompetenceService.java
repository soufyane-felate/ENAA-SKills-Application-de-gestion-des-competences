package com.EnaaSkills.EnaaSkills.Services;

import com.EnaaSkills.EnaaSkills.Dto.SousCompetenceDTO;
import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Models.SubCompetence;
import com.EnaaSkills.EnaaSkills.Repository.SubCompetenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class SousCompetenceService {

    private final SubCompetenceRepository sousCompetenceRepository;
    private final CompetenceService competenceService;

    public SubCompetence getSousCompetenceById(Long id) {
        return sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "SubCompetence not found with  : " + id
                ));
    }
    public SubCompetence createSousCompetence(Long competenceId, SousCompetenceDTO sousCompetenceDTO) {
        Competence competence = competenceService.getCompetenceById(competenceId);
        SubCompetence newSousCompetence = new SubCompetence();
        newSousCompetence.setName(sousCompetenceDTO.getName());
        newSousCompetence.setCompetence(competence);
        return sousCompetenceRepository.save(newSousCompetence);
    }

    public SubCompetence updateSousCompetence(Long id, SousCompetenceDTO sousCompetenceDTO) {
        SubCompetence existingSousCompetence = getSousCompetenceById(id);
        existingSousCompetence.setName(sousCompetenceDTO.getName());
        return sousCompetenceRepository.save(existingSousCompetence);
    }

    public void deleteSousCompetence(Long id) {
        SubCompetence sousCompetence = getSousCompetenceById(id);
        sousCompetenceRepository.delete(sousCompetence);
    }
}