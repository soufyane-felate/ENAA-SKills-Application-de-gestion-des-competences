package com.EnaaSkills.EnaaSkills.Repository;

import com.EnaaSkills.EnaaSkills.Models.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SousCompetenceRepository extends JpaRepository<SousCompetence, Long> {

    List<SousCompetence> findByCompetenceId(Long competenceId);

    @Query("SELECT sc FROM SousCompetence sc WHERE sc.competence.id = :competenceId")
    List<SousCompetence> findSousCompetencesByCompetenceId(@Param("competenceId") Long competenceId);
}
