package com.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by u342597 on 23/12/2015.
 */
@Configuration
public class WebConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    //@Value("${todo.ureAllowedOrigins}")
   // private String ureAllowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                LOGGER.info("Cors mapping allowedOrigins ");
                registry.addMapping("/**").allowedOrigins("*");

            }
        };
    }
}

