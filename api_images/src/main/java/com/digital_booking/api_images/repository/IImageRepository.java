package com.digital_booking.api_images.repository;

import com.digital_booking.api_images.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image,Long> {
}
