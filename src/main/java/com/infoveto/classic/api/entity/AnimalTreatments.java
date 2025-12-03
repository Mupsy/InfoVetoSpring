package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@Table(name = "animal_treatments", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalTreatments {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonProperty("animal")
    private Animals animal;

    @Column(name = "treatment_name")
    @JsonProperty("treatmentName")
    private String treatmentName;

    @Column(name = "treatment_date")
    @JsonProperty("treatmentDate")
    private Date treatmentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinarian", nullable = false)
    @JsonProperty("veterinarian")
    private Veterinarians veterinarian;

    @Column(name = "dosage")
    @JsonProperty("dosage")
    private String dosage;

    @Column(name = "duration")
    @JsonProperty("duration")
    private String duration;

    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonProperty("updatedAt")
    private Date updatedAt;

}
