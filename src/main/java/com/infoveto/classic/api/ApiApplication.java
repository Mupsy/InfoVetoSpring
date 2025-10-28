package com.infoveto.classic.api;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@EnableScheduling
public class ApiApplication {

    @Autowired
    private DataSource dataSource;
    private static Logger logger = LoggerFactory.getLogger(ApiApplication.class);


    @PostConstruct
    public void checkConnection() throws Exception {
        try (Connection c = dataSource.getConnection()) {
            System.out.println("✅ Connected to DB: " + c.getCatalog());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
