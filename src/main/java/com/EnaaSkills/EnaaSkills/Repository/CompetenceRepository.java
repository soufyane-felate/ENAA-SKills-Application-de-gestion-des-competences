package com.EnaaSkills.EnaaSkills.Repository;

import com.EnaaSkills.EnaaSkills.Models.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
//public interface CompetenceRepository extends JpaRepository<Competence, Long> {
//
//    @Query("SELECT c FROM Competence c LEFT JOIN FETCH c.sousCompetences")
//    List<Competence> findAllWithSousCompetences();
//
//    @Query("SELECT c FROM Competence c LEFT JOIN FETCH c.sousCompetences WHERE c.id = :id")
//    Competence findByIdWithSousCompetences(@Param("id") Long id);
//}
public interface CompetenceRepository extends JpaRepository<Competence, Long> {}



