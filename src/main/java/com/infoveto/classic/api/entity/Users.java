package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name="users")
public class Users {

    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private String id;

    @Column(name="email")
    @JsonProperty("email")
    private String email;

    @Column(name="password")
    @JsonProperty("password")
    @JsonIgnore
    private String password;

    @Column(name="genre")
    @JsonProperty("genre")
    private String genre;

    @Column(name="nom")
    @JsonProperty("nom")
    private String firstName;

    @Column(name="prenom")
    @JsonProperty("prenom")
    private String lastName;

    @Column(name="date_naissance")
    @JsonProperty("date_naissance")
    private String birthDate;

    @Column(name="number")
    @JsonProperty("number")
    private String phone;

    @Column(name="adresse")
    @JsonProperty("addresse")
    private String address;

    @Column(name="ville")
    @JsonProperty("ville")
    private String city;

    @Column(name="code_postal")
    @JsonProperty("code_postal")
    private String postalCode;

    @Column(name="email_verified")
    @JsonProperty("email_verified")
    private boolean emailVerified;

    @Column(name="email_verified_at")
    @JsonProperty("email_verified_at")
    private Date emailVerifiedAt;

    @Column(name="twofaactivate")
    @JsonProperty("twofaactivate")
    private boolean twoFAactivate;

    @Column(name="twofamethod")
    @JsonProperty("twofamethod")
    private String twoFAmethod;

    @Column(name="twofasecret")
    @JsonProperty("twofasecret")
    private String twoFAsecret;

    @Column(name="phone_verified")
    @JsonProperty("phone_verified")
    private boolean phoneVerified;

    @Column(name="phone_verified_at")
    @JsonProperty("phone_verified_at")
    private Date phoneVerifiedAt;

    @Column(name="created_at")
    @JsonProperty("created_at")
    private Date createdAt;

    @Column(name="update_at")
    @JsonProperty("update_at")
    private Date updateAt;

    @Column(name="email_notifications_enabled")
    @JsonProperty("email_notifications_enabled")
    private boolean emailNotificationsEnabled;

    @Column(name="reminder_enabled")
    @JsonProperty("reminder_enabled°")
    private boolean reminderEnabled;


}
