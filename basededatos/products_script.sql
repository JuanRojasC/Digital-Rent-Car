USE digitalRentcarProducts;

DROP TABLE products;
DROP TABLE product_images_ids;

CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `main_image_id` bigint DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `city_id` bigint DEFAULT NULL,
  `specs_id` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product_images_ids` (
  `product_product_id` bigint NOT NULL,
  `images_ids` bigint DEFAULT NULL,
  KEY `FKckslx18g4kv72jvqq6mria22c` (`product_product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

