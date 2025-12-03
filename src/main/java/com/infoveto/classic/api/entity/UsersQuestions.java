package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "user_questions", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users userId;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "subject")
    @JsonProperty("subject")
    private String subject;

    @Column(name = "message")
    @JsonProperty("message")
    private String message;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    private Status status;


    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    @JsonProperty("priority")
    private Priority priority;

    @Column(name = "category")
    @JsonProperty("category")
    private String category;

    @Column(name = "response", columnDefinition = "TEXT")
    @JsonProperty("response")
    private String response;

    @CreationTimestamp
    @Column(name = "date_submitted")
    @JsonProperty("dateSubmitted")
    private String dateSubmitted;

    @Column(name = "date_responded")
    @JsonProperty("dateResponded")
    private String dateResponded;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="responder_id", nullable = false)
    @JsonProperty("responderId")
    private Users responderId;


    @Column(name = "satisfacation_rating")
    @JsonProperty("satisfacationRating")
    private Integer satisfacationRating;


    public enum Priority {
        LOW("Basse"), MEDIUM("Moyenne"), HIGH("Haute");

        private final String label;

        Priority(String label) { this.label = label; }

        @JsonValue
        public String getLabel() { return label; }
    }
    public enum Status {
        NEW("Nouveau"),
        PENDING("En cours"),
        ANSWERED("Répondu"),
        CLOSE("Fermé");

        private final String label;

        Status(String label) { this.label = label; }

        @JsonValue
        public String getLabel() { return label; }
    }
}
