package com.digital_booking.api_products.feignclients;

import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "cities-service", url = "http://localhost:9002")
@RequestMapping("/cities")
public interface CityFeignClient {

    @GetMapping("/find/{id}")
    City findCityById(@PathVariable Long id) throws ResourceNotFound;

    @GetMapping("/find/all")
    Collection<City> findAllCities();

    @GetMapping("/find/country/{countryId}")
    Collection<City> findCityByCountryId(@PathVariable Long countryId);

    @PostMapping("/find/ids")
    Collection<City> findCitiesByIds(@RequestBody Collection<Long> citiesIds);

}
