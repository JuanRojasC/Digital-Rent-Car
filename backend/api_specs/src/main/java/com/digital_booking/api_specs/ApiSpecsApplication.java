package com.digital_booking.api_specs;

import com.digital_booking.api_specs.util.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@Log4j
public class ApiSpecsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSpecsApplication.class, args);
        log.info(Log.formatLog("SPECS-SERVICE-ENV-VAR", "Variable de Entorno <<CONFIG_SERVER>>: " + System.getenv("CONFIG_SERVER")));
        log.info(Log.formatLog("SPECS-SERVICE-ENV-VAR", "Variable de Entorno <<EUREKA_SERVER>>: " + System.getenv("EUREKA_SERVER")));
        log.info(Log.formatLog("SPECS-SERVICE-ENV-VAR", "Variable de Entorno <<DB_LINK_CONNECTION>>: " + System.getenv("DB_LINK_CONNECTION")));
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
