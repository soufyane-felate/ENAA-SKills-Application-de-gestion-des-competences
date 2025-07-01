package com.EnaaSkills.EnaaSkills.Repository;


import com.EnaaSkills.EnaaSkills.Enums.StatutValidation;
import com.EnaaSkills.EnaaSkills.Models.CompetenceApprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompetenceApprenantRepository extends JpaRepository<CompetenceApprenant, Long> {

    Optional<CompetenceApprenant> findByApprenantIdAndCompetenceId(Long apprenantId, Long competenceId);

    List<CompetenceApprenant> findByApprenantId(Long apprenantId);

    List<CompetenceApprenant> findByCompetenceId(Long competenceId);

    @Query("SELECT ca FROM CompetenceApprenant ca WHERE ca.apprenant.id = :apprenantId AND ca.statutValidation = :statut")
    List<CompetenceApprenant> findByApprenantIdAndStatut(@Param("apprenantId") Long apprenantId,
                                                         @Param("statut") StatutValidation statut);

    @Query("SELECT COUNT(ca) FROM CompetenceApprenant ca WHERE ca.apprenant.id = :apprenantId AND ca.statutValidation = 'VALIDE'")
    long countValidatedCompetencesByApprenant(@Param("apprenantId") Long apprenantId);

    @Query("SELECT COUNT(ca) FROM CompetenceApprenant ca WHERE ca.apprenant.id = :apprenantId")
    long countTotalCompetencesByApprenant(@Param("apprenantId") Long apprenantId);
}
