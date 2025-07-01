package com.EnaaSkills.EnaaSkills.Repository;

import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Models.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

    @Query("SELECT c FROM Competence c LEFT JOIN FETCH c.sousCompetences")
    List<Competence> findAllWithSousCompetences();

    @Query("SELECT c FROM Competence c LEFT JOIN FETCH c.sousCompetences WHERE c.id = :id")
    Competence findByIdWithSousCompetences(@Param("id") Long id);
}



