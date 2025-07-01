package com.EnaaSkills.EnaaSkills.Models;


import com.EnaaSkills.EnaaSkills.Enums.StatutValidation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "sous_competence_apprenant")
public class SousCompetenceApprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apprenant_id", nullable = false)
    private Apprenant apprenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sous_competence_id", nullable = false)
    private SousCompetence sousCompetence;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_validation")
    private StatutValidation statutValidation = StatutValidation.NON_VALIDE;

    @Column(name = "date_validation")
    private LocalDateTime dateValidation;

    @Column(length = 1000)
    private String commentaire;
}
