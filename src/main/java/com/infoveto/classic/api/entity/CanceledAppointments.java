package com.infoveto.classic.api.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "canceled_appointments", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CanceledAppointments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointments_id", nullable = false)
    @JsonProperty("appointment")
    private Appointments appointments;

    @Column(name = "canceled_reason")
    @JsonProperty("canceledReason")
    private String canceledReason;
}
