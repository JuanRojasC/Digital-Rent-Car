package com.digital_booking.api_specs.feignclients;

import com.digital_booking.api_specs.exceptions.ResourceNotFound;
import com.digital_booking.api_specs.vo.Feature;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "features-service", url = "http://localhost:9004")
@RequestMapping("/features")
public interface FeatureFeignClient {

    @PostMapping("/save/new")
    Feature saveFeature(@RequestBody Feature f);

    @PostMapping("/find/ids")
    Collection<Feature> findFeaturesByIds(@RequestBody Collection<Long> featuresId);

    @PostMapping("/save/collection")
    Collection<Feature> saveFeaturesCollection(@RequestBody Collection<Feature> features);

    @PostMapping("/delete/ids")
    void deleteFeaturesByIds(@RequestBody Collection<Long> featuresIds) throws ResourceNotFound;

    @GetMapping("/find/{id}")
    Feature findFeatureById(@PathVariable Long id) throws ResourceNotFound;

    @GetMapping("/find/all")
    Collection<Feature> findAllFeatures();

    @PutMapping("/update/feature")
    void updateFeature(@RequestBody Feature f) throws ResourceNotFound;

    @PutMapping("/update/features/ids")
    void updateFeaturesById(@RequestBody Collection<Feature> features) throws ResourceNotFound;

}
