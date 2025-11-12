package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Data
@Table(name = "animals")
public class Animals {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    @JsonProperty("id")
    private String id;

    @Column(name = "animal_id", unique = true, nullable = false)
    @JsonProperty("animal_id")
    private String animalId;

    @Column(name = "user_id")
    @JsonProperty("user_id")
    private String userId;

    @Column(name = "image")
    @JsonProperty("image")
    private String image;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "breed")
    @JsonProperty("breed")
    private String breed;

    @Column(name = "birth_date")
    @JsonProperty("birth_date")
    private String birthDate;

    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "weight")
    @JsonProperty("weight")
    private String weight;

    @Column(name = "sterilized")
    @JsonProperty("sterilized")
    private boolean sterilized;

    @Column(name = "microchip_number")
    @JsonProperty("microchip_number")
    private String microchipNumber;

    @Column(name = "last_internal_parasite_treatment")
    @JsonProperty("last_internal_parasite_treatment")
    private String lastInternalParasiteTreatment;

    @Column(name = "last_external_parasite_treatment")
    @JsonProperty("last_external_parasite_treatment")
    private String lastExternalParasiteTreatment;

    @Column(name = "lifestyle")
    @JsonProperty("lifestyle")
    private String lifestyle;

    @Column(name = "last_vet_visit")
    @JsonProperty("last_vet_visit")
    private Date lastVetVisit;

    @Column(name = "reason_last_visit")
    @JsonProperty("reason_last_visit")
    private String reasonLastVisit;

    @Column(name = "behavior_with_humans")
    @JsonProperty("behavior_with_humans")
    private String behaviorWithHumans;

    @Column(name = "behavior_with_animals")
    @JsonProperty("behavior_with_animals")
    private String behaviorWithAnimals;

    @Column(name = "behavioral_issues")
    @JsonProperty("behavioral_issues")
    private String behavioralIssues;

    @Column(name = "meal_frequency")
    @JsonProperty("meal_frequency")
    private String mealFrequency;

    @Column(name = "remarks")
    @JsonProperty("remarks")
    private String remarks;

    @Column(name = "created_at")
    @JsonProperty("created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private Date updatedAt;


    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("allergies")
    @JsonIgnore
    private List<AnimalAllergies> allergies;
}
