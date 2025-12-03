package com.infoveto.classic.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "articles", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    @JsonProperty("category")
    private Category category;

    @JsonProperty("author")
    private String author;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("readingTime")
    private Integer reading_time;

    @JsonProperty("image")
    private String image;


    @Lob
    @Column(columnDefinition = "TEXT")
    @JsonProperty("introduction")
    private String introduction;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("section1Content")
    private String section1_content;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("section2Content")
    private String section2_content;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("section3Content")
    private String section3_content;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("section4Content")
    private String section4_content;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("section5Content")
    private String section5_content;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("conclusion")
    private String conclusion;


    @JsonProperty("section1Title")
    private String section1_title;

    @JsonProperty("section2Title")
    private String section2_title;

    @JsonProperty("section3Title")
    private String section3_title;

    @JsonProperty("section4Title")
    private String section4_title;

    @JsonProperty("section5Title")
    private String section5_title;

    @Enumerated(EnumType.STRING)
    @Column(name = "display_articles")
    @JsonProperty("displayArticles")
    private DisplayArticles display_articles;

    @JsonProperty("displayHome")
    private Boolean display_home;

    @JsonProperty("displayDashboard")
    private Boolean display_dashboard;


    public enum Category {
        SANTE("Santé"),
        TECHNOLOGIE("Technologie"),
        BIEN_ETRE("Bien-être");

        private final String label;

        Category(String label) { this.label = label; }

        @JsonValue
        public String getLabel() { return label; }
    }

    public enum DisplayArticles {
        OUI("Oui"),
        NON("Non");

        private final String label;

        DisplayArticles(String label) { this.label = label; }

        @JsonValue
        public String getLabel() { return label; }
    }
}
