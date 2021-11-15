package com.digital_booking.api_products.service;

import com.digital_booking.api_products.feignclients.SpecsFeignClient;
import com.digital_booking.api_products.vo.Specs;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Log4j
@Service
public class SpecsService {

    private SpecsFeignClient specsFeignClient;

    @Autowired
    public SpecsService(SpecsFeignClient specsFeignClient) {
        this.specsFeignClient = specsFeignClient;
    }

    /*-------------------------------------------Save Specs-------------------------------------------*/

    public Specs saveSpecs(Specs specs){
        try{
            Specs specsResponse = specsFeignClient.saveSpecs(specs);
            log.info("SPECS-API-SAVE: specs con id " + specsResponse.getId() + " guardadas");
            return specsResponse;
        }catch (Exception e){
            log.error("SPECS-API FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Specs getSpecs(Long id){
        try{
            Specs specs = specsFeignClient.findSpecsById(id);
            log.info("SPECS-API-FIND: specs con id " + specs.getId() + " obtenidas");
            return specs;
        }catch (Exception e){
            log.error("SPECS-API FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Map<Long, Specs> getAllSpecs(){
        try{
            Collection<Specs> specs = specsFeignClient.findAllSpecs();
            Map<Long, Specs> specsMap = new HashMap<>();
            for(Specs s : specs){
                specsMap.put(s.getId(), s);
            }
            log.info("SPECS-API-FIND-COLLECTION: Todas las specs han sido obtenidas");
            return specsMap;
        }catch (Exception e){
            log.error("SPECS-API FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Map<Long, Specs> getAllSpecsByIds(Collection<Long> specsIds){
        try{
            Collection<Specs> specs = specsFeignClient.findSpecsByIds(specsIds);
            Map<Long, Specs> specsMap = new HashMap<>();
            for(Specs s : specs){
                specsMap.put(s.getId(), s);
            }
            log.info("SPECS-API-FIND-COLLECTION: Todas las specs con ids: " + specsIds + " han sido obtenidas");
            return specsMap;
        }catch (Exception e){
            log.error("SPECS-API FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Update Specs-------------------------------------------*/

    public Boolean updateSpecs(Specs specs){
        try{
            specsFeignClient.editSpecs(specs);
            log.info("SPECS-API-UPDATE: specs con id " + specs.getId() + " actualizadas");
            return true;
        }catch (Exception e){
            log.error("SPECS-API FALLO: " + e.getMessage());
            return false;
        }
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public Boolean deleteSpecs(Long id){
        try{
            specsFeignClient.deleteSpecs(id);
            log.info("SPECS-API-DELETE: specs con id " + id + " eliminadas");
            return true;
        }catch (Exception e){
            log.error("SPECS-API FALLO: " + e.getMessage());
            return false;
        }
    }

}
