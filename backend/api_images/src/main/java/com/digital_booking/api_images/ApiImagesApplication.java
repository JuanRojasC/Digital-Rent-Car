package com.digital_booking.api_images;

import com.digital_booking.api_images.util.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Log4j
public class ApiImagesApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiImagesApplication.class, args);
        log.info(Log.formatLog("IMAGES-SERVICE-ENV-VAR", "Variable de Entorno <<CONFIG_SERVER>>: " + System.getenv("CONFIG_SERVER")));
        log.info(Log.formatLog("IMAGES-SERVICE-ENV-VAR", "Variable de Entorno <<EUREKA_SERVER>>: " + System.getenv("EUREKA_SERVER")));
        log.info(Log.formatLog("IMAGES-SERVICE-ENV-VAR", "Variable de Entorno <<DB_LINK_CONNECTION>>: " + System.getenv("DB_LINK_CONNECTION")));
    }

}
