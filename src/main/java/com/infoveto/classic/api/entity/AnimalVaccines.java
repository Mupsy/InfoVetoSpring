package com.infoveto.classic.api.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "animal_vaccines", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalVaccines {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonProperty("animal")
    private Animals animal;

    @Column(name = "vaccine_name")
    @JsonProperty("vaccineName")
    private String vaccineName;

    @Column(name = "vaccination_date")
    @JsonProperty("vaccinationDate")
    private String vaccinationDate;

    @Column(name = "next_due_date")
    @JsonProperty("nextDueDate")
    private String nextDueDate;

    @Column(name = "status")
    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinarian", nullable = false)
    @JsonProperty("veterinarian")
    private Veterinarians veterinarian;


    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;


    public enum Status {
        A_JOUR("À jour"),
        EN_RETARD("En retard"),
        NON_FAIT("Non fait");

        private final String label;

        Status(String label) {
            this.label = label;
        }

        @JsonValue
        public String getLabel() {
            return label;
        }
    }

}
