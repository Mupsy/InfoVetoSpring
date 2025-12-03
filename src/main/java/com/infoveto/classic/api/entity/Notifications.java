package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "notifications", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users userId;

    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    @Lob
    @Column(name = "message", columnDefinition = "TEXT")
    @JsonProperty("message")
    private String message;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "is_read")
    @JsonProperty("isRead")
    private Boolean isRead;

    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonProperty("updatedAt")
    private Date updatedAt;

    @Column(name = "expires_at")
    @JsonProperty("expiresAt")
    private Date expiresAt;

    @Column(name = "related_id")
    @JsonProperty("relatedId")
    private String relatedId;

    @Column(name = "related_type")
    @JsonProperty("relatedType")
    private String relatedType;
}
