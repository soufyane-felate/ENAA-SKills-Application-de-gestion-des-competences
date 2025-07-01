package com.EnaaSkills.EnaaSkills.Dto;

import com.EnaaSkills.EnaaSkills.Enums.StatutValidation;

import java.time.LocalDateTime;
import java.util.List;

public class CompetenceStatistiquesDTO {
    private Long competenceId;
    private String competenceNom;
    private StatutValidation statutValidation;
    private double pourcentageValidation;
    private LocalDateTime dateValidation;
    private int totalSousCompetences;
    private int sousCompetencesValidees;
    private List<SousCompetenceStatutDTO> sousCompetences;
}