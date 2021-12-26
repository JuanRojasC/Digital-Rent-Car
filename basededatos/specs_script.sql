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
