USE digitalRentcarCities;

-- COUNTRIES
INSERT INTO countries (name) VALUES ('Argentina');
INSERT INTO countries (name) VALUES ('Colombia');

-- CITIES
INSERT INTO cities (latitude, longitude, name, country_id) VALUES (-34.61315, -58.37723, 'Ciudad de Buenos Aires', (select country_id from countries where name = 'Argentina'));
INSERT INTO cities (latitude, longitude, name, country_id) VALUES (4.60971, -74.08175, 'Bogota DC', (select country_id from countries where name = 'Colombia'));