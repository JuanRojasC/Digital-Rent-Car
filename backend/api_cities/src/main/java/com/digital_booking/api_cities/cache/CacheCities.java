package com.digital_booking.api_cities.cache;

import com.digital_booking.api_cities.exceptions.ResourceNotFound;
import com.digital_booking.api_cities.model.City;
import com.digital_booking.api_cities.repository.ICityRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Log4j
@Component
public class CacheCities {

    private static CacheCities instance = null;

    @Autowired
    private ICityRepository cityRepository;
    private Map<Long, City> cacheCitiesForFeatures = new HashMap<>();

    private CacheCities(){
    }

    public static CacheCities getInstance() {
        if(instance == null){
            instance = new CacheCities();
        }
        return instance;
    }

    /*-------------------------------------------Post Construct-------------------------------------------*/

    @PostConstruct
    public void startCacheForCities(){
        Long ids[] = {1L, 2L};
        Collection<City> citiesResponse = cityRepository.findAllById(Arrays.asList(ids));
        log.info("CITIES-CACHE MEMORY: Se guardaron las cities con ids: " + Arrays.asList(ids));
        Map<Long, City> cities = new HashMap<>();
        for(City city : citiesResponse){
            cities.put(city.getId(), city);
        }
        this.cacheCitiesForFeatures = cities;
    }

    /*-------------------------------------------Methods-------------------------------------------*/

    public Map<Long, City> checkCacheForCities(Collection<Long> ids) throws ResourceNotFound {
        Map<Long, City> cities = new HashMap<>();
        for(Long id : ids){
            City city = this.cacheCitiesForFeatures.get(id);
            if(city == null) {
                city = cityRepository.getById(id);
                city = city.getId() != null? city : null;
                if(city != null){
                    this.cacheCitiesForFeatures.put(city.getId(), city);
                }
            }
            cities.put(city.getId(), city);
        }
        return cities;
    }

    public City checkCacheForCity(Long id) throws ResourceNotFound {
        City city = this.cacheCitiesForFeatures.get(id);
        if(city != null){
            log.info("CITIES-CACHE MEMORY USED");
        }
        return city;
    }
}
