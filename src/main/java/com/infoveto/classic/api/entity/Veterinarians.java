package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "veterinarians", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinarians {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    @Column(name = "image")
    @JsonProperty("image")
    private String image;

    @Column(name = "lastname_user", nullable = false)
    @JsonProperty("lastname_user")
    private String lastnameUser;

    @Column(name = "firstname_user", nullable = false)
    @JsonProperty("firstname_user")
    private String firstnameUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "enum('Homme','Femme','Autre')")
    @JsonProperty("gender")
    private Gender gender;

    @Column(name = "phone_user")
    @JsonProperty("phone_user")
    private String phoneUser;

    @Column(name = "specialty_user")
    @JsonProperty("specialty_user")
    private String specialtyUser;

    @Column(name = "description_user", columnDefinition = "text")
    @JsonProperty("description_user")
    private String descriptionUser;

    @Column(name = "languages_user", columnDefinition = "longtext")
    @JsonProperty("languages_user")
    private String languagesUser;

    @Column(name = "degrees", columnDefinition = "longtext")
    @JsonProperty("degrees")
    private String degrees;

    @Column(name = "experiences", columnDefinition = "longtext")
    @JsonProperty("experiences")
    private String experiences;

    @Enumerated(EnumType.STRING)
    @Column(name = "home_visit", columnDefinition = "enum('Oui','Non')")
    @JsonProperty("home_visit")
    private HomeVisit homeVisit;

    @Column(name = "clinic_name")
    @JsonProperty("clinic_name")
    private String clinicName;

    @Column(name = "clinic_city")
    @JsonProperty("clinic_city")
    private String clinicCity;

    @Column(name = "clinic_address", columnDefinition = "text")
    @JsonProperty("clinic_address")
    private String clinicAddress;

    @Column(name = "clinic_zipcode")
    @JsonProperty("clinic_zipcode")
    private String clinicZipcode;

    @Column(name = "clinic_type")
    @JsonProperty("clinic_type")
    private String clinicType;

    @Column(name = "opening_hours", columnDefinition = "longtext")
    @JsonProperty("opening_hours")
    private String openingHours;

    @Column(name = "consultations", columnDefinition = "longtext")
    @JsonProperty("consultations")
    private String consultations;

    @Column(name = "payment_methods", columnDefinition = "longtext")
    @JsonProperty("payment_methods")
    private String paymentMethods;

    @Column(name = "website")
    @JsonProperty("website")
    private String website;

    @OneToMany(mappedBy = "veterinarian", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<AnimalChronicDiseases> diseases;

    public enum Gender {
        Homme,
        Femme,
        Autre
    }

    public enum HomeVisit {
        Oui,
        Non
    }
}
