package com.arenagrajau.site.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Libera o acesso da API para o frontend Angular.
 * Em producao, troque "allowedOrigins" pelo dominio real do site
 * (ex: https://arenagrajau.netlify.app) para maior seguranca.
 */
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOriginPatterns(
                                "http://localhost:4200",
                                "https://*.netlify.app",
                                "https://*.vercel.app",
                                "https://*.github.io",
                                "https://*.onrender.com"
                        )
                        .allowedMethods("GET", "POST", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
