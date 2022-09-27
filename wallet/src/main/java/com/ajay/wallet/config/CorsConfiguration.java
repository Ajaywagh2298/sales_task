package com.ajay.wallet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties({CorsProperties.class})
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer{
    private final CorsProperties corsProperties;

    @Autowired
    public CorsConfiguration(CorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        CorsProperties.Cors cors = corsProperties.getCors();
        registry.addMapping("/**")
                .allowedOrigins(cors.getAllowedOrigins())
                .allowedMethods(cors.getAllowedMethods())
                .maxAge(cors.getMaxAge())
                .allowedHeaders(cors.getAllowedHeaders())
                .exposedHeaders(cors.getExposedHeaders())
                .allowCredentials(true);
    }
}