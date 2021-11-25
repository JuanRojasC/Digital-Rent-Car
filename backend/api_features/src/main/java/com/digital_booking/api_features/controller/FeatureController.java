package com.digital_booking.api_features.controller;

import com.digital_booking.api_features.dto.FeatureDTO;
import com.digital_booking.api_features.exceptions.ResourceNotFound;
import com.digital_booking.api_features.services.FeatureService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    // POST REQUEST
    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @PostMapping("/save/new")
    public ResponseEntity<?> saveFeature(@RequestBody FeatureDTO c){
        FeatureDTO feature = featureService.saveFeature(c);
        return ResponseEntity.status(HttpStatus.OK).body(feature);
    }

    /*Save Features collection*/
    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @PostMapping("/save/collection")
    public ResponseEntity<?> saveFeaturesCollection(@RequestBody Collection<FeatureDTO> features) throws ResourceNotFound {
        Collection<FeatureDTO> feature = featureService.saveFeaturesCollection(features);
        return ResponseEntity.status(HttpStatus.OK).body(feature);
    }

    /*Get Features for each id in list*/
    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @PostMapping("/find/ids")
    public ResponseEntity<?> findFeaturesByIds(@RequestBody Collection<Long> featuresIds) throws ResourceNotFound {
        Collection<FeatureDTO> features = featureService.findAllFeaturesById(featuresIds);
        return ResponseEntity.status(HttpStatus.OK).body(features);
    }

    /*Delete Features for each id in list*/
    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @PostMapping("/delete/ids")
    public ResponseEntity<?> deleteFeaturesByIds(@RequestBody Collection<Long> featuresIds) throws ResourceNotFound {
        featureService.deleteAllFeaturesById(featuresIds);
        return ResponseEntity.status(HttpStatus.OK).body("Todas las features han sido eliminadas");
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllFeatures() throws ResourceNotFound {
        return ResponseEntity.ok(featureService.findAllFeatures());
    }

    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findFeatureById(@PathVariable Long id) throws ResourceNotFound {
        FeatureDTO feature = featureService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(feature);
    }


    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @PutMapping("/update/feature")
    public ResponseEntity<?> updateFeature(@RequestBody FeatureDTO f) throws ResourceNotFound {
        featureService.updateFeature(f);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @PutMapping("/update/features/ids")
    public ResponseEntity<?> updateFeaturesById(@RequestBody Collection<FeatureDTO> features) throws ResourceNotFound {
        featureService.updateAllFeaturesById(features);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @CircuitBreaker(name = "imagesCB", fallbackMethod = "fallBackImageService")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFeature(@PathVariable Long id) throws ResourceNotFound {
        featureService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Característica Eliminada");
    }

    /*------------------------------------------------------------------------------------------------------*/
    // CIRCUIT BREAKER METHODS
    /*------------------------------------------------------------------------------------------------------*/

    public ResponseEntity<?> fallBackImageService(Exception ex){
        return ResponseEntity.ok("FEATURES-SERVICE: " + ex.getMessage() + ", please try again");
    }
}