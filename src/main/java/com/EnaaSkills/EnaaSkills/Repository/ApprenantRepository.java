package com.EnaaSkills.EnaaSkills.Repository;

import com.EnaaSkills.EnaaSkills.Models.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    Optional<Apprenant> findByEmail(String email);

    @Query("SELECT COUNT(a) > 0 FROM Apprenant a WHERE a.email = :email AND a.id != :id")
    boolean existsByEmailAndIdNot(String email, Long id);
}
