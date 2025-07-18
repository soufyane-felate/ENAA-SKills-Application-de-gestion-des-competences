package com.EnaaSkills.EnaaSkills.Repository;

import com.EnaaSkills.EnaaSkills.Models.Competence;
import com.EnaaSkills.EnaaSkills.Models.SubCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubCompetenceRepository extends JpaRepository<SubCompetence, Long> {

//    @Query("SELECT SubCompetence sc FROM Competence WHERE Competence.name =:CompetenceName")
//    List <Competence> getSubCompetenceByName();


}
