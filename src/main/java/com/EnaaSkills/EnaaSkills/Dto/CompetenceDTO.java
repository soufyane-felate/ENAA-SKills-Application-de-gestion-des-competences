package com.EnaaSkills.EnaaSkills.Dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public class CompetenceDTO {
    private Long id;

    @NotBlank(message = "Le nom de la compétence est obligatoire")
    private String nom;

    private String description;
    private LocalDateTime dateCreation;
    private List<SousCompetenceDTO> sousCompetences;

}