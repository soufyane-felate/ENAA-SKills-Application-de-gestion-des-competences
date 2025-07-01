package com.EnaaSkills.EnaaSkills.Services;

import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Models.SousCompetence;
import com.EnaaSkills.EnaaSkills.Repository.CompetenceRepository;
import com.EnaaSkills.EnaaSkills.Repository.SousCompetenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CompetenceService {
    @Autowired
    private CompetenceRepository compRepo;
    @Autowired private SousCompetenceRepository sousRepo;

    public Competence createAvecSous(List<String> nomSCs, String nomCompetence) {
        Competence c = new Competence();
        c.setNom(nomCompetence);
        for (String nomSC : nomSCs) {
            SousCompetence sc = new SousCompetence();
            sc.setNom(nomSC);
            sc.setCompetence(c);
            c.getSousCompetences().add(sc);
        }
        return compRepo.save(c);
    }

    public SousCompetence miseAJourValidation(Long scId, boolean valide) {
        SousCompetence sc = sousRepo.findById(scId)
                .orElseThrow(() -> new NoSuchElementException("SousComp non trouvée"));
        sc.setValide(valide);
        return sousRepo.save(sc);
    }

    public Competence majCompetence(Long compId, String nouveauNom, List<String> newSCs) {
        Competence c = compRepo.findById(compId)
                .orElseThrow();
        c.setNom(nouveauNom);
        c.getSousCompetences().clear();
        for (String nomSC : newSCs) {
            SousCompetence sc = new SousCompetence();
            sc.setNom(nomSC);
            sc.setCompetence(c);
            c.getSousCompetences().add(sc);
        }
        return compRepo.save(c);
    }

    public void supprimerCompetence(Long compId) { compRepo.deleteById(compId); }
    public List<Competence> listerToutes() { return compRepo.findAll(); }
}
