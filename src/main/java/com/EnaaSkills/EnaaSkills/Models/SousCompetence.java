package com.EnaaSkills.EnaaSkills.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor



@Table(name = "sous_competences")
public class SousCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la sous-compétence est obligatoire")
    @Column(nullable = false)
    private String nom;

    @Column(length = 1000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competence_id", nullable = false)
    private Competence competence;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @OneToMany(mappedBy = "sousCompetence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SousCompetenceApprenant> sousCompetenceApprenants;

    @PrePersist
    public void prePersist() {
        this.dateCreation = LocalDateTime.now();
    }
}



