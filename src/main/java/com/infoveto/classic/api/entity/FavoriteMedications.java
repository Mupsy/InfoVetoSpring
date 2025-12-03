package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "favorite_medications", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteMedications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="medication_id", nullable = false)
    @JsonProperty("medication")
    private Medication medication;

    @CreationTimestamp
    @Column(name = "added_at")
    @JsonProperty("addedAt")
    private Date addedAt;
}
