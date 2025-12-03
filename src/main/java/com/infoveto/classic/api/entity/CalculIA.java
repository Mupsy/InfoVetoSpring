package com.infoveto.classic.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calcul_ia", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculIA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
