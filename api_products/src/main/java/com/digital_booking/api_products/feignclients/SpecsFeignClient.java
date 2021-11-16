package com.digital_booking.api_products.feignclients;

import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.vo.Specs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "specs-service")
@RequestMapping("/specs")
public interface SpecsFeignClient {

    @PostMapping("/save/new")
    Specs saveSpecs(@RequestBody Specs p);

    @PostMapping("/find/ids")
    Collection<Specs> findSpecsByIds(@RequestBody Collection<Long> specsIds);

    @GetMapping("/find/all")
    Collection<Specs> findAllSpecs();

    @GetMapping("/find/{id}")
    Specs findSpecsById(@PathVariable Long id) throws ResourceNotFound;

    @PutMapping("/update/specs")
    void editSpecs(@RequestBody Specs p) throws ResourceNotFound;

    @DeleteMapping("/delete/{id}")
    void deleteSpecs(@PathVariable Long id) throws ResourceNotFound;
}
