package com.EnaaSkills.EnaaSkills.Dto;

import com.EnaaSkills.EnaaSkills.Models.Competence;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SousCompetenceDTO {
    private Long id;
    private String name;
    private boolean validated;

    private Long competenceId;
    private String competenceName;
}
