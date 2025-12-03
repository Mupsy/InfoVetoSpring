package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "mail_confirm", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailConfirm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users userId;

    @Column(name = "token")
    @JsonProperty("token")
    private String token;

    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private String createdAt;
}
