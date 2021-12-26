package com.digital_booking.api_user;

import com.digital_booking.api_user.util.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j
public class ApiUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUserApplication.class, args);
		log.info(Log.formatLog("USERS-SERVICE-ENV-VAR", "Variable de Entorno <<CONFIG_SERVER>>: " + System.getenv("CONFIG_SERVER")));
		log.info(Log.formatLog("USERS-SERVICE-ENV-VAR", "Variable de Entorno <<EUREKA_SERVER>>: " + System.getenv("EUREKA_SERVER")));
		log.info(Log.formatLog("USERS-SERVICE-ENV-VAR", "Variable de Entorno <<DB_LINK_CONNECTION>>: " + System.getenv("DB_LINK_CONNECTION")));
		log.info(Log.formatLog("USERS-SERVICE-ENV-VAR", "Variable de Entorno <<LOCALHOST>>: " + System.getenv("LOCALHOST")));
	}

}
