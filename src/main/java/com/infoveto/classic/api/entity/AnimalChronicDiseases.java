package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "animal_chronic_diseases", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalChronicDiseases {

    @Id
    @Column(length = 36, nullable = false)
    @JsonProperty("id")
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonProperty("animal")
    private Animals animal;

    @Column(nullable = false)
    @JsonProperty("diseaseName")
    private String diseaseName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, columnDefinition = "enum('Légère','Modérée','Sévère') default 'Modérée'")
    @JsonProperty("severity")
    private Severity severity = Severity.Modérée;

    @Column(columnDefinition = "text")
    @JsonProperty("treatment")
    private String treatment;

    @JsonProperty("diagnosisDate")
    private LocalDate diagnosisDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinarian", nullable = false)
    @JsonProperty("veterinarian")
    private Veterinarians veterinarian;

    @JsonProperty("comment")
    private String comment;

    public enum Severity {
        Légère,
        Modérée,
        Sévère
    }
}
