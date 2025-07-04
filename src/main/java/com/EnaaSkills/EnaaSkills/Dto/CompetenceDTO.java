package com.EnaaSkills.EnaaSkills.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetenceDTO {
    private Long id;
    private String name;
    private boolean validated;
    private String description;
    private List<SousCompetenceDTO> subCompetences;
}
