package com.digital_booking.api_images;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiImagesApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiImagesApplication.class, args);
    }

}
