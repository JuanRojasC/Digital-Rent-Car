package com.digital_booking.api_specs.service;

import com.digital_booking.api_specs.exceptions.ResourceNotFound;
import com.digital_booking.api_specs.feignclients.FeatureFeignClient;
import com.digital_booking.api_specs.util.Log;
import com.digital_booking.api_specs.vo.Feature;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Log4j
@Service
public class FeatureService {

    private FeatureFeignClient featureFeignClient;

    @Autowired
    public FeatureService(FeatureFeignClient featureFeignClient) {
        this.featureFeignClient = featureFeignClient;
    }

    /*-------------------------------------------Save Feature-------------------------------------------*/

    public Feature saveFeature(Feature feature){
        try{
            log.info(Log.formatLog("FEATURES-SERVICE-SAVING", "Guardando nueva feature"));
            Feature featureReturn = featureFeignClient.saveFeature(feature);
            log.info(Log.formatLog("FEATURES-SERVICE-SUCCESS", "Feature con id " + feature.getId() + " guardada"));
            return featureReturn;
        }catch (Exception e){
            log.error(Log.formatLog("**FEATURES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Save Feature's Collection-------------------------------------------*/

    public Collection<Feature> saveFeaturesCollection(Collection<Feature> features){
        try{
            log.info(Log.formatLog("FEATURES-SERVICE-SAVING", "Guardando coleccion de features"));
            Collection<Feature> featuresResponse = featureFeignClient.saveFeaturesCollection(features);
            Collection<Long> ids = new ArrayList<>();
            for(Feature feature : featuresResponse){
                ids.add(feature.getId());
            }
            log.info(Log.formatLog("FEATURES-SERVICE-SUCCESS", "Features con ids " + ids + " guardadas"));
            return featuresResponse;
        }catch (Exception e){
            log.error(Log.formatLog("**FEATURES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }


    /*-------------------------------------------Update Feature-------------------------------------------*/

    public Boolean updateFeature(Feature feature){
        try{
            log.info(Log.formatLog("FEATURES-SERVICE-UPDATING", "Actualizando feature con id " + feature.getId()));
            featureFeignClient.updateFeature(feature);
            log.info(Log.formatLog("FEATURES-SERVICE-SUCCESS", "Feature con id " + feature.getId() + " actualizada"));
            return true;
        }catch (Exception e){
            log.error(Log.formatLog("**FEATURES-SERVICE-FAIL**", e.getMessage()));
            return false;
        }
    }

    /*-------------------------------------------Update All By Id-------------------------------------------*/

    public Boolean updateFeaturesById(Collection<Feature> features){
        try{
            log.info(Log.formatLog("FEATURES-SERVICE-UPDATING", "Actualizando coleccion de features con ids"));
            featureFeignClient.updateFeaturesById(features);
            Collection<Long> ids = new ArrayList<>();
            for(Feature feature : features){
                ids.add(feature.getId());
            }
            log.info(Log.formatLog("FEATURES-SERVICE-SUCCESS", "Features con ids " + ids + " actualizadas"));
            return true;
        }catch (Exception e){
            log.error(Log.formatLog("**FEATURES-SERVICE-FAIL**", e.getMessage()));
            return false;
        }
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Feature getFeature(Long id){
        try{
            log.info(Log.formatLog("FEATURES-SERVICE-FINDING", "Buscando feature con id " + id));
            Feature feature = featureFeignClient.findFeatureById(id);
            log.info(Log.formatLog("FEATURES-SERVICE-SUCCESS", "Feature con id " + id + "encontrada"));
            return feature;
        }catch (Exception e){
            log.error(Log.formatLog("**FEATURES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<Feature> getFeaturesByIds(Collection<Long> ids){
        try{
            log.info(Log.formatLog("FEATURES-SERVICE-FINDING", "Buscando features con ids" + ids));
            Collection<Feature> featuresReturn = featureFeignClient.findFeaturesByIds(ids);
            log.info(Log.formatLog("FEATURES-SERVICE-SUCCESS", "Features con ids " + ids + " han sido obtenidas"));
            return featuresReturn;
        }catch (Exception e){
            log.error(Log.formatLog("**FEATURES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<Feature> getAllFeatures(){
        try{
            log.info(Log.formatLog("FEATURES-SERVICE-FINDING", "Buscando todas las features"));
            Collection<Feature> features = featureFeignClient.findAllFeatures();
            log.info(Log.formatLog("FEATURES-SERVICE-SUCCESS", "Todas las features han sido obtenidas"));
            return features;
        }catch (Exception e){
            log.error(Log.formatLog("**FEATURES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public Boolean deleteFeaturesByIds(Collection<Long> ids) throws ResourceNotFound {
        try{
            log.info(Log.formatLog("FEATURES-SERVICE-DELETING", "Eliminando features con ids " + ids));
            featureFeignClient.deleteFeaturesByIds(ids);
            log.info(Log.formatLog("FEATURES-SERVICE-DELETING", "Features con ids " + ids + " eliminadas"));
            return true;
        }catch (Exception e){
            log.error(Log.formatLog("**FEATURES-SERVICE-FAIL**", e.getMessage()));
            String id = e.getMessage().replaceAll("\\D+", "");
            throw new ResourceNotFound("ERROR 404: No se encontro la feature con id " + id + "\n           " + "Verifique los ids enviados");
        }
    }
}
