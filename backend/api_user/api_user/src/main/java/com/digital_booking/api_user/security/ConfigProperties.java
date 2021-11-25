package com.digital_booking.api_user.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {

    @Bean
    @ConfigurationProperties(prefix = "admin-paths")
    public RouteValidator adminRouteValidator(){
        return new RouteValidator();
    }

    @Bean
    @ConfigurationProperties(prefix = "user-paths")
    public RouteValidator userRouteValidator(){
        return new RouteValidator();
    }

}
