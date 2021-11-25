CREATE USER 'digitalrentcar'@'%' IDENTIFIED BY 'digitalrentcar';
GRANT ALL PRIVILEGES ON *.* TO 'digitalrentcar'@'%' WITH GRANT OPTION;

CREATE DATABASE IF NOT EXISTS digitalRentcarImages;
USE digitalRentcarImages;

DROP TABLE IF EXISTS images;

CREATE TABLE `images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `url_image` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Sprint I
INSERT INTO images (title, url_image) VALUES ('Logo Company Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/logo-company/Digital+Rent+Car+Company+-+Full.png' );
INSERT INTO images (title, url_image) VALUES ('Logo Company White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/logo-company/Digital+Rent+Car+Company+-+Light.png' );
INSERT INTO images (title, url_image) VALUES ('Car Dealer','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/assets/Dealer-Image.jpg' );
INSERT INTO images (title, url_image) VALUES ('Family Car Landscape','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/assets/Intro_Car-Image.jpeg.jpg' );
INSERT INTO images (title, url_image) VALUES ('Air conditioner Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/air-conditioner.png' );
INSERT INTO images (title, url_image) VALUES ('Electric Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/electric.png' );
INSERT INTO images (title, url_image) VALUES ('Engine Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/engine.png' );
INSERT INTO images (title, url_image) VALUES ('Gasoline Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/gasoline.png' );
INSERT INTO images (title, url_image) VALUES ('seat Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/seat.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Brand Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles-brands/chevrolet-icon.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Brand Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles-brands/ford-icon.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Brand Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles-brands/honda-icon.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Brand Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles-brands/nissan-icon.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Brand Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles-brands/renault-icon.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Brand Icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles-brands/toyota-icon.png' );
INSERT INTO images (title, url_image) VALUES ('Audi Q5','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Audi+Q5/Audi_Q5-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Mustang','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Accord','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRV','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Frontier','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Versa','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Porsche 911','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Porsche+911/Porsche_911-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Sandero','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2021','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux+C/Toyota_Hilux_C-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image.png' );


-- Sprint II
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Ford Mustang Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Mustang Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Mustang Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Mustang Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Mustang Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Honda Accord Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Accord Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Accord Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Accord Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Accord Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Honda CRV Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRV Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRV Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRV Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRV Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Nissan Frontier Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Frontier Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Frontier Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Frontier Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Frontier Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Nissan Versa Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Versa Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Versa Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Versa Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Versa Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Renault Sandero Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Sandero Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Sandero Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Sandero Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Sandero Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Hilux Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image5.png' );

CREATE DATABASE IF NOT EXISTS digitalRentcarFeatures;
USE digitalRentcarFeatures;

DROP TABLE IF EXISTS features;

CREATE TABLE `features` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `image_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Sprint II
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '145 HP', 7);
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'true', 5); 
INSERT INTO features (name, value, image_id) VALUES ('seats', '7', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Diesel', 8);   
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '455 HP', 7);   
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'false', 5);
INSERT INTO features (name, value, image_id) VALUES ('seats', '4', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Gasolina', 8); 
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '310 HP', 7);   
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'true', 5); 
INSERT INTO features (name, value, image_id) VALUES ('seats', '4', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Gasolina', 8); 
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '283 HP', 7);   
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'true', 5); 
INSERT INTO features (name, value, image_id) VALUES ('seats', '4', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Gasolina', 8); 
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '480 HP', 7);   
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'true', 5); 
INSERT INTO features (name, value, image_id) VALUES ('seats', '4', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Gasolina', 8); 
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '200 HP', 7);   
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'true', 5); 
INSERT INTO features (name, value, image_id) VALUES ('seats', '4', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Gasolina', 8); 
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '122 HP', 7);   
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'false', 5);
INSERT INTO features (name, value, image_id) VALUES ('seats', '4', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Gasolina', 8); 
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '85 HP', 7);    
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'false', 5);
INSERT INTO features (name, value, image_id) VALUES ('seats', '5', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Gasolina', 8); 
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '204 HP', 7);   
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'true', 5);
INSERT INTO features (name, value, image_id) VALUES ('seats', '5', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'diesel', 8);
INSERT INTO features (name, value, image_id) VALUES ('enginePower', '98 HP', 7);
INSERT INTO features (name, value, image_id) VALUES ('airConditioning', 'true', 5);
INSERT INTO features (name, value, image_id) VALUES ('seats', '4', 9);
INSERT INTO features (name, value, image_id) VALUES ('combustible', 'Electrico', 6);

CREATE DATABASE IF NOT EXISTS digitalRentcarSpecs;
USE digitalRentcarSpecs;

DROP TABLE IF EXISTS specs;

CREATE TABLE `specs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `engine_power_feature_id` bigint DEFAULT NULL,
  `air_conditioning_feature_id` bigint DEFAULT NULL,
  `seats_feature_id` bigint DEFAULT NULL,
  `combustible_feature_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('1', '2', '3', '4');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('5', '6', '7', '8');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('9', '10', '11', '12');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('13', '14', '15', '16');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('17', '18', '19', '20');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('21', '22', '23', '24');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('25', '26', '27', '28');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('29', '30', '31', '32');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('33', '34', '35', '36');
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES ('37', '38', '39', '40');

CREATE DATABASE IF NOT EXISTS digitalRentcarCities;
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

-- COUNTRIES
INSERT INTO countries (name) VALUES ('Argentina');
INSERT INTO countries (name) VALUES ('Colombia');

-- CITIES
INSERT INTO cities (latitude, longitude, name, country_id) VALUES (-34.61315, -58.37723, 'Ciudad de Buenos Aires', (select country_id from countries where name = 'Argentina'));
INSERT INTO cities (latitude, longitude, name, country_id) VALUES (4.60971, -74.08175, 'Bogota DC', (select country_id from countries where name = 'Colombia'));

CREATE DATABASE IF NOT EXISTS digitalRentcarCategories;
USE digitalRentcarCategories;

DROP TABLE IF EXISTS categories;

CREATE TABLE `categories` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `image_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO categories (title, description, image_id) VALUES ('SUV', 'Un Sport Utility Vehicle (Vehículo Utilitario Deportivo) es un vehículo que apuesta por una estética todoterreno, pero que por sus cualidades está más orientado al asfalto. Por su tamaño y habitabilidad, ofrece más espacio y posibilidades que un turismo convencional con el añadido de poder desenvolverse fuera del asfalto gracias a su mayor altura libre con respecto al suelo, aunque casi nunca con capacidades similares a las de un todoterreno.', 16);
INSERT INTO categories (title, description, image_id) VALUES ('Sedan', 'Los sedanes son los modelos de autos más comunes que hay. Se caracterizan por tener un chasis monocasco con tres espacios claramente separados: la cajuela, la cabina y el cofre para el motor. Es a lo que regularmente nos referimos como coche.',  21);
INSERT INTO categories (title, description, image_id) VALUES ('Deportivo', 'Coche generalmente pequeño y bajo para dos pasajeros, diseñado para ofrecer una respuesta rápida, sea fácilmente manejable y se pueda conducir a alta velocidad.',  25);
INSERT INTO categories (title, description, image_id) VALUES ('Pick-up', 'Vehículo con aspecto de todoterreno, con carrocería bastante elevada sobre el suelo, tracción trasera -o, normalmente, a las cuatro ruedas-, reductora (especialmente para aumentar la capacidad de remolque) y, como gran elemento identificador, una caja trasera descubierta para transportar objetos.',  27);

CREATE DATABASE IF NOT EXISTS digitalRentcarProducts;
USE digitalRentcarProducts;

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_images_ids;

CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `main_image_id` bigint DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `city_id` bigint DEFAULT NULL,
  `specs_id` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product_images_ids` (
  `product_product_id` bigint NOT NULL,
  `images_ids` bigint DEFAULT NULL,
  KEY `FKckslx18g4kv72jvqq6mria22c` (`product_product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Products
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Chevrolet Captiva', 'Captiva Turbo llega para desafiar todas las expectativas de lo que se espera de un SUV. Más allá de su atractivo diseño, tiene el espacio suficiente para todo y todos, gracias a su capacidad para 5 o 7 pasajeros. Está equipada con tecnología superior y atributos avanzados de seguridad.', 18, 1, 1, 1);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Chevrolet Camaro', 'El Chevrolet Camaro ofrece buen nivel de equipamiento y asistencias al conductor para que el viaje en ciudad y carretera sea más seguro, pero no deja de lado sus raíces deportivas y puede liberar todo su potencial cuando uno lo desee. Si eres fanático de los autos americanos, este muscle car es uno de los más fieles a su origen.', 17, 3, 1, 2);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Nissan Frontier', 'Durante generaciones, Nissan ha fabricado las pick ups más confiables, manteniéndose así siempre a la delantera en resistencia y durabilidad. Nissan NP300® está diseñada para satisfacer todas tus necesidades gracias a su motor, capacidad de carga y chasis reforzado ademas de sus extraordinarios ángulos de entrada (28.5°) y salida (23.6°) le permiten enfrentarse sin problema a terrenos inclinados  e inhóspitos.', 23, 4, 1, 3);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Chrysler Town', 'El Chrysler Town & Country es un gran vehículo para familias que necesitan transportar personas y carga con regularidad. Para obtener el máximo espacio para pasajeros y carga, una minivan es difícil de superar, y las opciones de asientos de Town & Country se encuentran entre las mejores de su clase. Y su manejo controlado convierte la experiencia de conducción en algo muy comodo. Las opciones de entretenimiento incluyen TV en el asiento trasero, reproductores de DVD o DVD / Blu-Ray, un potente estéreo y conectividad para iPod.', 19, 1, 1, 4);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Ford Mustang', 'Escucha el rugido de un Mustang cuando el suelo comienza a temblar y las piernas a agitarse. Como siempre, el Mustang invoca su desempeño con características de manejo mejorado, opciones de motor súper potente y diseño de Mustang clásico. El habitáculo del Ford Mustang cuenta con un diseño muy personal que aboga por las líneas curvas y la profusión de botones e interruptores, recordando enormemente a los salpicaderos que el propio Mustang ofrecía en los años 60 y 70.', 20, 3, 1, 5);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Honda CRVs', 'Diseñado para llevarte más lejos, El CR-V ofrece millas y millas de diversión al conducir, con tracción total, 212 caballos de fuerza en total del sistema, y con mucho espacio de carga. Su exterior deportivo cuenta con líneas esculpidas y rines de aleación de 19 pulgadas disponibles, mientras que su espacio interior ofrece uun volante con calefacción disponible, asientos tapizados en cuero y otros materiales premium.', 22, 1, 1, 6);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Nissan Versa', 'El sedán Nissan Versa es una excelente herramienta de transporte para llevar a los pasajeros del punto A al punto B, pero también hace que el viaje sea más agradable que muchos otros autos subcompactos. El Nissan no solo es atractivo, su motor de cuatro cilindros tiene una economía de combustible en las carreteras impresionante. El suave andar del Versa y los cómodos asientos delanteros lo convierten en un carro relajante para los desplazamientos diarios, y está disponible con más asistencia al conductor que sus compañeros de clase.', 24, 2, 1, 7);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Renault Sandero', 'El Renault SANDERO es el auto para todo lo que sos y entre todas tus versiones, sos alguien que disfruta del diseño. Empieza cuando lo ves por primera vez. Es más que el perfil, es más que el frente, es un estilo único; es el diseño que hace que quieras subirte y manejarlo. Aún con el auto detenido, es fluido, dinámico y avanzado.', 26, 1, 1, 8);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Toyota Hilux', 'Bajo la musculosa y gran carrocería del Hilux se esconde un chasis tradicional de pick-up y vehículo todoterreno. Se trata de una plataforma de largueros y travesaños con suspensión trasera de ballesta diseñada especialmente para soportar grandes cargas, una gran capacidad off-road y una elevada versatilidad de carrocerías. La capacidad de carga de la caja permite hasta 1.040 kilogramos de carga. En función de la cabina puede albergar entre dos y cinco pasajeros, y en cuanto a cotas todoterreno ofrece 27 grados de ángulo de entrada, 27 grados de ángulo de salida y 23 grados de ángulo ventral con una profundidad de vadeo de hasta 70 centímetros con una altura libre de 29,3 centrímetros.', 28, 4, 1, 9);
INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('Toyota Vios', 'Toyota ha declarado explícitamente que, con el modelo Toyota Vios, se han propuesto conservar las mejores cualidades que los clientes han llegado a conocer, amar, a saber, la calidad y la comodidad. Fieles a su palabra, parecen estar en el camino correcto con la nueva generación. más equipamiento, un interior más refinado y una caja de cambios completamente nueva, son propiedades del nuevo Toyota Vios, disponible en nuestras vitrinas.', 29, 2, 1, 10);

-- Images of products
INSERT INTO product_images_ids VALUES (1, 35);
INSERT INTO product_images_ids VALUES (1, 36);
INSERT INTO product_images_ids VALUES (1, 37);
INSERT INTO product_images_ids VALUES (1, 38);
INSERT INTO product_images_ids VALUES (1, 39);
INSERT INTO product_images_ids VALUES (2, 30);
INSERT INTO product_images_ids VALUES (2, 31);
INSERT INTO product_images_ids VALUES (2, 32);
INSERT INTO product_images_ids VALUES (2, 33);
INSERT INTO product_images_ids VALUES (2, 34);
INSERT INTO product_images_ids VALUES (3, 60);
INSERT INTO product_images_ids VALUES (3, 61);
INSERT INTO product_images_ids VALUES (3, 62);
INSERT INTO product_images_ids VALUES (3, 63);
INSERT INTO product_images_ids VALUES (3, 64);
INSERT INTO product_images_ids VALUES (4, 40);
INSERT INTO product_images_ids VALUES (4, 41);
INSERT INTO product_images_ids VALUES (4, 42);
INSERT INTO product_images_ids VALUES (4, 43);
INSERT INTO product_images_ids VALUES (4, 44);
INSERT INTO product_images_ids VALUES (5, 45);
INSERT INTO product_images_ids VALUES (5, 46);
INSERT INTO product_images_ids VALUES (5, 47);
INSERT INTO product_images_ids VALUES (5, 48);
INSERT INTO product_images_ids VALUES (5, 49);
INSERT INTO product_images_ids VALUES (6, 55);
INSERT INTO product_images_ids VALUES (6, 56);
INSERT INTO product_images_ids VALUES (6, 57);
INSERT INTO product_images_ids VALUES (6, 58);
INSERT INTO product_images_ids VALUES (6, 59);
INSERT INTO product_images_ids VALUES (7, 65);
INSERT INTO product_images_ids VALUES (7, 66);
INSERT INTO product_images_ids VALUES (7, 67);
INSERT INTO product_images_ids VALUES (7, 68);
INSERT INTO product_images_ids VALUES (7, 69);
INSERT INTO product_images_ids VALUES (8, 70);
INSERT INTO product_images_ids VALUES (8, 71);
INSERT INTO product_images_ids VALUES (8, 72);
INSERT INTO product_images_ids VALUES (8, 73);
INSERT INTO product_images_ids VALUES (8, 74);
INSERT INTO product_images_ids VALUES (9, 75);
INSERT INTO product_images_ids VALUES (9, 76);
INSERT INTO product_images_ids VALUES (9, 77);
INSERT INTO product_images_ids VALUES (9, 78);
INSERT INTO product_images_ids VALUES (9, 79);
INSERT INTO product_images_ids VALUES (10, 80);
INSERT INTO product_images_ids VALUES (10, 81);
INSERT INTO product_images_ids VALUES (10, 82);
INSERT INTO product_images_ids VALUES (10, 83);
INSERT INTO product_images_ids VALUES (10, 84);

DROP TABLE IF EXISTS bookings;
DROP PROCEDURE IF EXISTS findBooking;

CREATE TABLE `bookings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `finish_time` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `time_booking` datetime NOT NULL,
  `user_id` bigint NOT NULL,
  `product_product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhanoaj1lahtni0j33i10f67fn` (`product_product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2019-04-09 17:23:12', '2019-04-10 17:00:00', '2019-04-16 17:00:00', 2, 2);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2019-05-13 11:34:45', '2019-05-09 07:00:00', '2019-05-16 21:00:00', 3, 3);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2019-06-22 21:45:07', '2019-06-25 14:00:00', '2019-06-28 20:00:00', 1, 4);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2019-07-07 18:47:55', '2019-07-12 12:00:00', '2019-07-13 22:00:00', 2, 5);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2019-08-14 11:54:12', '2019-08-27 17:00:00', '2019-08-30 13:00:00', 3, 6);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2019-09-01 08:23:55', '2019-09-05 07:00:00', '2019-09-14 21:00:00', 1, 7);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2019-10-23 22:33:34', '2019-10-24 15:00:00', '2019-10-16 22:00:00', 2, 8);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2020-05-12 08:43:30', '2020-06-24 20:00:00', '2020-06-26 13:00:00', 3, 9);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2020-10-05 09:30:15', '2020-11-02 14:00:00', '2020-11-07 15:00:00', 1, 1);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-04-09 17:23:12', '2021-04-13 09:00:00', '2021-04-16 08:00:00', 3, 2);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-06-23 12:34:07', '2021-07-01 20:00:00', '2021-07-06 13:00:00', 1, 3);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-10-07 21:45:30', '2021-10-10 17:00:00', '2021-10-12 20:00:00', 2, 4);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-11-16 14:50:10', '2021-11-12 08:00:00', '2021-11-24 15:00:00', 3, 5);

/* Data for test product 1 */
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id) VALUES ('2021-10-30 13:23:34', '2021-11-15 16:00:00', '2021-11-21 09:00:00', 1, 1);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-11-01 14:15:25', '2021-11-10 18:00:00', '2021-01-14 16:00:00', 2, 1);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-09-30 05:15:25', '2021-11-21 18:00:00', '2021-11-25 12:00:00', 3, 1);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-11-10 11:15:25', '2021-11-30 13:00:00', '2021-12-10 12:00:00', 4, 1);

CREATE DATABASE IF NOT EXISTS digitalRentcarUsers;
use digitalRentcarUsers;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* ROLES */
INSERT INTO roles (name) VALUES ('admin');
INSERT INTO roles (name) VALUES ('employee');
INSERT INTO roles (name) VALUES ('user');

/* USUARIOS */
INSERT INTO users (name, last_name, email, password, role_id) VALUES ('Sergio', 'Garcia', 'sergiogarcia@gmail.com', '$2a$10$QlLVjuZo78y089053BCH7eH2.X6QLaeWJlqESgvspUOOvDz0jg44e', 1);
INSERT INTO users (name, last_name, email, password, role_id) VALUES ('Lina', 'Huertas', 'linahuertas@gmail.com', '$2a$10$QimXJjW0WrWEuMq79l/1AuOweIRM6E3khvtBAbgsTaMiwomTRQROy', 1);
INSERT INTO users (name, last_name, email, password, role_id) VALUES ('Juan', 'Rojas', 'juanrojas@email.com', '$2a$10$747KQfpn43IjjLQ8cwgh2.8fzbcxfBLmIg3XgiZc8ema3y64NBX.a', 1);

/* PROCEDURES */

DROP PROCEDURE IF EXISTS findBooking;

DELIMITER --
CREATE PROCEDURE findBooking (IN check_in DATETIME, IN check_out DATETIME)
BEGIN
	SELECT * FROM bookings
    WHERE (start_time <= check_in AND finish_time >= check_in AND finish_time <= check_out) /*Before*/
    OR (start_time >= check_in AND finish_time <= check_out) /*Middle*/
    OR (start_time <= check_in AND finish_time >= check_out) /*Complete*/
    OR (start_time >= check_in AND start_time < check_out AND finish_time >= check_out); /*After*/
END --
