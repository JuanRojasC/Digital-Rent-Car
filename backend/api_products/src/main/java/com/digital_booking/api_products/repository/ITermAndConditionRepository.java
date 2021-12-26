package com.digital_booking.api_products.repository;

import com.digital_booking.api_products.model.TermAndCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITermAndConditionRepository extends JpaRepository<TermAndCondition, Long> {
}
