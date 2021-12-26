package com.digital_booking.api_specs.controller;

import com.digital_booking.api_specs.dto.SpecsDTO;
import com.digital_booking.api_specs.exceptions.ResourceNotFound;
import com.digital_booking.api_specs.service.SpecsService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/specs")
public class SpecsController {

    private SpecsService specsService;

    @Autowired
    public SpecsController(SpecsService specsService) {
        this.specsService = specsService;
    }

    // POST REQUEST
    @CircuitBreaker(name = "featuresCB", fallbackMethod = "fallBackFeatureService")
    @PostMapping("/save/new")
    public ResponseEntity<?> saveSpecs(@RequestBody SpecsDTO p){
        SpecsDTO specs = specsService.saveSpecs(p);
        return ResponseEntity.status(HttpStatus.OK).body(specs);
    }

    @CircuitBreaker(name = "featuresCB", fallbackMethod = "fallBackFeatureService")
    @PostMapping("/find/ids")
    public ResponseEntity<?> findSpecsByIds(@RequestBody Collection<Long> specsIds){
        Collection<SpecsDTO> specs = specsService.findAllSpecsById(specsIds);
        return ResponseEntity.status(HttpStatus.OK).body(specs);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @CircuitBreaker(name = "featuresCB", fallbackMethod = "fallBackFeatureService")
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllSpecs(){
        return ResponseEntity.ok(specsService.findAllSpecs());
}

    @CircuitBreaker(name = "featuresCB", fallbackMethod = "fallBackFeatureService")
    @GetMapping()
    public ResponseEntity<?> specs(){
        return ResponseEntity.ok(specsService.specs());
    }

    @CircuitBreaker(name = "featuresCB", fallbackMethod = "fallBackFeatureService")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findSpecsById(@PathVariable Long id) throws ResourceNotFound {
        SpecsDTO specs = specsService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(specs);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @CircuitBreaker(name = "featuresCB", fallbackMethod = "fallBackFeatureService")
    @PutMapping("/update/specs")
    public ResponseEntity<?> editSpecs(@RequestBody SpecsDTO p) throws ResourceNotFound {
        specsService.updateSpecs(p);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @CircuitBreaker(name = "featuresCB", fallbackMethod = "fallBackFeatureService")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpecs(@PathVariable Long id) throws ResourceNotFound {
        specsService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Specs Eliminado");
    }

    /*------------------------------------------------------------------------------------------------------*/
    // CIRCUIT BREAKER METHODS
    /*------------------------------------------------------------------------------------------------------*/

    public ResponseEntity<?> fallBackFeatureService(Exception ex){
        return ResponseEntity.ok("SPECS-SERVICE: " + ex.getMessage() + ", please try again");
    }

}
