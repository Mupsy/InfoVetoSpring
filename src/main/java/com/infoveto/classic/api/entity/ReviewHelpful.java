package com.infoveto.classic.api.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;

@Entity
@Table(name = "review_helpful", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewHelpful {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="review_id", nullable = false)
    @JsonProperty("review")
    private VetReviews vetReviews;

    @Column(name = "is_helpful")
    @JsonProperty("isHelpful")
    private Boolean isHelpful;

    @CurrentTimestamp
    @Column(name = "date_helpful")
    @JsonProperty("dateHelpful")
    private Date dateHelpful;
}
