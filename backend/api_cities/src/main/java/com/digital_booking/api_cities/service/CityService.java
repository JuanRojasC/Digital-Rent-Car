package com.digital_booking.api_cities.service;

import com.digital_booking.api_cities.cache.CacheCities;
import com.digital_booking.api_cities.exceptions.IncompleteData;
import com.digital_booking.api_cities.exceptions.ResourceNotFound;
import com.digital_booking.api_cities.model.City;
import com.digital_booking.api_cities.repository.ICityRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Log4j
@Service
public class CityService {

    private ICityRepository cityRepository;
    private CountryService countryService;
    private CacheCities cacheCities;

    @Autowired
    public CityService(ICityRepository cityRepository, CacheCities cacheCities, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
        this.cacheCities = cacheCities;
    }

    /*-------------------------------------------Save City-------------------------------------------*/

    public City saveCity(City c) throws ResourceNotFound, IncompleteData {
        c.setId(null);
        if(c.getCountry().getId() != null) c.setCountry(countryService.findCountryById(c.getCountry().getId()));
        else throw new IncompleteData("Especifique el id del country donde se ubica la city");
        City city = cityRepository.save(c);
        log.info("Se guardo la city con id " + city.getId() + ": " + city.getName());
        return city;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public City findById(Long id) throws ResourceNotFound {
        City city = this.cacheCities.checkCacheForCity(id);
        city = city == null? cityRepository.findById(id).get() : city;
        if(city == null){
            throw new ResourceNotFound("No se encontró la ciudad con id "+ id);
        }else {
            log.info("Se busco city con id "+id);
            return city;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<City> findAllCitiesById(Collection<Long> ids){
        log.info("Se bucaron las ciudades con ids: " + ids);
        return cityRepository.findAllById(ids);
    }

    /*-------------------------------------------Update City-------------------------------------------*/

    public City updateCity(City c) throws ResourceNotFound, IncompleteData {
        if(c.getId() != null ) findById(c.getId());
        else throw new IncompleteData("El id de la ciudad no puede ser nulo");
        log.info("Se actualizo la city con id " + c.getId() + ": " + c.getName());
        return cityRepository.save(c);
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteCityById(Long id) throws ResourceNotFound {
        findById(id);
        log.info("Se elimino la city con id " + id);
        cityRepository.deleteById(id);
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<City> findAllCities(){
        log.info("Se buscaron todas las ciudades");
        return cityRepository.findAll();
    }

    /*-------------------------------------------Find All By Country Id-------------------------------------------*/

    public Collection<City> findByCountryId(Long id){
        log.info("se buscaron ciudades filtradas por un pais con id: " + id);
        return cityRepository.findByCountryId(id);
    }

}
