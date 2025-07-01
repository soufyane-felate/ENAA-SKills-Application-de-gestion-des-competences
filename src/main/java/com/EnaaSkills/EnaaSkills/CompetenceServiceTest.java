//package com.EnaaSkills.EnaaSkills;
//
//import com.EnaaSkills.EnaaSkills.Models.SousCompetence;
//import com.EnaaSkills.EnaaSkills.Repository.CompetenceRepository;
//import com.EnaaSkills.EnaaSkills.Repository.SousCompetenceRepository;
//import com.EnaaSkills.EnaaSkills.Services.CompetenceService;
//
//
//
//import java.util.Optional;
//
//@ExtendWith(MockitoExtension.class)
//class CompetenceServiceTest {
//    @Mock
//    CompetenceRepository compRepo;
//    @Mock
//    SousCompetenceRepository sousRepo;
//    @InjectMocks
//    CompetenceService service;
//
//    @Test
//    void testCreateAvecSous() {
//        when(compRepo.save(any())).thenAnswer(i -> i.getArgument(0));
//        Competence c = service.createAvecSous(List.of("A","B"), "Comp");
//        assertThat(c.getSousCompetences()).hasSize(2);
//        assertThat(c.isValide()).isFalse();
//    }
//
//    @Test void testMiseAJourValidation() {
//        SousCompetence sc = new SousCompetence(); sc.setId(1L); sc.setValide(false);
//        when(sousRepo.findById(1L)).thenReturn(Optional.of(sc));
//        service.miseAJourValidation(1L, true);
//        assertThat(sc.isValide()).isTrue();
//    }
//}
//
