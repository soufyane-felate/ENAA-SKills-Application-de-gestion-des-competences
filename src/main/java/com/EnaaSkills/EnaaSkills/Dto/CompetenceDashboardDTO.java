package com.EnaaSkills.EnaaSkills.Dto;


import java.util.List;

//public class CompetenceDashboardDTO {
//    private ApprenantDTO apprenant;
//    private List<CompetenceStatistiquesDTO> competences;
//    private int totalCompetences;
//    private int competencesValidees;
//    private double pourcentageGlobal;
//
//
//}
public class CompetenceDashboardDTO {
    private String competenceName;
    private boolean acquired;
    private List<String> subCompetences;
    private List<Boolean> validationStatus;
}
