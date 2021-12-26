package com.digital_booking.api_cities.repository;

import com.digital_booking.api_cities.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ICityRepository extends JpaRepository<City,Long> {

    @Query("FROM City c WHERE c.country.id = ?1")
    Collection<City> findByCountryId(Long id);
}
