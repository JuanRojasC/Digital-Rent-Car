package com.digital_booking.api_specs.service;

import com.digital_booking.api_specs.exceptions.ResourceNotFound;
import com.digital_booking.api_specs.feignclients.FeatureFeignClient;
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
            Feature featureReturn = featureFeignClient.saveFeature(feature);
            log.info("FEATURES-API SUCCESS: feature" + feature.getName() + ": " + feature.getValue() + " guardada");
            return featureReturn;
        }catch (Exception e){
            log.error("FEATURES-API FAIL: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Save Feature's Collection-------------------------------------------*/

    public Collection<Feature> saveFeaturesCollection(Collection<Feature> features){
        try{
            Collection<Feature> featuresResponse = featureFeignClient.saveFeaturesCollection(features);
            Collection<Long> ids = new ArrayList<>();
            for(Feature feature : featuresResponse){
                ids.add(feature.getId());
            }
            log.info("FEATURES-API SUCCESS: features con ids " + ids + " guardadas");
            return featuresResponse;
        }catch (Exception e){
            log.error("FEATURES-API FAIL: " + e.getMessage());
            return null;
        }
    }


    /*-------------------------------------------Update Feature-------------------------------------------*/

    public Boolean updateFeature(Feature feature){
        try{
            featureFeignClient.updateFeature(feature);
            log.info("FEATURES-API SUCCESS: feature" + feature.getName() + ": " + feature.getValue() + " actualizada");
            return true;
        }catch (Exception e){
            log.error("FEATURES-API FAIL: " + e.getMessage());
            return false;
        }
    }

    /*-------------------------------------------Update All By Id-------------------------------------------*/

    public Boolean updateFeaturesById(Collection<Feature> features){
        try{
            featureFeignClient.updateFeaturesById(features);
            Collection<Long> ids = new ArrayList<>();
            for(Feature feature : features){
                ids.add(feature.getId());
            }
            log.info("FEATURES-API SUCCESS: features con ids" + ids +" actualizadas");
            return true;
        }catch (Exception e){
            log.error("FEATURES-API FAIL: " + e.getMessage());
            return false;
        }
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Feature getFeature(Long id){
        try{
            Feature feature = featureFeignClient.findFeatureById(id);
            log.info("FEATURES-API SUCCESS: feature con id " + id + " obtenida");
            return feature;
        }catch (Exception e){
            log.error("FEATURES-API FAIL: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<Feature> getFeaturesByIds(Collection<Long> ids){
        try{
            Collection<Feature> featuresReturn = featureFeignClient.findFeaturesByIds(ids);
            log.info("FEATURES-API SUCCESS: features con ids " + ids + " obtenidas");
            return featuresReturn;
        }catch (Exception e){
            log.error("FEATURES-API FAIL: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<Feature> getAllFeatures(){
        try{
            Collection<Feature> features = featureFeignClient.findAllFeatures();
            log.info("FEATURES-API SUCCESS: todas las features han sido obtenidas");
            return features;
        }catch (Exception e){
            log.error("FEATURES-API FAIL: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public Boolean deleteFeaturesByIds(Collection<Long> ids) throws ResourceNotFound {
        try{
            featureFeignClient.deleteFeaturesByIds(ids);
            log.info("FEATURES-API SUCCESS: features con ids " + ids + " eliminados");
            return true;
        }catch (Exception e){
            log.error("FEATURES-API FAIL: " + e.getMessage());
            String id = e.getMessage().replaceAll("\\D+", "");
            throw new ResourceNotFound("ERROR 404: No se encontro la feature con id " + id + "\n           " + "Verifique los ids enviados");
        }
    }
}
