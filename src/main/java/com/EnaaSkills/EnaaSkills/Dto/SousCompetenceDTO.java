package com.EnaaSkills.EnaaSkills.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SousCompetenceDTO {
    private Long id;

    @NotBlank(message = "Le nom de la sous-compétence est obligatoire")
    private String nom;

    private String description;
    private Long competenceId;
    private LocalDateTime dateCreation;

    }
