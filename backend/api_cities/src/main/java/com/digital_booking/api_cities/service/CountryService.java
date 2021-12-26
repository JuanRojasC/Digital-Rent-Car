package com.digital_booking.api_cities.service;

import com.digital_booking.api_cities.exceptions.ResourceNotFound;
import com.digital_booking.api_cities.model.City;
import com.digital_booking.api_cities.model.Country;
import com.digital_booking.api_cities.repository.ICountryRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Log4j
@Service
public class CountryService {

    private ICountryRepository countryRepository;

    @Autowired
    public CountryService(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /*-------------------------------------------Save Country-------------------------------------------*/

    public Country saveCountry(Country country){
        country.setId(null);
        Country countryResponse = countryRepository.save(country);
        log.info("Se guardo el pais " + countryResponse.getName() + " con id " + countryResponse.getId());
        return countryResponse;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Country findCountryById(Long id) throws ResourceNotFound {
        Optional<Country> country = countryRepository.findById(id);
        if(country.isEmpty()){
            throw new ResourceNotFound("No se encontró el country con id "+ id);
        }else {
            log.info("Se busco country con id "+id);
            return country.get();
        }
    }

    /*-------------------------------------------Update Country-------------------------------------------*/

    public Country updateCountry(Country country) throws ResourceNotFound {
        findCountryById(country.getId());
        log.info("Se actualizo el country con id " + country.getId() + ": " + country.getName());
        return countryRepository.save(country);
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteCountryById(Long id) throws ResourceNotFound {
        findCountryById(id);
        countryRepository.deleteById(id);
        log.info("Se elimino el country con id: " + id);
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<Country> findAllCountries(){
        return countryRepository.findAll();
    }
}
