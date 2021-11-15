package com.digital_booking.api_specs.repository;

import com.digital_booking.api_specs.model.Specs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpecsRepository extends JpaRepository<Specs, Long> {
}
