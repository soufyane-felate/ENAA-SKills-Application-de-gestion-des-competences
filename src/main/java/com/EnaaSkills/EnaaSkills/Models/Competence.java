package com.EnaaSkills.EnaaSkills.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean validated;
    private String name;
    private String test;

  @JsonIgnore
    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubCompetence> subCompetences = new ArrayList<>();
}
