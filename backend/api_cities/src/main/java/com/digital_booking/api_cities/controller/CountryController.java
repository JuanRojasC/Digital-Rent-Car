package com.digital_booking.api_cities.controller;

import com.digital_booking.api_cities.exceptions.ResourceNotFound;
import com.digital_booking.api_cities.model.Country;
import com.digital_booking.api_cities.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryController) {
        this.countryService = countryController;
    }

    // POST REQUEST
    @PostMapping("/save/new")
    public ResponseEntity<?> saveCountry(@RequestBody Country c){
        Country country = countryService.saveCountry(c);
        return ResponseEntity.status(HttpStatus.OK).body(country);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllCountries(){
        return ResponseEntity.status(HttpStatus.OK).body(countryService.findAllCountries());
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long id) throws ResourceNotFound {
        countryService.deleteCountryById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ciudad Eliminada");
    }
}
