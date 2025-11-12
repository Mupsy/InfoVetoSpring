package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "animal_documents")
public class AnimalDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="animal_id", nullable = false)
    @JsonProperty("animals")
    private Animals animals;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    @JsonProperty("user")
    private Users user;

    @Column(name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,columnDefinition = "enum('Analyse', 'Ordonnance', 'Imagerie', 'Certificat', 'Vaccination', 'Chirurgie', 'Consultation', 'Autre') default 'Analyse'")
    @JsonProperty("type")
    private DocumentType type;

    @Column(name="file")
    private String file;

    @Column(name="description")
    private String description;


    @Column(name="date")
    private Date date;

    @Column(name="file_size")
    private String fileSize;

    @CreationTimestamp
    @JsonProperty("createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @JsonProperty("updatedAt")
    private Date updatedAt;

    public enum DocumentType{
        Imagerie,
        Anaylise,
        Ordonnance,
        Certificat,
        Vaccination,
        Chirurgie,
        Consultation,
        Autre

    }
}
