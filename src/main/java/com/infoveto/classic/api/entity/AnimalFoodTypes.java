package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "animal_food_types", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalFoodTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    public String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonProperty("animal")
    private Animals animal;

    @Column(name="food_type")
    @JsonProperty("foodType")
    public String foodType;

    @Column(name = "brand")
    @JsonProperty("brand")
    public String brand;

    @Column(name="quantity_per_meal")
    @JsonProperty("quantityPerMeal")
    public String quantityPerMeal;

    @Column(name="is_primary")
    @JsonProperty("isPrimary")
    public boolean isPrimary;

    @Column(name="notes")
    @JsonProperty("notes")
    public String notes;
}
