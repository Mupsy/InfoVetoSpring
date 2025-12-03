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
@Table(name = "articles_feedback", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticlesFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "articles_id", nullable = false)
    @JsonProperty("articles")
    private Articles articles;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users userId;

    @Column(name = "is_useful")
    @JsonProperty("isUseful")
    private boolean isUseful;

    @Column(name = "feedback_text")
    @JsonProperty("feedbackText")
    private String feedbackText;

    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private Date createdAt;

}
