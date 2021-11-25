package com.digital_booking.eureka_service;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

    private static final Logger logger = Logger.getLogger(String.valueOf(EurekaServiceApplication.class));

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
        logger.info("Variable de Entorno <<CONFIG_SERVER>>: " + System.getenv("CONFIG_SERVER"));
    }

}
