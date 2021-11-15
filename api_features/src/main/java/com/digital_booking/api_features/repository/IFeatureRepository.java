package com.digital_booking.api_features.repository;

import com.digital_booking.api_features.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeatureRepository extends JpaRepository<Feature,Long> {


}
