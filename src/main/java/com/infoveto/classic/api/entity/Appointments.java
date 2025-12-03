package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "appointments", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonProperty("animal")
    private Animals animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinarian", nullable = false)
    @JsonProperty("veterinarian")
    private Veterinarians veterinarian;

    /* Mettre en foreign key quand crée */
    @Column(name = "calcul_ia_id")
    @JsonProperty("calculIaId")
    private Long calculIaId;

    @Column(name = "date_appointment")
    @JsonProperty("dateAppointement")
    private Date dateAppointement;

    @Column(name = "appointment_duration")
    @JsonProperty("appointmentDuration")
    private Long appointmentDuration;

    @Column(name = "consultation_reason")
    @JsonProperty("consultationReason")
    private String consultationReason;

    @Column(name = "additional_information")
    @JsonProperty("additionalInformation")
    private String additionalInformation;

    @Column(name = "is_canceled")
    @JsonProperty("isCanceled")
    private boolean isCanceled;
}
