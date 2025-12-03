package com.infoveto.classic.api.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vet_review", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VetReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="veterinarians_id", nullable = false)
    @JsonProperty("veterinarians")
    private Veterinarians veterinarians;

    @Lob
    @Column(name = "comment", columnDefinition = "TEXT")
    @JsonProperty("comment")
    private String comment;

    @Column(name = "date_review")
    @JsonProperty("dateReview")
    private String dateReview;
}
