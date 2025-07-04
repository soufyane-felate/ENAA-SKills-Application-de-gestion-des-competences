package com.EnaaSkills.EnaaSkills.Dto;


import lombok.Data;

import java.util.List;
@Data
public class CompetenceDashboardDTO {
    private String competenceName;
    private boolean acquired;
    private List<String> subCompetences;
    private List<Boolean> validationStatus;
}
