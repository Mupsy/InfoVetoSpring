package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "testing")
public class TestingEntity {

    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(name="user_name", nullable = false)
    @JsonProperty("user_name")
    private String userName;

    @Column(name="user_mail",nullable = false)
    @JsonProperty("user_mail")
    private String userMail;

}
