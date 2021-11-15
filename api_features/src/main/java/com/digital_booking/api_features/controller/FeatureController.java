package com.digital_booking.api_features.controller;

import com.digital_booking.api_features.dto.FeatureDTO;
import com.digital_booking.api_features.exceptions.ResourceNotFound;
import com.digital_booking.api_features.services.FeatureService;
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
    @PostMapping("/save/new")
    public ResponseEntity<?> saveFeature(@RequestBody FeatureDTO c){
        FeatureDTO feature = featureService.saveFeature(c);
        return ResponseEntity.status(HttpStatus.OK).body(feature);
    }

    /*Save Features collection*/
    @PostMapping("/save/collection")
    public ResponseEntity<?> saveFeaturesCollection(@RequestBody Collection<FeatureDTO> features){
        Collection<FeatureDTO> feature = featureService.saveFeaturesCollection(features);
        return ResponseEntity.status(HttpStatus.OK).body(feature);
    }

    /*Get Features for each id in list*/
    @PostMapping("/find/ids")
    public ResponseEntity<?> findFeaturesByIds(@RequestBody Collection<Long> featuresIds){
        Collection<FeatureDTO> features = featureService.findAllFeaturesById(featuresIds);
        return ResponseEntity.status(HttpStatus.OK).body(features);
    }

    /*Delete Features for each id in list*/
    @PostMapping("/delete/ids")
    public ResponseEntity<?> deleteFeaturesByIds(@RequestBody Collection<Long> featuresIds) throws ResourceNotFound {
        featureService.deleteAllFeaturesById(featuresIds);
        return ResponseEntity.status(HttpStatus.OK).body("Todas las features han sido eliminadas");
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllFeatures(){
        return ResponseEntity.ok(featureService.findAllFeatures());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findFeatureById(@PathVariable Long id) throws ResourceNotFound {
        FeatureDTO feature = featureService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(feature);
    }


    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @PutMapping("/update/feature")
    public ResponseEntity<?> updateFeature(@RequestBody FeatureDTO f) throws ResourceNotFound {
        featureService.updateFeature(f);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update/features/ids")
    public ResponseEntity<?> updateFeaturesById(@RequestBody Collection<FeatureDTO> features) throws ResourceNotFound {
        featureService.updateAllFeaturesById(features);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFeature(@PathVariable Long id) throws ResourceNotFound {
        featureService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Característica Eliminada");
    }
}