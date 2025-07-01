package com.EnaaSkills.EnaaSkills.Dto;

import com.EnaaSkills.EnaaSkills.Enums.StatutValidation;

import java.time.LocalDateTime;

public class SousCompetenceStatutDTO {
    private Long id;
    private String nom;
    private String description;
    private StatutValidation statutValidation;
    private LocalDateTime dateValidation;
    private String commentaire;

   }