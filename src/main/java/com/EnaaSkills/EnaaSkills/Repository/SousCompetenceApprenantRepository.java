package com.EnaaSkills.EnaaSkills.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

interface SousCompetenceApprenantRepository extends JpaRepository<SousCompetenceApprenant, Long> {

    Optional<SousCompetenceApprenant> findByApprenantIdAndSousCompetenceId(Long apprenantId, Long sousCompetenceId);

    List<SousCompetenceApprenant> findByApprenantId(Long apprenantId);

    List<SousCompetenceApprenant> findBySousCompetenceId(Long sousCompetenceId);

    @Query("SELECT sca FROM SousCompetenceApprenant sca " +
            "WHERE sca.apprenant.id = :apprenantId AND sca.sousCompetence.competence.id = :competenceId")
    List<SousCompetenceApprenant> findByApprenantIdAndCompetenceId(@Param("apprenantId") Long apprenantId,
                                                                   @Param("competenceId") Long competenceId);

    @Query("SELECT COUNT(sca) FROM SousCompetenceApprenant sca " +
            "WHERE sca.apprenant.id = :apprenantId AND sca.sousCompetence.competence.id = :competenceId " +
            "AND sca.statutValidation = 'VALIDE'")
    long countValidatedSousCompetencesByApprenantAndCompetence(@Param("apprenantId") Long apprenantId,
                                                               @Param("competenceId") Long competenceId);

    @Query("SELECT COUNT(sca) FROM SousCompetenceApprenant sca " +
            "WHERE sca.apprenant.id = :apprenantId AND sca.sousCompetence.competence.id = :competenceId")
    long countTotalSousCompetencesByApprenantAndCompetence(@Param("apprenantId") Long apprenantId,
                                                           @Param("competenceId") Long competenceId);

    @Query("SELECT sca FROM SousCompetenceApprenant sca " +
            "JOIN FETCH sca.sousCompetence sc " +
            "JOIN FETCH sc.competence c " +
            "WHERE sca.apprenant.id = :apprenantId")
    List<SousCompetenceApprenant> findByApprenantIdWithDetails(@Param("apprenantId") Long apprenantId);
}