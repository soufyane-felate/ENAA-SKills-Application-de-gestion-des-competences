//package com.EnaaSkills.EnaaSkills.Services;
//
//import com.EnaaSkills.EnaaSkills.Dto.ApprenantDTO;
//import com.EnaaSkills.EnaaSkills.Models.Apprenant;
//import com.EnaaSkills.EnaaSkills.Repository.ApprenantRepository;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.ValidationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional
//public class ApprenantService {
//
//    @Autowired
//    private ApprenantRepository apprenantRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public List<ApprenantDTO> findAll() {
//        return apprenantRepository.findAll().stream()
//                .map(apprenant -> modelMapper.map(apprenant, ApprenantDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    public ApprenantDTO findById(Long id) {
//        Apprenant apprenant = apprenantRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Apprenant non trouvé avec l'ID: " + id));
//        return modelMapper.map(apprenant, ApprenantDTO.class);
//    }
//
//    public ApprenantDTO create(ApprenantDTO apprenantDTO) {
//        if (apprenantRepository.findByEmail(apprenantDTO.getEmail()).isPresent()) {
//            throw new ValidationException("Un apprenant avec cet email existe déjà");
//        }
//
//        Apprenant apprenant = modelMapper.map(apprenantDTO, Apprenant.class);
//        apprenant = apprenantRepository.save(apprenant);
//        return modelMapper.map(apprenant, ApprenantDTO.class);
//    }
//
//    public ApprenantDTO update(Long id, ApprenantDTO apprenantDTO) {
//        Apprenant existingApprenant = apprenantRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Apprenant non trouvé avec l'ID: " + id));
//
//        if (apprenantRepository.existsByEmailAndIdNot(apprenantDTO.getEmail(), id)) {
//            throw new ValidationException("Un autre apprenant avec cet email existe déjà");
//        }
//
//        existingApprenant.setNom(apprenantDTO.getNom());
//        existingApprenant.setPrenom(apprenantDTO.getPrenom());
//        existingApprenant.setEmail(apprenantDTO.getEmail());
//
//        existingApprenant = apprenantRepository.save(existingApprenant);
//        return modelMapper.map(existingApprenant, ApprenantDTO.class);
//    }
//
//    public void delete(Long id) {
//        if (!apprenantRepository.existsById(id)) {
//            throw new ResourceNotFoundException("Apprenant non trouvé avec l'ID: " + id);
//        }
//        apprenantRepository.deleteById(id);
//    }
//}



// === BACKEND CODE FOR COMPETENCE MANAGEMENT ===

// 1. Entity Classes

// Competence.java




// 2. Repository Interfaces


// 3. Services



// 4. Controllers


// 5. Dashboard DTO


// 6. Swagger (springdoc-openapi)
// Add to pom.xml:
// <dependency>
//   <groupId>org.springdoc</groupId>
//   <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
//   <version>2.0.2</version>
// </dependency>

// 7. Docker Compose (docker-compose.yml)

/*
version: '3.8'
services:
  db:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: competence_db
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/competence_db
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: root
    depends_on:
      - db

volumes:
  db_data:
*/


