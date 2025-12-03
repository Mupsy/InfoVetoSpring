package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;

@Entity
@Table(name = "medication", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "category")
    @JsonProperty("category")
    private String category;

    @Column(name = "form")
    @JsonProperty("form")
    private String form;

    @Column(name = "weight")
    @JsonProperty("weight")
    private String weight;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "reimbursement")
    @JsonProperty("reimbursement")
    private String reimbursement;

    @Column(name = "price", precision = 10, scale = 2)
    @JsonProperty("price")
    private BigDecimal price;

    @Lob
    @Column(name = "presentation", columnDefinition = "TEXT")
    @JsonProperty("presentation")
    private String presentation;

    @Column(name = "usage_advice", columnDefinition = "LONGTEXT")
    @JsonProperty("usageAdvice")
    private String usageAdvice;

    @Column(name = "dosage", columnDefinition = "LONGTEXT")
    @JsonProperty("dosage")
    private String dosage;

    @Column(name = "drug_interactions", columnDefinition = "LONGTEXT")
    @JsonProperty("drugInteractions")
    private String drugInteractions;

    @Column(name = "side_effects", columnDefinition = "LONGTEXT")
    @JsonProperty("sideEffects")
    private String sideEffects;

    @Column(name = "active_ingredients", columnDefinition = "LONGTEXT")
    @JsonProperty("activeIngredients")
    private String activeIngredients;

    @Column(name = "storage", columnDefinition = "TEXT")
    @JsonProperty("storage")
    private String storage;

    @Column(name = "manufacturer", columnDefinition = "LONGTEXT")
    @JsonProperty("manufacturer")
    private String manufacturer;

    @Column(name = "leaflet")
    @JsonProperty("leaflet")
    private String leaflet;

    @Column(name = "images", columnDefinition = "LONGTEXT")
    @JsonProperty("images")
    private String images;

    @Column(name = "image")
    @JsonProperty("image")
    private String image;

    @Column(name = "active_principle")
    @JsonProperty("activePrinciple")
    private String activePrinciple;

    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private String createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonProperty("updatedAt")
    private String updatedAt;

}
