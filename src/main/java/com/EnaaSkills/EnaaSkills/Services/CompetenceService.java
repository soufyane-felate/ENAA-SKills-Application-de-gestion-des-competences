package com.EnaaSkills.EnaaSkills.Services;

import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Models.SubCompetence;
import com.EnaaSkills.EnaaSkills.Repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository competenceRepository;

    public Competence createCompetence(Competence competence) {
        for (SubCompetence sc : competence.getSubCompetences()) {
            sc.setCompetence(competence);
        }
        return competenceRepository.save(competence);
    }

    public Competence getCompetenceById(Long id) {
        return competenceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competence not found: " + id));
    }

    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public Competence updateCompetence(Long id, Competence updated) {
        return competenceRepository.findById(id).map(c -> {
            c.setName(updated.getName());
            return competenceRepository.save(c);
        }).orElseThrow();
    }

    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }

    public Competence updateCompetenceValidation(Long competenceId) {
        Competence competence = getCompetenceById(competenceId);
        List<SubCompetence> subCompetences = competence.getSubCompetences();
        long validatedCount = subCompetences.stream().filter(SubCompetence::isValidated).count();
        long totalCount = subCompetences.size();
        competence.setValidated((totalCount > 0) && (validatedCount * 2 >= totalCount));
        return competenceRepository.save(competence);
    }


}