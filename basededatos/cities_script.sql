USE digitalRentcarCities;

DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS cities;

CREATE TABLE `countries` (
  `country_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cities` (
  `city_id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
  `latitude` decimal(11,7) NOT NULL,
  `longitude` decimal(11,7) NOT NULL,
  `country_id` bigint DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  FOREIGN KEY (`country_id`) REFERENCES countries(country_id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


