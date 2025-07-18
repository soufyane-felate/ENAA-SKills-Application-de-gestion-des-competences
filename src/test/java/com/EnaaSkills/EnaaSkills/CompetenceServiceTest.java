package com.EnaaSkills.EnaaSkills;

import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Repository.CompetenceRepository;
import com.EnaaSkills.EnaaSkills.Services.CompetenceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CompetenceServiceTest {

    @InjectMocks
    private CompetenceService competenceService;

    @Mock
    private CompetenceRepository competenceRepository;

    @Test
    void testCreateCompetence() {
        Competence competence = new Competence();
        competence.setName("Java");

        Mockito.when(competenceRepository.save(Mockito.any(Competence.class))).thenReturn(competence);

        Competence createdCompetence = competenceService.createCompetence(competence);

        Assertions.assertEquals("Java", createdCompetence.getName());
        Mockito.verify(competenceRepository, Mockito.times(1)).save(competence);
    }

    @Test
    void testGetCompetenceById_Found() {
        Long competenceId = 1L;
        Competence competence = new Competence();
        competence.setId(competenceId);
        competence.setName("Java");

        Mockito.when(competenceRepository.findById(competenceId)).thenReturn(java.util.Optional.of(competence));

        Competence foundCompetence = competenceService.getCompetenceById(competenceId);

        Assertions.assertEquals(competenceId, foundCompetence.getId());
        Assertions.assertEquals("Java", foundCompetence.getName());
        Mockito.verify(competenceRepository, Mockito.times(1)).findById(competenceId);
    }

    @Test
    void testGetCompetenceById_NotFound() {
        Long competenceId = 1L;

        Mockito.when(competenceRepository.findById(competenceId)).thenReturn(java.util.Optional.empty());

        Assertions.assertThrows(org.springframework.web.server.ResponseStatusException.class, () -> {
            competenceService.getCompetenceById(competenceId);
        });
        Mockito.verify(competenceRepository, Mockito.times(1)).findById(competenceId);
    }

    @Test
    void testGetAllCompetences() {
        Competence competence1 = new Competence();
        competence1.setName("Java");
        Competence competence2 = new Competence();
        competence2.setName("Python");

        java.util.List<Competence> competences = java.util.Arrays.asList(competence1, competence2);

        Mockito.when(competenceRepository.findAll()).thenReturn(competences);

        java.util.List<Competence> foundCompetences = competenceService.getAllCompetences();

        Assertions.assertEquals(2, foundCompetences.size());
        Assertions.assertEquals("Java", foundCompetences.get(0).getName());
        Assertions.assertEquals("Python", foundCompetences.get(1).getName());
        Mockito.verify(competenceRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testUpdateCompetence() {
        Long competenceId = 1L;
        Competence existingCompetence = new Competence();
        existingCompetence.setId(competenceId);
        existingCompetence.setName("Old Name");

        Competence updatedCompetence = new Competence();
        updatedCompetence.setName("New Name");

        Mockito.when(competenceRepository.findById(competenceId)).thenReturn(java.util.Optional.of(existingCompetence));
        Mockito.when(competenceRepository.save(Mockito.any(Competence.class))).thenReturn(updatedCompetence);

        Competence result = competenceService.updateCompetence(competenceId, updatedCompetence);

        Assertions.assertEquals("New Name", result.getName());
        Mockito.verify(competenceRepository, Mockito.times(1)).findById(competenceId);
        Mockito.verify(competenceRepository, Mockito.times(1)).save(existingCompetence);
    }

    @Test
    void testDeleteCompetence() {
        Long competenceId = 1L;

        competenceService.deleteCompetence(competenceId);

        Mockito.verify(competenceRepository, Mockito.times(1)).deleteById(competenceId);
    }

    @Test
    void testUpdateCompetenceValidation() {
        Long competenceId = 1L;
        Competence competence = new Competence();
        competence.setId(competenceId);

        com.EnaaSkills.EnaaSkills.Models.SubCompetence sc1 = new com.EnaaSkills.EnaaSkills.Models.SubCompetence();
        sc1.setValidated(true);
        com.EnaaSkills.EnaaSkills.Models.SubCompetence sc2 = new com.EnaaSkills.EnaaSkills.Models.SubCompetence();
        sc2.setValidated(false);
        com.EnaaSkills.EnaaSkills.Models.SubCompetence sc3 = new com.EnaaSkills.EnaaSkills.Models.SubCompetence();
        sc3.setValidated(true);

        competence.setSubCompetences(java.util.Arrays.asList(sc1, sc2, sc3));

        Mockito.when(competenceRepository.findById(competenceId)).thenReturn(java.util.Optional.of(competence));
        Mockito.when(competenceRepository.save(Mockito.any(Competence.class))).thenReturn(competence);

        Competence result = competenceService.updateCompetenceValidation(competenceId);

        Assertions.assertTrue(result.isValidated());
        Mockito.verify(competenceRepository, Mockito.times(1)).findById(competenceId);
        Mockito.verify(competenceRepository, Mockito.times(1)).save(competence);
    }
}
