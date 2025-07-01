package com.EnaaSkills.EnaaSkills.Models;

import com.EnaaSkills.EnaaSkills.Enums.StatutValidation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "competence_apprenant")
public class CompetenceApprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apprenant_id", nullable = false)
    private Apprenant apprenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competence_id", nullable = false)
    private Competence competence;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_validation")
    private StatutValidation statutValidation = StatutValidation.NON_VALIDE;

    @Column(name = "date_validation")
    private LocalDateTime dateValidation;

    @Column(name = "pourcentage_validation")
    private Double pourcentageValidation = 0.0;

}