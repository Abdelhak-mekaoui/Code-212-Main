package com.example.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // You can customize settings here, allowing specific origins, HTTP methods, etc.
        registry.addMapping("/**") // Allows CORS for all endpoints
                .allowedOrigins("http://localhost:3000") // Allows CORS requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allows specified HTTP methods
                .allowedHeaders("*") // Allows all headers
                .allowCredentials(true);
    }
}
