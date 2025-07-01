package com.EnaaSkills.EnaaSkills.Dto;

import com.EnaaSkills.EnaaSkills.Enums.StatutValidation;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationRequestDTO {
    @NotNull(message = "L'ID de l'apprenant est obligatoire")
    private Long apprenantId;

    @NotNull(message = "L'ID de la sous-compétence est obligatoire")
    private Long sousCompetenceId;

    @NotNull(message = "Le statut de validation est obligatoire")
    private StatutValidation statutValidation;

    private String commentaire;

}