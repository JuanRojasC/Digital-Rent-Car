USE digitalRentcarProducts;

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_images_ids;
DROP TABLE IF EXISTS terms_and_conditions;

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
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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

