package com.digital_booking.api_cities.controller;

import com.digital_booking.api_cities.exceptions.IncompleteData;
import com.digital_booking.api_cities.exceptions.ResourceNotFound;
import com.digital_booking.api_cities.model.City;
import com.digital_booking.api_cities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    // POST REQUEST
    @PostMapping("/save/new")
    public ResponseEntity<?> saveCity(@RequestBody City c) throws ResourceNotFound, IncompleteData {
        City city= cityService.saveCity(c);
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @PostMapping("/find/ids")
    public ResponseEntity<?> findCitiesByIds(@RequestBody Collection<Long> citiesIds){
        Collection<City> cities = cityService.findAllCitiesById(citiesIds);
        return ResponseEntity.status(HttpStatus.OK).body(cities);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllCities(){
        return ResponseEntity.ok(cityService.findAllCities());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findCityById(@PathVariable Long id) throws ResourceNotFound {
        City city = cityService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @GetMapping("/find/country/{countryId}")
    public ResponseEntity<?> findCityByCountryId(@PathVariable Long countryId){
        return ResponseEntity.status(HttpStatus.OK).body(cityService.findByCountryId(countryId));
    }

    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @PutMapping("/update/city")
    public ResponseEntity<?> editCity(@RequestBody City c) throws ResourceNotFound, IncompleteData {
        cityService.updateCity(c);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long id) throws ResourceNotFound {
        cityService.deleteCityById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ciudad Eliminada");
    }
}
