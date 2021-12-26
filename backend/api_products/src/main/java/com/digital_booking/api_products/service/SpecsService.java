package com.digital_booking.api_products.service;

import com.digital_booking.api_products.feignclients.SpecsFeignClient;
import com.digital_booking.api_products.util.Log;
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
            log.info(Log.formatLog("SPECS-SERVICE-SAVING", "Guardando nuevas specs"));
            Specs specsResponse = specsFeignClient.saveSpecs(specs);
            log.info(Log.formatLog("SPECS-SERVICE-SUCCESS", "Specs con id " + specsResponse.getId() + " guardadas"));
            return specsResponse;
        }catch (Exception e){
            log.error(Log.formatLog("SPECS-SERVICE-FAIL", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Specs getSpecs(Long id){
        try{
            log.info(Log.formatLog("SPECS-SERVICE-FINDING", "Buscando specs con id " + id));
            Specs specs = specsFeignClient.findSpecsById(id);
            log.info(Log.formatLog("SPECS-SERVICE-SUCCESS", "Specs con id " + id + " obtenida"));
            return specs;
        }catch (Exception e){
            log.error(Log.formatLog("SPECS-SERVICE-FAIL", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Map<Long, Specs> getAllSpecs(){
        try{
            log.info(Log.formatLog("SPECS-SERVICE-FINDING", "Buscando todas las specs"));
            Collection<Specs> specs = specsFeignClient.findAllSpecs();
            Map<Long, Specs> specsMap = new HashMap<>();
            for(Specs s : specs){
                specsMap.put(s.getId(), s);
            }
            log.info(Log.formatLog("SPECS-SERVICE-SUCCESS", "Todas las specs han sido obtenidas"));
            return specsMap;
        }catch (Exception e){
            log.error(Log.formatLog("SPECS-SERVICE-FAIL", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Map<Long, Specs> getAllSpecsByIds(Collection<Long> specsIds){
        try{
            log.info(Log.formatLog("SPECS-SERVICE-FINDING", "Buscando specs con ids " + specsIds));
            Collection<Specs> specs = specsFeignClient.findSpecsByIds(specsIds);
            Map<Long, Specs> specsMap = new HashMap<>();
            for(Specs s : specs){
                specsMap.put(s.getId(), s);
            }
            log.info(Log.formatLog("SPECS-SERVICE-SUCCESS", "Specs con ids " + specsIds + " han sido obtenidas"));
            return specsMap;
        }catch (Exception e){
            log.error(Log.formatLog("SPECS-SERVICE-FAIL", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Update Specs-------------------------------------------*/

    public Boolean updateSpecs(Specs specs){
        try{
            log.info(Log.formatLog("SPECS-SERVICE-UPDATING", "Actualizando Specs con id " + specs.getId()));
            specsFeignClient.editSpecs(specs);
            log.info(Log.formatLog("SPECS-SERVICE-SUCCESS", "Specs con id " + specs.getId() + " actualizadas"));
            return true;
        }catch (Exception e){
            log.error(Log.formatLog("SPECS-SERVICE-FAIL", e.getMessage()));
            return false;
        }
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public Boolean deleteSpecs(Long id){
        try{
            log.info(Log.formatLog("SPECS-SERVICE-DELETING", "Eliminando specs con id " + id));
            specsFeignClient.deleteSpecs(id);
            log.info(Log.formatLog("SPECS-SERVICE-SUCCESS", "Specs con id " + id + " eliminadas"));
            return true;
        }catch (Exception e){
            log.error(Log.formatLog("SPECS-SERVICE-FAIL", e.getMessage()));
            return false;
        }
    }

}
