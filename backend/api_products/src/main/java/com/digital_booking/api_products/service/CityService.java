package com.digital_booking.api_products.service;

import com.digital_booking.api_products.feignclients.CityFeignClient;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.City;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Log4j
@Service
public class CityService {

    private CityFeignClient cityFeignClient;

    @Autowired
    public CityService(CityFeignClient cityFeignClient) {
        this.cityFeignClient = cityFeignClient;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public City getCity(Long id){
        try{
            log.info(Log.formatLog("CITIES-SERVICE-FINDING", "Buscando city con id " + id));
            City city = cityFeignClient.findCityById(id);
            log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "City con id " + id + " encontrada"));
            return city;
        }catch (Exception e){
            log.info(Log.formatLog("**CITIES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Map<Long, City> getAllCities(){
        try{
            log.info(Log.formatLog("CITIES-SERVICE-FINDING", "Buscando todas las cities"));
            Collection<City> cities = cityFeignClient.findAllCities();
            Map<Long, City> citiesMap = new HashMap<>();
            for(City c : cities){
                citiesMap.put(c.getId(), c);
            }
            log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "Todas las cities han sido obtenidas"));
            return citiesMap;
        }catch (Exception e){
            log.info(Log.formatLog("**CITIES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Map<Long, City> getAllCitiesById(Collection<Long> ids){
        try{
            log.info(Log.formatLog("CITIES-SERVICE-FINDING", "Buscando cities con ids " + ids));
            Collection<City> cities = cityFeignClient.findCitiesByIds(ids);
            Map<Long, City> citiesMap = new HashMap<>();
            for(City c : cities){
                citiesMap.put(c.getId(), c);
            }
            log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "Cities con ids " + ids +" obtenidas"));
            return citiesMap;
        }catch (Exception e){
            log.info(Log.formatLog("**CITIES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<City> getAllCitiesByCountryId(Long id){
        try{
            log.info(Log.formatLog("CITIES-SERVICE-FINDING", "Buscando cities con el pais_id " + id));
            Collection<City> city = cityFeignClient.findCityByCountryId(id);
            log.info(Log.formatLog("CITIES-SERVICE-SUCCESS", "Todas las cities con el country_id \" + id + \" han sido obtenidas"));
            return city;
        }catch (Exception e){
            log.info(Log.formatLog("**CITIES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }
}
