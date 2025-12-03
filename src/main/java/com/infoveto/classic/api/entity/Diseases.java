package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "diseases", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diseases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column(name = "name", columnDefinition = "TEXT")
    @JsonProperty("name")
    private String name;

    @Column(name = "category", columnDefinition = "TEXT")
    @JsonProperty("category")
    private String category;

    @Column(name = "type", columnDefinition = "TEXT")
    @JsonProperty("type")
    private String type;

    @Column(name = "severity", columnDefinition = "TEXT")
    @JsonProperty("severity")
    private String severity;

    @Column(name = "presentation", columnDefinition = "TEXT")
    @JsonProperty("presentation")
    private String presentation;

    @Column(name = "population_percentage", columnDefinition = "TEXT")
    @JsonProperty("populationPercentage")
    private String populationPercentage;

    @Column(name = "main_symptoms", columnDefinition = "TEXT")
    @JsonProperty("mainSymptoms")
    private String mainSymptoms;

    @Column(name = "when_to_consult", columnDefinition = "TEXT")
    @JsonProperty("whenToConsult")
    private String whenToConsult;

    @Column(name = "common_symptoms",columnDefinition = "TEXT")
    @JsonProperty("commonSymptoms")
    private String commonSymptoms;

    @Column(name = "advice", columnDefinition = "TEXT")
    @JsonProperty("advice")
    private String advice;

    @Column(name = "precautions",columnDefinition = "TEXT")
    @JsonProperty("precautions")
    private String precautions;

    @Column(name = "causes", columnDefinition = "TEXT")
    @JsonProperty("causes")
    private String causes;

    @Column(name = "risk_factors", columnDefinition = "TEXT")
    @JsonProperty("riskFactors")
    private String riskFactors;

    @Column(name = "prevention_measures", columnDefinition = "TEXT")
    @JsonProperty("preventionMeasures")
    private String preventionMeasures;

    @Column(name = "lifestyle_hygiene", columnDefinition = "TEXT")
    @JsonProperty("lifestyleHygiene")
    private String lifestyleHygiene;

    @Column(name = "complications", columnDefinition = "TEXT")
    @JsonProperty("complications")
    private String complications;

    @Column(name = "life_consequences", columnDefinition = "TEXT")
    @JsonProperty("lifeConsequences")
    private String lifeConsequences;

    @Column(name = "specialists", columnDefinition = "TEXT")
    @JsonProperty("specialists")
    private String specialists;

    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonProperty("updatedAt")
    private Date updatedAt;

}
