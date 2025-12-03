package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vet_ratings", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VetRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="review_id", nullable = false)
    @JsonProperty("review")
    private VetReviews vetReviews;

    @Column(name = "competence")
    @JsonProperty("competence")
    private Integer competence;


    @Column(name = "communication")
    @JsonProperty("communication")
    private Integer communication;

    @Column(name = "empathy")
    @JsonProperty("empathy")
    private Integer empathy;

    @Column(name = "cleanliness")
    @JsonProperty("cleanliness")
    private Integer cleanliness;

    @Column(name = "value_for_money")
    @JsonProperty("valueForMoney")
    private Integer valueForMoney;

}
