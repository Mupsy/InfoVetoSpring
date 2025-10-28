package com.infoveto.classic.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiPrefixConfig implements WebMvcConfigurer {

    @Value("${app.api.version}")
    private String apiVersion;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer){
        configurer.addPathPrefix("api/" + apiVersion,
                clazz -> clazz.getPackageName().startsWith("com.infoveto.classic.api.controller"));
    }
}
