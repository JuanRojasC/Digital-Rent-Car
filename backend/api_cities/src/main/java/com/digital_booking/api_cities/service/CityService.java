package com.digital_booking.api_cities.service;

import com.digital_booking.api_cities.cache.CacheCities;
import com.digital_booking.api_cities.exceptions.IncompleteData;
import com.digital_booking.api_cities.exceptions.ResourceNotFound;
import com.digital_booking.api_cities.model.City;
import com.digital_booking.api_cities.repository.ICityRepository;
import com.digital_booking.api_cities.util.Log;
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
        log.info(Log.formatLog("CITIES-SERVICE-SAVING", "Guardando nueva city"));
        c.setId(null);
        if(c.getCountry().getId() != null) c.setCountry(countryService.findCountryById(c.getCountry().getId()));
        else throw new IncompleteData("Especifique el id del country donde se ubica la city");
        City city = cityRepository.save(c);
        log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "City con id " + city.getId() + " guardada"));
        return city;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public City findById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("CITIES-SERVICE-FINDING", "Buscando city con id " + id));
        City city = this.cacheCities.checkCacheForCity(id);
        city = city == null? cityRepository.findById(id).get() : city;
        if(city == null){
            throw new ResourceNotFound("No se encontró la ciudad con id "+ id);
        }else {
            log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "City con id " + id + " encontrada"));
            return city;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<City> findAllCitiesById(Collection<Long> ids){
        log.info(Log.formatLog("CITIES-SERVICE-FINDING", "Buscando cities con ids " + ids));
        Collection<City> cities = cityRepository.findAllById(ids);
        log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "Cities con ids " + ids +" obtenidas"));
        return cities;
    }

    /*-------------------------------------------Update City-------------------------------------------*/

    public City updateCity(City c) throws ResourceNotFound, IncompleteData {
        log.info(Log.formatLog("CITIES-SERVICE-UPDATING", "Actualizando city con id " + c.getId()));
        if(c.getId() != null ) findById(c.getId());
        else throw new IncompleteData("El id de la ciudad no puede ser nulo");
        City city = cityRepository.save(c);
        log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "Cities con id " + c.getId() +" actualizada"));
        return city;
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteCityById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("CITIES-SERVICE-DELETING", "Eliminand city con id " + id));
        findById(id);
        cityRepository.deleteById(id);
        log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "Cities con id " + id +" eliminada"));
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<City> findAllCities(){
        log.info(Log.formatLog("CITIES-SERVICE-FINDING", "Buscando todas las cities"));
        Collection<City> cities = cityRepository.findAll();
        log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "Todas las cities han sido obtenidas"));
        return cities;
    }

    /*-------------------------------------------Find All By Country Id-------------------------------------------*/

    public Collection<City> findByCountryId(Long id){
        log.info(Log.formatLog("CITIES-SERVICE-FINDING", "Buscando cities con el pais_id " + id));
        Collection<City> cities = cityRepository.findByCountryId(id);
        log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "Todas las cities con el country_id \" + id + \" han sido obtenidas"));
        return cities;
    }

}
