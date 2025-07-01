package com.EnaaSkills.EnaaSkills.Enums;

public enum StatutValidation {
    NON_VALIDE("Non validé"),
    EN_COURS("En cours"),
    VALIDE("Validé");

    private final String libelle;

    StatutValidation(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}