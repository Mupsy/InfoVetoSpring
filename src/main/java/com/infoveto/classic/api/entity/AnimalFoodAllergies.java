package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.infoveto.classic.api.entity.Animals;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "animal_food_allergies", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalFoodAllergies {

    @Id
    @Column(length = 36, nullable = false)
    @JsonProperty("id")
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonProperty("animal")
    private Animals animal;

    @Column(nullable = false)
    @JsonProperty("allergen")
    private String allergen;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, columnDefinition = "enum('Légère','Modérée','Sévère') default 'Modérée'")
    @JsonProperty("severity")
    private Severity severity = Severity.Modérée;

    @Column(columnDefinition = "text")
    @JsonProperty("symptoms")
    private String symptoms;

    @JsonProperty("discoveredDate")
    private LocalDate discoveredDate;

    public enum Severity {
        Légère,
        Modérée,
        Sévère
    }
}
