package com.infoveto.classic.api.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Testing")
public class TestingEntity {

    @Id
    @Column(name="ID", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="USER_NAME", nullable = false)
    private String userName;

    @Column(name="USER_MAIL",nullable = false)
    private String userMail;

}
