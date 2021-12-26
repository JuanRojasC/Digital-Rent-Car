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

INSERT INTO images (title, url_image) VALUES ('Audi Q5 Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Audi+Q5/Audi_Q5-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Audi Q5 Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Audi+Q5/Audi_Q5-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Audi Q5 White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Audi+Q5/Audi_Q5-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Audi Q5 Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Audi+Q5/Audi_Q5-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Camaro Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Camaro/Chevrolet_Camaro-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Captiva Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Chrysler Town Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Ford Escape Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Escape Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Escape White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Escape Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Ford Mustang Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Mustang Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Mustang White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Mustang Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Honda Accord Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Accord Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Accord White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Accord Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Accord/Honda_Accord-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Honda CRVs Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRVs Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRVs White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRVs Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Honda Odyssey Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Odyssey Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Odyssey White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Odyssey Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Jeep Renegade Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Jeep Renegade Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Jeep Renegade White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Jeep Renegade Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Kia Soul Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Soul Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Soul White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Soul Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Kia Carens Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Carens Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Carens White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Carens Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Mazda 3 Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda 3 Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda 3 White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda 3 Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Nissan Frontier Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Frontier Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Frontier White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Frontier Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Frontier/Nissan_Frontier-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Nissan Versa Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Versa Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Versa White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Nissan Versa Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Nissan+Versa/Nissan_Versa-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Porsche 911 Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Porsche+911/Porsche_911-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Porsche 911 Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Porsche+911/Porsche_911-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Porsche 911 White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Porsche+911/Porsche_911-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Porsche 911 Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Porsche+911/Porsche_911-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Renault Sandero Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Sandero Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Sandero White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Renault Sandero Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Renault+Sandero/Renault_Sandero-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2021 Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux+C/Toyota_Hilux_C-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2021 Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux+C/Toyota_Hilux_C-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2021 White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux+C/Toyota_Hilux_C-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2021 Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux+C/Toyota_Hilux_C-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Sienna Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Sienna Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Sienna White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Sienna Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Supra Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Supra Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Supra White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Supra Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Vios Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image-Red.png' );

INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok Black','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image-Black.png' );
INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok Blue','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image-Blue.png' );
INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok White','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image-White.png' );
INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok Red','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image-Red.png' );

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

INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Colorado Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Colorado/Chevrolet_Colorado-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Chevrolet Cruze Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Cruze/Chevrolet_Cruze-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Chrysler Town Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chrysler+Town/Chrysler_Town-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Ford Escape Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Escape Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Escape Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Escape Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Ford Escape Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Escape/Ford_Escape-Image5.png' );

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

INSERT INTO images (title, url_image) VALUES ('Honda CRVs Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRVs Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRVs Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRVs Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Honda CRVs Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+CRV/Honda_CRV-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Honda Odyssey Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Odyssey Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Odyssey Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Odyssey Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Honda Odyssey Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Honda+Odyssey/Honda_Odyssey-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Hyundai Veloster Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Hyundai+Veloster/Hyundai_Veloster-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Jeep Renegade Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Jeep Renegade Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Jeep Renegade Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Jeep Renegade Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Jeep Renegade Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Jeep+Renegade/Jeep_Renegade-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Kia Carens Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Carens Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Carens Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Carens Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Carens Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Carens/Kia_Carens-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Kia Soul Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Soul Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Soul Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Soul Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Kia Soul Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Kia+Soul/Kia_Soul-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Mazda 3 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda 3 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda 3 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda 3 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda 3 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+3/Mazda_3-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Mazda Mx-5 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mazda+Mx5/Mazda_Mx5-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Mitsubishi L200 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Mitsubishi+L200/Mitsubishi_L200-Image5.png' );

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

INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Hilux 2016 Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Hilux/Toyota_Hilux-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Sienna Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Sienna Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Sienna Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Sienna Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Sienna Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Sienna/Toyota_Sienna-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Supra Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Supra Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Supra Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Supra Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Supra Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Supra/Toyota_Supra-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Toyota Vios Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Toyota+Vios/Toyota_Vios-Image5.png' );

INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image1.png' );
INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image2.png' );
INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image3.png' );
INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image4.png' );
INSERT INTO images (title, url_image) VALUES ('Volkswagen Amarok Gallery','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Volkswagen+Amarok/Volkswagen_Amarok-Image5.png' );

INSERT INTO images(title, url_image) VALUES ('Support 24/7 icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/support.png' );
INSERT INTO images(title, url_image) VALUES ('Legal Documents icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/dni.png' );
INSERT INTO images(title, url_image) VALUES ('Crash icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/crash.png' );
INSERT INTO images(title, url_image) VALUES ('Schedule icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/schedule.png' );
INSERT INTO images(title, url_image) VALUES ('Cancel icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/cancel.png' );
INSERT INTO images(title, url_image) VALUES ('Country Border icon','https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/border.png' );

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
INSERT INTO features (id, name, value, image_id) VALUES (1, 'enginePower', '145 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (2, 'airConditioning', 'true', 5); 
INSERT INTO features (id, name, value, image_id) VALUES (3, 'seats', '7', 9);
INSERT INTO features (id, name, value, image_id) VALUES (4, 'combustible', 'Diesel', 8);
INSERT INTO features (id, name, value, image_id) VALUES (5, 'enginePower', '455 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (6, 'airConditioning', 'false', 5);
INSERT INTO features (id, name, value, image_id) VALUES (7, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (8, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (9, 'enginePower', '310 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (10, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (11, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (12, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (13, 'enginePower', '283 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (14, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (15, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (16, 'combustible', 'Gasolina', 8); 
INSERT INTO features (id, name, value, image_id) VALUES (17, 'enginePower', '480 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (18, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (19, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (20, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (21, 'enginePower', '200 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (22, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (23, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (24, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (25, 'enginePower', '122 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (26, 'airConditioning', 'false', 5);
INSERT INTO features (id, name, value, image_id) VALUES (27, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (28, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (29, 'enginePower', '85 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (30, 'airConditioning', 'false', 5);
INSERT INTO features (id, name, value, image_id) VALUES (31, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (32, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (33, 'enginePower', '204 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (34, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (35, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (36, 'combustible', 'Diesel', 8);
INSERT INTO features (id, name, value, image_id) VALUES (37, 'enginePower', '98 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (38, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (39, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (40, 'combustible', 'Electrico', 6);
INSERT INTO features (id, name, value, image_id) VALUES (41, 'enginePower', '147 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (42, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (43, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (44, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (45, 'enginePower', '192 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (46, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (47, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (48, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (49, 'enginePower', '153 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (50, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (51, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (52, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (53, 'enginePower', '186 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (54, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (55, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (56, 'combustible', 'Diesel', 8);
INSERT INTO features (id, name, value, image_id) VALUES (57, 'enginePower', '180 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (58, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (59, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (60, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (61, 'enginePower', '165 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (62, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (63, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (64, 'combustible', 'Electrico', 6);
INSERT INTO features (id, name, value, image_id) VALUES (65, 'enginePower', '275 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (66, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (67, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (68, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (69, 'enginePower', '150 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (70, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (71, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (72, 'combustible', 'Diesel', 8);
INSERT INTO features (id, name, value, image_id) VALUES (73, 'enginePower', '224 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (74, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (75, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (76, 'combustible', 'Diesel', 8);
INSERT INTO features (id, name, value, image_id) VALUES (77, 'enginePower', '180 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (78, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (79, 'seats', '5', 9);
INSERT INTO features (id, name, value, image_id) VALUES (80, 'combustible', 'Diesel', 8);
INSERT INTO features (id, name, value, image_id) VALUES (81, 'enginePower', '181 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (82, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (83, 'seats', '2', 9);
INSERT INTO features (id, name, value, image_id) VALUES (84, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (85, 'enginePower', '382 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (86, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (87, 'seats', '4', 9);
INSERT INTO features (id, name, value, image_id) VALUES (88, 'combustible', 'Gasolina', 8);
INSERT INTO features (id, name, value, image_id) VALUES (89, 'enginePower', '132 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (90, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (91, 'seats', '7', 9);
INSERT INTO features (id, name, value, image_id) VALUES (92, 'combustible', 'Diesel', 8);
INSERT INTO features (id, name, value, image_id) VALUES (93, 'enginePower', '245 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (94, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (95, 'seats', '8', 9);
INSERT INTO features (id, name, value, image_id) VALUES (96, 'combustible', 'Electrico', 6);
INSERT INTO features (id, name, value, image_id) VALUES (97, 'enginePower', '280 HP', 7);
INSERT INTO features (id, name, value, image_id) VALUES (98, 'airConditioning', 'true', 5);
INSERT INTO features (id, name, value, image_id) VALUES (99, 'seats', '8', 9);
INSERT INTO features (id, name, value, image_id) VALUES (100, 'combustible', 'Gasolina', 8);

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

INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (1, 2, 3, 4);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (5, 6, 7, 8);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (9, 10, 11, 12);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (13, 14, 15, 16);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (17, 18, 19, 20);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (21, 22, 23, 24);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (25, 26, 27, 28);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (29, 30, 31, 32);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (33, 34, 35, 36);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (37, 38, 39, 40);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (41, 42, 43, 44);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (45, 46, 47, 48);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (49, 50, 51, 52);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (53, 54, 55, 56);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (57, 58, 59, 60);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (61, 62, 63, 64);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (65, 66, 67, 68);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (69, 70, 71, 72);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (73, 74, 75, 76);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (77, 78, 79, 80);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (81, 82, 83, 84);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (85, 86, 87, 88);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (89, 90, 91, 92);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (93, 94, 95, 96);
INSERT INTO specs (engine_power_feature_id, air_conditioning_feature_id, seats_feature_id, combustible_feature_id ) VALUES (97, 98, 99, 100);

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
INSERT INTO categories (title, description, image_id) VALUES ('Sedan', 'Los sedanes son los modelos de autos más comunes que hay. Se caracterizan por tener un chasis monocasco con tres espacios claramente separados: la cajuela, la cabina y el cofre para el motor. Es a lo que regularmente nos referimos como coche.',  50);
INSERT INTO categories (title, description, image_id) VALUES ('Deportivo', 'Coche generalmente pequeño y bajo para dos pasajeros, diseñado para ofrecer una respuesta rápida, sea fácilmente manejable y se pueda conducir a alta velocidad.',  98);
INSERT INTO categories (title, description, image_id) VALUES ('Pick-up', 'Vehículo con aspecto de todoterreno, con carrocería bastante elevada sobre el suelo, tracción trasera -o, normalmente, a las cuatro ruedas-, reductora (especialmente para aumentar la capacidad de remolque) y, como gran elemento identificador, una caja trasera descubierta para transportar objetos.',  110);
INSERT INTO categories (title, description, image_id) VALUES ('Familiar', 'Vehículo con aspecto de todoterreno, con carrocería bastante elevada sobre el suelo, tracción trasera -o, normalmente, a las cuatro ruedas-, reductora (especialmente para aumentar la capacidad de remolque) y, como gran elemento identificador, una caja trasera descubierta para transportar objetos.',  74);

CREATE DATABASE IF NOT EXISTS digitalRentcarProducts;
USE digitalRentcarProducts;

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_images_ids;

CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` bigint DEFAULT NULL,
  `city_id` bigint DEFAULT NULL,
  `description` text NOT NULL,
  `name` varchar(255) NOT NULL,
  `specs_id` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product_images_ids` (
  `product_product_id` bigint NOT NULL,
  `images_ids` bigint DEFAULT NULL,
  KEY `FKckslx18g4kv72jvqq6mria22c` (`product_product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Products
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (1, 'Chevrolet Captiva', 'Captiva Turbo llega para desafiar todas las expectativas de lo que se espera de un SUV. Más allá de su atractivo diseño, tiene el espacio suficiente para todo y todos, gracias a su capacidad para 5 o 7 pasajeros. Está equipada con tecnología superior y atributos avanzados de seguridad.', 1, 1, 1);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (2, 'Honda CRVs', 'Diseñado para llevarte más lejos, El CR-V ofrece millas y millas de diversión al conducir, con tracción total, 212 caballos de fuerza en total del sistema, y con mucho espacio de carga. Su exterior deportivo cuenta con líneas esculpidas y rines de aleación de 19 pulgadas disponibles, mientras que su espacio interior ofrece uun volante con calefacción disponible, asientos tapizados en cuero y otros materiales premium.', 1, 1, 6);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (3, 'Kia Soul', 'Su caracteristica forma cuadrada ofrece mucho espacio para que cuatro adultos naveguen cómodamente, junto a un área de carga suficientemente grande para guardar todo el equipo y maletas durante su viaje. El KIA Soul nos ofrece iluminación ambiental, una plataforma de carga para teléfonos inteligentes, una pantalla de visualización frontal, encendido por botón con entrada sin llave y calefacción para los asientos y el volante.', 1, 1, 11);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (4, 'Jeep Renegade', 'El Renegade es un punto de entrada para la marca de estilo de vida y una alternativa resistente a la mayoría de los SUV subcompactos. Si arrojarse al barro y trepar por las rocas no es una rutina, no importa, sus adornos apesar de no estar clasificados para senderos son igual de resistentes a que si lo estuvieran, tiene uno de los interiores más espaciosos del segmento, permitiendo viajes relajantes junto a una lista de asistencias estándar y de gran ayuda para el conductor.', 1, 1, 15);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (5, 'Ford Escape', 'Uno de los SUVs favoritos por excelencia con muchas sutilezas, accesorios y detalles incluidos entre ellos, sensores de estacionamiento traseros, configuraciones de memoria para el asiento del conductor y los espejos exteriores, tapicería de cuero sintético, una función de arranque remoto, un volante forrado en cuero con calefacción, un sensor de apertura para la trasera, luces antiniebla y rieles laterales en el techo, son algunas de las comodidas que te brindara esta magnifica SUV.', 1, 1, 16);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (6, 'Nissan Versa', 'El sedán Nissan Versa es una excelente herramienta de transporte para llevar a los pasajeros del punto A al punto B, pero también hace que el viaje sea más agradable que muchos otros autos subcompactos. El Nissan no solo es atractivo, su motor de cuatro cilindros tiene una economía de combustible en las carreteras impresionante. El suave andar del Versa y los cómodos asientos delanteros lo convierten en un carro relajante para los desplazamientos diarios, y está disponible con más asistencia al conductor que sus compañeros de clase.', 2, 1, 7);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (7, 'Honda Accord', 'El Accord combina un perfil elegante y líneas de carrocería fluidas con un interior lleno de características, que logra un sedán con el equilibrio perfecto entre forma y función. Entre sus caracteristicas nos ofrece estilo y espacio para cinco personas, con una increíble cantidad de espacio trasero para la cabeza y las piernas. Los asientos tapizados en cuero disponibles realzan la experiencia de lujo, despidase de los cables el cargador inalambrico proporciona un facil acceso a su telefono en todo momento.', 2, 1, 12);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (8, 'Toyota Vios', 'Toyota ha declarado explícitamente que, con el modelo Toyota Vios, se han propuesto conservar las mejores cualidades que los clientes han llegado a conocer, amar, a saber, la calidad y la comodidad. Fieles a su palabra, parecen estar en el camino correcto con la nueva generación. más equipamiento, un interior más refinado y una caja de cambios completamente nueva, son propiedades del nuevo Toyota Vios, disponible en nuestras vitrinas. El Mazda3 se destaca como uno de los mejores vehículos en una clase altamente competitiva, con puntajes de seguridad de primer nivel y un rendimiento ágil', 2, 1, 10);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (9, 'Chevrolet Cruze', 'Este automovil nos ofrece gran espacio especialmente en el asiento trasero junto a un interior con cierto grado de lujo. El motor estándar es un turbo de cuatro cilindros y 1.4 litros con una transmisión manual o automática de seis velocidades. Una función de arranque-parada que reduce el uso de combustible. Las funciones de infoentretenimiento incluyen Apple CarPlay y Android Auto además invluye comandos de voz naturales a través de Siri o Google Now desde su teléfono, cuenta con asistencia para mantener el carril, asistente avanzado de parqueo, alerta de colisión frontal, iluminación inteligente, alerta de punto ciego e indicador de distancia del vehículo delantero', 2, 1, 13);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (10, 'Mazda 3', 'Este sedán deportivo es uno de los autos más divertidos de conducir en su clase y ofrece dirección dinámica, frenos sensibles y aceleración rápida. También tiene una conducción cómoda que suaviza la mayoría de las imperfecciones de la carretera. En el interior, el Mazda3 cuenta con un sistema de información y entretenimiento fácil de usar y hay materiales de lujo en toda su cabina.', 2, 1, 14);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (11, 'Chevrolet Camaro', 'El Chevrolet Camaro ofrece buen nivel de equipamiento y asistencias al conductor para que el viaje en ciudad y carretera sea más seguro, pero no deja de lado sus raíces deportivas y puede liberar todo su potencial cuando uno lo desee. Si eres fanático de los autos americanos, este muscle car es uno de los más fieles a su origen.', 3, 1, 2);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (12, 'Ford Mustang', 'Escucha el rugido de un Mustang cuando el suelo comienza a temblar y las piernas a agitarse. Como siempre, el Mustang invoca su desempeño con características de manejo mejorado, opciones de motor súper potente y diseño de Mustang clásico. El habitáculo del Ford Mustang cuenta con un diseño muy personal que aboga por las líneas curvas y la profusión de botones e interruptores, recordando enormemente a los salpicaderos que el propio Mustang ofrecía en los años 60 y 70.', 3, 1, 5);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (13, 'Hyundai Veloster', 'El Veloster un vehiculo deportivo de alto rendimiento, es la mejor opcion a la hora de querer un auto practico, con 275 caballos de fuerza y ​​un manejo que hace sonreír, el Veloster nos ofrece una experiencia unica a la hora de rodar ya sea en la ciudad o en una carretera con curvas. El diseño exclusivo de tres puertas del Veloster también lo hace un poco más práctico en comparación con aquellos de dos puertas.', 3, 1, 17);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (14, 'Mazda Mx-5', 'Llamar al Mazda MX-5 Miata un ícono automotriz no es exagerado, ya que su legado se remonta a más de 30 años y su comportamiento de conducción alegre siempre ha sido su atributo de carácter más fuerte. El motor de cuatro cilindros del Miata ofrece la potencia suficiente para que se sienta valiente además de su chasis perfectamente equilibrado, ideal para atravesar tramos con curvas de la carretera. La cabina del Miata es pequeña para dos y el espacio de carga es limitado, pero no fue hecho para viajes por carretera; Está diseñado para viajes enérgicos bañados por el sol y días de pista.', 3, 1, 21);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (15, 'Toyota Supra', 'El Toyota Supra es un deportivo biplaza japonés, de propulsión trasera y motor turboalimentado de seis cilindros. Se trata de un coche de carácter deportivo, un escaparate tecnológico para la marca, que nunca ha descuidado el confort a bordo o la utilización en el día a día. cuenta con un diseño exterior muy original en el que destacan las formas muy voluminosas de sus pasos de rueda posteriores. Además cuenta con un morro muy característico, un techo de doble burbuja y una zaga en la que destacan los pilotos y su alerón tipo “cola de pato”.', 3, 1, 22);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (16, 'Nissan Frontier', 'Durante generaciones, Nissan ha fabricado las pick ups más confiables, manteniéndose así siempre a la delantera en resistencia y durabilidad. Nissan NP300® está diseñada para satisfacer todas tus necesidades gracias a su motor, capacidad de carga y chasis reforzado ademas de sus extraordinarios ángulos de entrada (28.5°) y salida (23.6°) le permiten enfrentarse sin problema a terrenos inclinados  e inhóspitos.', 4, 1, 3);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (17, 'Toyota Hilux 2016', 'Bajo la musculosa y gran carrocería del Hilux se esconde un chasis tradicional de pick-up y vehículo todoterreno. Se trata de una plataforma de largueros y travesaños con suspensión trasera de ballesta diseñada especialmente para soportar grandes cargas, una gran capacidad off-road y una elevada versatilidad de carrocerías. La capacidad de carga de la caja permite hasta 1.040 kilogramos de carga. En función de la cabina puede albergar entre dos y cinco pasajeros, y en cuanto a cotas todoterreno ofrece 27 grados de ángulo de entrada, 27 grados de ángulo de salida y 23 grados de ángulo ventral con una profundidad de vadeo de hasta 70 centímetros con una altura libre de 29,3 centrímetros.', 4, 1, 9);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (18, 'Mitsubishi L200', 'El L200 está diseñado para enfrentarse a terrenos difíciles, con la comodidad de una berlina alemana, tiene tracción en las cuatro ruedas conmutable que se puede activar sobre la marcha. Esta cabina doble tiene un excelente consumo de combustible con cerca de dos toneladas de peso tiene recorridos de 700 a 800 km con su tanque de combustible de 75 litros, además de medidas de seguridad, desempeño integral y características electrónicas. Tiene una entrada sin llave, control de clima de doble zona y un excelente sistema de información y entretenimiento que es compatible con ApplePlay y Android Auto.', 4, 1, 18);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (19, 'Volkswagen Amarok', 'Una pickup resistente, confiable, comoda y con fuerza, asi podemos defiinir la Amarok, con un interior que combina con su exterior sumado a un fuerte y rugiente caracter bajo su capó. Gracias a su diseño este vehiculo se permite manejar ángulos y pendientes que te dejarian con la boca abierta. Su interior cuenta con mucho espacio para guardar todo lo que necesites en tus aventuras, asientos electricos con 14 movimientos y una lujosa tapiceria de cuero que te garantizan una conducción cómoda y un viaje seguro. Si lo que buscas es un 4WD de doble cabina que va por la ciudad como si de un coche deportivo se tratase, esto sera lo mas cerca cercano que podras obtener.', 4, 1, 19);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (20, 'Chevrolet Colorado', 'Al combinar excelentes modales en la carretera con un excelente rendimiento todoterreno y facilidad de uso diario, la Chevrolet Colorado se ha convertido en una de las mejores opciones a la hora de elegir una pickup. Esta pickup es para quienes tienen potencia para seguir sin importar el camino y para los que llegan a la cima, pero buscan ir más arriba. Sorpréndete con la Colorado, la más potente de su categoría y no solo por su motor, sino tambien por sus características tecnológicas que superan las expectativas. WiFi integrado con conexión para 7 dispositivos, Radio MYLINK hasta 8”, aire acondicionado con climatizador digital, 4x4 Shift On The Fly, control crucero, mandos al volante, cámara de reversa HD, asiento del conductor con ajuste eléctrico y más.', 4, 1, 20);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (21, 'Renault Sandero', 'El Renault SANDERO es el auto para todo lo que sos y entre todas tus versiones, sos alguien que disfruta del diseño. Empieza cuando lo ves por primera vez. Es más que el perfil, es más que el frente, es un estilo único; es el diseño que hace que quieras subirte y manejarlo. Aún con el auto detenido, es fluido, dinámico y avanzado.', 5, 1, 8);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (22, 'Chrysler Town', 'El Chrysler Town & Country es un gran vehículo para familias que necesitan transportar personas y carga con regularidad. Para obtener el máximo espacio para pasajeros y carga, una minivan es difícil de superar, y las opciones de asientos de Town & Country se encuentran entre las mejores de su clase. Y su manejo controlado convierte la experiencia de conducción en algo muy comodo. Las opciones de entretenimiento incluyen TV en el asiento trasero, reproductores de DVD o DVD / Blu-Ray, un potente estéreo y conectividad para iPod.', 5, 1, 4);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (23, 'Kia Carens', 'El Kia Carens es un vehículo multiusos (MPV) de tamaño medio, ideal para aquellos viajes en familia, donde el numero de asientos y la comodidad priman. El Kia Carens está muy bien equipado con asientos de cuero, navegador por satélite, algunas versiones cuentan con un techo corredizo panorámico y un sistema de estacionamiento automático.', 5, 1, 23);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (24, 'Toyota Sienna', 'La Toyota Sienna es la minivan en la que toda la familia finalmente puede estar de acuerdo gracias a su estilo exterior dinámico, interior refinado y sistema de tracción en las cuatro ruedas (AWD) disponible exclusivo en su clase. Un frontal atrevido con aberturas de rejilla superior e inferior más agresivas le dan a la Sienna su perfil llamativo. Sienna prioriza tu seguridad con Toyota Safety Sense ™ 2.0 (TSS 2.0) estándar, un conjunto de características de seguridad activa diseñadas para protegerte de lo inesperado. Las atractivas superficies de los asientos suaves al tacto, las costuras de contraste premium opcionales y una variedad de características de tecnología avanzada ayudan a que el interior de la Sienna sea lujoso y acogedor.', 5, 1, 24);
INSERT INTO products (product_id, name, description, category_id, city_id, specs_id) VALUES (25, 'Honda Odyssey', 'La Odyssey está lista para emprender aventuras familiares con estilo, con una parrilla negra brillante, faros LED y rines de 19 pulgadas disponibles, el lujo y estilo hacen parte de su ADN. Los niveles de equipamiento superiores cuentan con una aspiradora oculta en el área de carga, un sistema de intercomunicador para que pueda hablar con los pasajeros sin levantar la voz y un sistema de cámara interior, que es útil para vigilar a los ruidosos pasajeros del asiento trasero.', 5, 1, 25);
-- Images of products
INSERT INTO product_images_ids VALUES (1, 24);
INSERT INTO product_images_ids VALUES (1, 25);
INSERT INTO product_images_ids VALUES (1, 26);
INSERT INTO product_images_ids VALUES (1, 27);
INSERT INTO product_images_ids VALUES (1, 133);
INSERT INTO product_images_ids VALUES (1, 134);
INSERT INTO product_images_ids VALUES (1, 135);
INSERT INTO product_images_ids VALUES (1, 136);
INSERT INTO product_images_ids VALUES (1, 137);

INSERT INTO product_images_ids VALUES (2, 52);
INSERT INTO product_images_ids VALUES (2, 53);
INSERT INTO product_images_ids VALUES (2, 54);
INSERT INTO product_images_ids VALUES (2, 55);
INSERT INTO product_images_ids VALUES (2, 168);
INSERT INTO product_images_ids VALUES (2, 169);
INSERT INTO product_images_ids VALUES (2, 170);
INSERT INTO product_images_ids VALUES (2, 171);
INSERT INTO product_images_ids VALUES (2, 172);

INSERT INTO product_images_ids VALUES (3, 68);
INSERT INTO product_images_ids VALUES (3, 69);
INSERT INTO product_images_ids VALUES (3, 70);
INSERT INTO product_images_ids VALUES (3, 71);
INSERT INTO product_images_ids VALUES (3, 193);
INSERT INTO product_images_ids VALUES (3, 194);
INSERT INTO product_images_ids VALUES (3, 195);
INSERT INTO product_images_ids VALUES (3, 196);
INSERT INTO product_images_ids VALUES (3, 197);

INSERT INTO product_images_ids VALUES (4, 64);
INSERT INTO product_images_ids VALUES (4, 65);
INSERT INTO product_images_ids VALUES (4, 66);
INSERT INTO product_images_ids VALUES (4, 67);
INSERT INTO product_images_ids VALUES (4, 183);
INSERT INTO product_images_ids VALUES (4, 184);
INSERT INTO product_images_ids VALUES (4, 185);
INSERT INTO product_images_ids VALUES (4, 186);
INSERT INTO product_images_ids VALUES (4, 187);

INSERT INTO product_images_ids VALUES (5, 40);
INSERT INTO product_images_ids VALUES (5, 41);
INSERT INTO product_images_ids VALUES (5, 42);
INSERT INTO product_images_ids VALUES (5, 43);
INSERT INTO product_images_ids VALUES (5, 153);
INSERT INTO product_images_ids VALUES (5, 154);
INSERT INTO product_images_ids VALUES (5, 155);
INSERT INTO product_images_ids VALUES (5, 156);
INSERT INTO product_images_ids VALUES (5, 157);

INSERT INTO product_images_ids VALUES (6, 92);
INSERT INTO product_images_ids VALUES (6, 93);
INSERT INTO product_images_ids VALUES (6, 94);
INSERT INTO product_images_ids VALUES (6, 95);
INSERT INTO product_images_ids VALUES (6, 218);
INSERT INTO product_images_ids VALUES (6, 219);
INSERT INTO product_images_ids VALUES (6, 220);
INSERT INTO product_images_ids VALUES (6, 221);
INSERT INTO product_images_ids VALUES (6, 222);

INSERT INTO product_images_ids VALUES (7, 48);
INSERT INTO product_images_ids VALUES (7, 49);
INSERT INTO product_images_ids VALUES (7, 50);
INSERT INTO product_images_ids VALUES (7, 51);
INSERT INTO product_images_ids VALUES (7, 163);
INSERT INTO product_images_ids VALUES (7, 164);
INSERT INTO product_images_ids VALUES (7, 165);
INSERT INTO product_images_ids VALUES (7, 166);
INSERT INTO product_images_ids VALUES (7, 167);

INSERT INTO product_images_ids VALUES (8, 120);
INSERT INTO product_images_ids VALUES (8, 121);
INSERT INTO product_images_ids VALUES (8, 122);
INSERT INTO product_images_ids VALUES (8, 123);
INSERT INTO product_images_ids VALUES (8, 243);
INSERT INTO product_images_ids VALUES (8, 244);
INSERT INTO product_images_ids VALUES (8, 245);
INSERT INTO product_images_ids VALUES (8, 246);
INSERT INTO product_images_ids VALUES (8, 247);

INSERT INTO product_images_ids VALUES (9, 32);
INSERT INTO product_images_ids VALUES (9, 33);
INSERT INTO product_images_ids VALUES (9, 34);
INSERT INTO product_images_ids VALUES (9, 35);
INSERT INTO product_images_ids VALUES (9, 143);
INSERT INTO product_images_ids VALUES (9, 144);
INSERT INTO product_images_ids VALUES (9, 145);
INSERT INTO product_images_ids VALUES (9, 146);
INSERT INTO product_images_ids VALUES (9, 147);

INSERT INTO product_images_ids VALUES (10, 76);
INSERT INTO product_images_ids VALUES (10, 77);
INSERT INTO product_images_ids VALUES (10, 78);
INSERT INTO product_images_ids VALUES (10, 79);
INSERT INTO product_images_ids VALUES (10, 198);
INSERT INTO product_images_ids VALUES (10, 199);
INSERT INTO product_images_ids VALUES (10, 200);
INSERT INTO product_images_ids VALUES (10, 201);
INSERT INTO product_images_ids VALUES (10, 202);

INSERT INTO product_images_ids VALUES (11, 20);
INSERT INTO product_images_ids VALUES (11, 21);
INSERT INTO product_images_ids VALUES (11, 22);
INSERT INTO product_images_ids VALUES (11, 23);
INSERT INTO product_images_ids VALUES (11, 128);
INSERT INTO product_images_ids VALUES (11, 129);
INSERT INTO product_images_ids VALUES (11, 130);
INSERT INTO product_images_ids VALUES (11, 131);
INSERT INTO product_images_ids VALUES (11, 132);

INSERT INTO product_images_ids VALUES (12, 44);
INSERT INTO product_images_ids VALUES (12, 45);
INSERT INTO product_images_ids VALUES (12, 46);
INSERT INTO product_images_ids VALUES (12, 47);
INSERT INTO product_images_ids VALUES (12, 158);
INSERT INTO product_images_ids VALUES (12, 159);
INSERT INTO product_images_ids VALUES (12, 160);
INSERT INTO product_images_ids VALUES (12, 161);
INSERT INTO product_images_ids VALUES (12, 162);

INSERT INTO product_images_ids VALUES (13, 60);
INSERT INTO product_images_ids VALUES (13, 61);
INSERT INTO product_images_ids VALUES (13, 62);
INSERT INTO product_images_ids VALUES (13, 63);
INSERT INTO product_images_ids VALUES (13, 178);
INSERT INTO product_images_ids VALUES (13, 179);
INSERT INTO product_images_ids VALUES (13, 180);
INSERT INTO product_images_ids VALUES (13, 181);
INSERT INTO product_images_ids VALUES (13, 182);

INSERT INTO product_images_ids VALUES (14, 80);
INSERT INTO product_images_ids VALUES (14, 81);
INSERT INTO product_images_ids VALUES (14, 82);
INSERT INTO product_images_ids VALUES (14, 83);
INSERT INTO product_images_ids VALUES (14, 203);
INSERT INTO product_images_ids VALUES (14, 204);
INSERT INTO product_images_ids VALUES (14, 205);
INSERT INTO product_images_ids VALUES (14, 206);
INSERT INTO product_images_ids VALUES (14, 207);

INSERT INTO product_images_ids VALUES (15, 116);
INSERT INTO product_images_ids VALUES (15, 117);
INSERT INTO product_images_ids VALUES (15, 118);
INSERT INTO product_images_ids VALUES (15, 119);
INSERT INTO product_images_ids VALUES (15, 238);
INSERT INTO product_images_ids VALUES (15, 239);
INSERT INTO product_images_ids VALUES (15, 240);
INSERT INTO product_images_ids VALUES (15, 241);
INSERT INTO product_images_ids VALUES (15, 242);

INSERT INTO product_images_ids VALUES (16, 88);
INSERT INTO product_images_ids VALUES (16, 89);
INSERT INTO product_images_ids VALUES (16, 90);
INSERT INTO product_images_ids VALUES (16, 91);
INSERT INTO product_images_ids VALUES (16, 213);
INSERT INTO product_images_ids VALUES (16, 214);
INSERT INTO product_images_ids VALUES (16, 215);
INSERT INTO product_images_ids VALUES (16, 216);
INSERT INTO product_images_ids VALUES (16, 217);

INSERT INTO product_images_ids VALUES (17, 108);
INSERT INTO product_images_ids VALUES (17, 109);
INSERT INTO product_images_ids VALUES (17, 110);
INSERT INTO product_images_ids VALUES (17, 111);
INSERT INTO product_images_ids VALUES (17, 228);
INSERT INTO product_images_ids VALUES (17, 229);
INSERT INTO product_images_ids VALUES (17, 230);
INSERT INTO product_images_ids VALUES (17, 231);
INSERT INTO product_images_ids VALUES (17, 232);

INSERT INTO product_images_ids VALUES (18, 84);
INSERT INTO product_images_ids VALUES (18, 85);
INSERT INTO product_images_ids VALUES (18, 86);
INSERT INTO product_images_ids VALUES (18, 87);
INSERT INTO product_images_ids VALUES (18, 208);
INSERT INTO product_images_ids VALUES (18, 209);
INSERT INTO product_images_ids VALUES (18, 210);
INSERT INTO product_images_ids VALUES (18, 211);
INSERT INTO product_images_ids VALUES (18, 212);

INSERT INTO product_images_ids VALUES (19, 124);
INSERT INTO product_images_ids VALUES (19, 125);
INSERT INTO product_images_ids VALUES (19, 126);
INSERT INTO product_images_ids VALUES (19, 127);
INSERT INTO product_images_ids VALUES (19, 248);
INSERT INTO product_images_ids VALUES (19, 249);
INSERT INTO product_images_ids VALUES (19, 250);
INSERT INTO product_images_ids VALUES (19, 251);
INSERT INTO product_images_ids VALUES (19, 258);

INSERT INTO product_images_ids VALUES (20, 28);
INSERT INTO product_images_ids VALUES (20, 29);
INSERT INTO product_images_ids VALUES (20, 30);
INSERT INTO product_images_ids VALUES (20, 31);
INSERT INTO product_images_ids VALUES (20, 138);
INSERT INTO product_images_ids VALUES (20, 139);
INSERT INTO product_images_ids VALUES (20, 140);
INSERT INTO product_images_ids VALUES (20, 141);
INSERT INTO product_images_ids VALUES (20, 142);

INSERT INTO product_images_ids VALUES (21, 100);
INSERT INTO product_images_ids VALUES (21, 101);
INSERT INTO product_images_ids VALUES (21, 102);
INSERT INTO product_images_ids VALUES (21, 103);
INSERT INTO product_images_ids VALUES (21, 223);
INSERT INTO product_images_ids VALUES (21, 224);
INSERT INTO product_images_ids VALUES (21, 225);
INSERT INTO product_images_ids VALUES (21, 226);
INSERT INTO product_images_ids VALUES (21, 227);

INSERT INTO product_images_ids VALUES (22, 36);
INSERT INTO product_images_ids VALUES (22, 37);
INSERT INTO product_images_ids VALUES (22, 38);
INSERT INTO product_images_ids VALUES (22, 39);
INSERT INTO product_images_ids VALUES (22, 148);
INSERT INTO product_images_ids VALUES (22, 149);
INSERT INTO product_images_ids VALUES (22, 150);
INSERT INTO product_images_ids VALUES (22, 151);
INSERT INTO product_images_ids VALUES (22, 152);

INSERT INTO product_images_ids VALUES (23, 72);
INSERT INTO product_images_ids VALUES (23, 73);
INSERT INTO product_images_ids VALUES (23, 74);
INSERT INTO product_images_ids VALUES (23, 75);
INSERT INTO product_images_ids VALUES (23, 188);
INSERT INTO product_images_ids VALUES (23, 189);
INSERT INTO product_images_ids VALUES (23, 190);
INSERT INTO product_images_ids VALUES (23, 191);
INSERT INTO product_images_ids VALUES (23, 192);

INSERT INTO product_images_ids VALUES (24, 112);
INSERT INTO product_images_ids VALUES (24, 113);
INSERT INTO product_images_ids VALUES (24, 114);
INSERT INTO product_images_ids VALUES (24, 115);
INSERT INTO product_images_ids VALUES (24, 233);
INSERT INTO product_images_ids VALUES (24, 234);
INSERT INTO product_images_ids VALUES (24, 235);
INSERT INTO product_images_ids VALUES (24, 236);
INSERT INTO product_images_ids VALUES (24, 247);

INSERT INTO product_images_ids VALUES (25, 56);
INSERT INTO product_images_ids VALUES (25, 57);
INSERT INTO product_images_ids VALUES (25, 58);
INSERT INTO product_images_ids VALUES (25, 59);
INSERT INTO product_images_ids VALUES (25, 173);
INSERT INTO product_images_ids VALUES (25, 174);
INSERT INTO product_images_ids VALUES (25, 175);
INSERT INTO product_images_ids VALUES (25, 176);
INSERT INTO product_images_ids VALUES (25, 177);

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
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2020-10-05 09:30:15', '2020-11-02 14:00:00', '2020-11-07 15:00:00', 1, 3);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-04-09 17:23:12', '2021-04-13 09:00:00', '2021-04-16 08:00:00', 3, 2);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-06-23 12:34:07', '2021-07-01 20:00:00', '2021-07-06 13:00:00', 1, 3);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-10-07 21:45:30', '2021-10-10 17:00:00', '2021-10-12 20:00:00', 2, 4);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-11-16 14:50:10', '2021-11-12 08:00:00', '2021-11-24 15:00:00', 3, 5);

-- Data for test product 1
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id) VALUES ('2021-10-30 13:23:34', '2021-11-15 16:00:00', '2021-11-21 09:00:00', 1, 3);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-11-01 14:15:25', '2021-11-10 18:00:00', '2021-01-14 16:00:00', 2, 3);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-09-30 05:15:25', '2021-11-21 18:00:00', '2021-11-25 12:00:00', 3, 3);
INSERT INTO bookings (time_booking, start_time, finish_time, user_id, product_product_id ) VALUES ('2021-11-10 11:15:25', '2021-11-30 13:00:00', '2021-12-10 12:00:00', 4, 3);


DROP TABLE IF EXISTS terms_and_conditions;
DROP TABLE IF EXISTS products_terms_and_conditions;

CREATE TABLE `terms_and_conditions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `icon_id` bigint DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `products_terms_and_conditions` (
  `product_product_id` bigint NOT NULL,
  `terms_and_conditions_id` bigint NOT NULL,
  KEY `FK47whtrsqt1qrdl0qu1iijbnyg` (`terms_and_conditions_id`),
  KEY `FKp6609h598o0dfnh8uh6hpm658` (`product_product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO terms_and_conditions (id, title, description, icon_id) VALUES (1, 'Cancelacion', 'Podra cancelar gratis y sin penalización 24 hrs antes de la hora programada para iniciar la reserva, podra hacerlo a través del portal web en la linea telefonica 6325685.', 257);
INSERT INTO terms_and_conditions (id, title, description, icon_id) VALUES (2, 'Gastos Asumido', 'Cualquier daño, multa o penalización alguna producto del usuario titular de la reserva sera asumida en su totalidad economicamente y de completa responsabilidad de este. ', 255);
INSERT INTO terms_and_conditions (id, title, description, icon_id) VALUES (3, 'Documentos Exigidos', 'Recuerde su DNI o Pasaporte a la hora de retirar el vehiculo, y recuerde portar siempre con usted su licencia de conducción valida para las autoridades del país.', 254);
INSERT INTO terms_and_conditions (id, title, description, icon_id) VALUES (4, 'Modificación', 'Modifique su reserva sin penalidad alguna en cualquier momento, bajo los horarios y vehiculos disponibles, no se haran devolucion por reducción del valor de la reserva, y el usuario asumira diferencias de valor.', 256);
INSERT INTO terms_and_conditions (id, title, description, icon_id) VALUES (5, 'Limites de Rodaje', 'Mantenga el vehiculo dentro de las fronteras del territorio nacional, si desea salir de este, debera acercarse a una de nuestras oficinas y seguir el proceso con un asesor.', 258);
INSERT INTO terms_and_conditions (id, title, description, icon_id) VALUES (6, 'Soporte 24/7', 'Comunicate con nuestro soporte telefonico disponible las 24 hrs del dia los 7 dias de la semana, nuestro equipo estara dispuesto a ayudarte ante cualquier eventualidad o asistencia que solicites', 253);

-- terms and conditions of product
INSERT INTO products_terms_and_conditions VALUES (1, 1);
INSERT INTO products_terms_and_conditions VALUES (1, 2);
INSERT INTO products_terms_and_conditions VALUES (1, 3);
INSERT INTO products_terms_and_conditions VALUES (1, 4);
INSERT INTO products_terms_and_conditions VALUES (1, 5);
INSERT INTO products_terms_and_conditions VALUES (1, 6);
INSERT INTO products_terms_and_conditions VALUES (2, 1);
INSERT INTO products_terms_and_conditions VALUES (2, 2);
INSERT INTO products_terms_and_conditions VALUES (2, 3);
INSERT INTO products_terms_and_conditions VALUES (2, 4);
INSERT INTO products_terms_and_conditions VALUES (2, 5);
INSERT INTO products_terms_and_conditions VALUES (2, 6);
INSERT INTO products_terms_and_conditions VALUES (3, 1);
INSERT INTO products_terms_and_conditions VALUES (3, 2);
INSERT INTO products_terms_and_conditions VALUES (3, 3);
INSERT INTO products_terms_and_conditions VALUES (3, 4);
INSERT INTO products_terms_and_conditions VALUES (3, 5);
INSERT INTO products_terms_and_conditions VALUES (3, 6);
INSERT INTO products_terms_and_conditions VALUES (4, 1);
INSERT INTO products_terms_and_conditions VALUES (4, 2);
INSERT INTO products_terms_and_conditions VALUES (4, 3);
INSERT INTO products_terms_and_conditions VALUES (4, 4);
INSERT INTO products_terms_and_conditions VALUES (4, 5);
INSERT INTO products_terms_and_conditions VALUES (4, 6);
INSERT INTO products_terms_and_conditions VALUES (5, 1);
INSERT INTO products_terms_and_conditions VALUES (5, 2);
INSERT INTO products_terms_and_conditions VALUES (5, 3);
INSERT INTO products_terms_and_conditions VALUES (5, 4);
INSERT INTO products_terms_and_conditions VALUES (5, 5);
INSERT INTO products_terms_and_conditions VALUES (5, 6);
INSERT INTO products_terms_and_conditions VALUES (6, 1);
INSERT INTO products_terms_and_conditions VALUES (6, 2);
INSERT INTO products_terms_and_conditions VALUES (6, 3);
INSERT INTO products_terms_and_conditions VALUES (6, 4);
INSERT INTO products_terms_and_conditions VALUES (6, 5);
INSERT INTO products_terms_and_conditions VALUES (6, 6);
INSERT INTO products_terms_and_conditions VALUES (7, 1);
INSERT INTO products_terms_and_conditions VALUES (7, 2);
INSERT INTO products_terms_and_conditions VALUES (7, 3);
INSERT INTO products_terms_and_conditions VALUES (7, 4);
INSERT INTO products_terms_and_conditions VALUES (7, 5);
INSERT INTO products_terms_and_conditions VALUES (7, 6);
INSERT INTO products_terms_and_conditions VALUES (8, 1);
INSERT INTO products_terms_and_conditions VALUES (8, 2);
INSERT INTO products_terms_and_conditions VALUES (8, 3);
INSERT INTO products_terms_and_conditions VALUES (8, 4);
INSERT INTO products_terms_and_conditions VALUES (8, 5);
INSERT INTO products_terms_and_conditions VALUES (8, 6);
INSERT INTO products_terms_and_conditions VALUES (9, 1);
INSERT INTO products_terms_and_conditions VALUES (9, 2);
INSERT INTO products_terms_and_conditions VALUES (9, 3);
INSERT INTO products_terms_and_conditions VALUES (9, 4);
INSERT INTO products_terms_and_conditions VALUES (9, 5);
INSERT INTO products_terms_and_conditions VALUES (9, 6);
INSERT INTO products_terms_and_conditions VALUES (10, 1);
INSERT INTO products_terms_and_conditions VALUES (10, 2);
INSERT INTO products_terms_and_conditions VALUES (10, 3);
INSERT INTO products_terms_and_conditions VALUES (10, 4);
INSERT INTO products_terms_and_conditions VALUES (10, 5);
INSERT INTO products_terms_and_conditions VALUES (10, 6);
INSERT INTO products_terms_and_conditions VALUES (11, 1);
INSERT INTO products_terms_and_conditions VALUES (11, 2);
INSERT INTO products_terms_and_conditions VALUES (11, 3);
INSERT INTO products_terms_and_conditions VALUES (11, 4);
INSERT INTO products_terms_and_conditions VALUES (11, 5);
INSERT INTO products_terms_and_conditions VALUES (11, 6);
INSERT INTO products_terms_and_conditions VALUES (12, 1);
INSERT INTO products_terms_and_conditions VALUES (12, 2);
INSERT INTO products_terms_and_conditions VALUES (12, 3);
INSERT INTO products_terms_and_conditions VALUES (12, 4);
INSERT INTO products_terms_and_conditions VALUES (12, 5);
INSERT INTO products_terms_and_conditions VALUES (12, 6);
INSERT INTO products_terms_and_conditions VALUES (13, 1);
INSERT INTO products_terms_and_conditions VALUES (13, 2);
INSERT INTO products_terms_and_conditions VALUES (13, 3);
INSERT INTO products_terms_and_conditions VALUES (13, 4);
INSERT INTO products_terms_and_conditions VALUES (13, 5);
INSERT INTO products_terms_and_conditions VALUES (13, 6);
INSERT INTO products_terms_and_conditions VALUES (14, 1);
INSERT INTO products_terms_and_conditions VALUES (14, 2);
INSERT INTO products_terms_and_conditions VALUES (14, 3);
INSERT INTO products_terms_and_conditions VALUES (14, 4);
INSERT INTO products_terms_and_conditions VALUES (14, 5);
INSERT INTO products_terms_and_conditions VALUES (14, 6);
INSERT INTO products_terms_and_conditions VALUES (15, 1);
INSERT INTO products_terms_and_conditions VALUES (15, 2);
INSERT INTO products_terms_and_conditions VALUES (15, 3);
INSERT INTO products_terms_and_conditions VALUES (15, 4);
INSERT INTO products_terms_and_conditions VALUES (15, 5);
INSERT INTO products_terms_and_conditions VALUES (15, 6);
INSERT INTO products_terms_and_conditions VALUES (16, 1);
INSERT INTO products_terms_and_conditions VALUES (16, 2);
INSERT INTO products_terms_and_conditions VALUES (16, 3);
INSERT INTO products_terms_and_conditions VALUES (16, 4);
INSERT INTO products_terms_and_conditions VALUES (16, 5);
INSERT INTO products_terms_and_conditions VALUES (16, 6);
INSERT INTO products_terms_and_conditions VALUES (17, 1);
INSERT INTO products_terms_and_conditions VALUES (17, 2);
INSERT INTO products_terms_and_conditions VALUES (17, 3);
INSERT INTO products_terms_and_conditions VALUES (17, 4);
INSERT INTO products_terms_and_conditions VALUES (17, 5);
INSERT INTO products_terms_and_conditions VALUES (17, 6);
INSERT INTO products_terms_and_conditions VALUES (18, 1);
INSERT INTO products_terms_and_conditions VALUES (18, 2);
INSERT INTO products_terms_and_conditions VALUES (18, 3);
INSERT INTO products_terms_and_conditions VALUES (18, 4);
INSERT INTO products_terms_and_conditions VALUES (18, 5);
INSERT INTO products_terms_and_conditions VALUES (18, 6);
INSERT INTO products_terms_and_conditions VALUES (19, 1);
INSERT INTO products_terms_and_conditions VALUES (19, 2);
INSERT INTO products_terms_and_conditions VALUES (19, 3);
INSERT INTO products_terms_and_conditions VALUES (19, 4);
INSERT INTO products_terms_and_conditions VALUES (19, 5);
INSERT INTO products_terms_and_conditions VALUES (19, 6);
INSERT INTO products_terms_and_conditions VALUES (20, 1);
INSERT INTO products_terms_and_conditions VALUES (20, 2);
INSERT INTO products_terms_and_conditions VALUES (20, 3);
INSERT INTO products_terms_and_conditions VALUES (20, 4);
INSERT INTO products_terms_and_conditions VALUES (20, 5);
INSERT INTO products_terms_and_conditions VALUES (20, 6);
INSERT INTO products_terms_and_conditions VALUES (21, 1);
INSERT INTO products_terms_and_conditions VALUES (21, 2);
INSERT INTO products_terms_and_conditions VALUES (21, 3);
INSERT INTO products_terms_and_conditions VALUES (21, 4);
INSERT INTO products_terms_and_conditions VALUES (21, 5);
INSERT INTO products_terms_and_conditions VALUES (21, 6);
INSERT INTO products_terms_and_conditions VALUES (22, 1);
INSERT INTO products_terms_and_conditions VALUES (22, 2);
INSERT INTO products_terms_and_conditions VALUES (22, 3);
INSERT INTO products_terms_and_conditions VALUES (22, 4);
INSERT INTO products_terms_and_conditions VALUES (22, 5);
INSERT INTO products_terms_and_conditions VALUES (22, 6);
INSERT INTO products_terms_and_conditions VALUES (23, 1);
INSERT INTO products_terms_and_conditions VALUES (23, 2);
INSERT INTO products_terms_and_conditions VALUES (23, 3);
INSERT INTO products_terms_and_conditions VALUES (23, 4);
INSERT INTO products_terms_and_conditions VALUES (23, 5);
INSERT INTO products_terms_and_conditions VALUES (23, 6);
INSERT INTO products_terms_and_conditions VALUES (24, 1);
INSERT INTO products_terms_and_conditions VALUES (24, 2);
INSERT INTO products_terms_and_conditions VALUES (24, 3);
INSERT INTO products_terms_and_conditions VALUES (24, 4);
INSERT INTO products_terms_and_conditions VALUES (24, 5);
INSERT INTO products_terms_and_conditions VALUES (24, 6);
INSERT INTO products_terms_and_conditions VALUES (25, 1);
INSERT INTO products_terms_and_conditions VALUES (25, 2);
INSERT INTO products_terms_and_conditions VALUES (25, 3);
INSERT INTO products_terms_and_conditions VALUES (25, 4);
INSERT INTO products_terms_and_conditions VALUES (25, 5);
INSERT INTO products_terms_and_conditions VALUES (25, 6);

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
  `verified` bigint NOT NULL,
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
INSERT INTO users (name, last_name, email, password, verified, role_id) VALUES ("Sergio", "Garcia", "sergiogarcia@gmail.com", "$2a$10$QlLVjuZo78y089053BCH7eH2.X6QLaeWJlqESgvspUOOvDz0jg44e", 1, 1);
INSERT INTO users (name, last_name, email, password, verified, role_id) VALUES ("Lina", "Huertas", "linahuertas@gmail.com", "$2a$10$QimXJjW0WrWEuMq79l/1AuOweIRM6E3khvtBAbgsTaMiwomTRQROy", 1, 3);
INSERT INTO users (name, last_name, email, password, verified, role_id) VALUES ("Juan", "Rojas", "juanrojas@email.com", "$2a$10$747KQfpn43IjjLQ8cwgh2.8fzbcxfBLmIg3XgiZc8ema3y64NBX.a", 1, 3);

/* PROCEDURES */
USE digitalRentcarProducts;
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
