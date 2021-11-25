USE digitalRentcarProducts;

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

DELIMITER --
CREATE PROCEDURE findBooking (IN check_in DATETIME, IN check_out DATETIME)
BEGIN
	SELECT * FROM bookings
    WHERE (start_time <= check_in AND finish_time >= check_in AND finish_time <= check_out) /*Before*/
    OR (start_time >= check_in AND finish_time <= check_out) /*Middle*/
    OR (start_time <= check_in AND finish_time >= check_out) /*Complete*/
    OR (start_time >= check_in AND start_time < check_out AND finish_time >= check_out); /*After*/
END --
