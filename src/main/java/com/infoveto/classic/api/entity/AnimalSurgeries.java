package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "animal_surgeries", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalSurgeries {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonProperty("animal")
    private Animals animal;

    @Column(name = "surgery_name")
    @JsonProperty("surgeryName")
    private String surgeryName;

    @Column(name = "surgery_date")
    @JsonProperty("surgeryDate")
    private Date surgeryDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinarian", nullable = false)
    @JsonProperty("veterinarian")
    private Veterinarians veterinarian;

    @Column(name = "clinic")
    @JsonProperty("clinic")
    private String clinic;

    @Column(name = "complications")
    @JsonProperty("complications")
    private String complications;

    @Column(name = "recovery_notes")
    @JsonProperty("recoveryNotes")
    private String recoveryNotes;
}
