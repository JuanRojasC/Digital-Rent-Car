package com.digital_booking.api_products.controller;

import com.digital_booking.api_products.dto.TermAndConditionDTO;
import com.digital_booking.api_products.service.TermAndConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("terms-and-coditions")
public class TermAndConditionController {

    private final TermAndConditionService termAndConditionService;

    @Autowired
    public TermAndConditionController(TermAndConditionService termAndConditionService) {
        this.termAndConditionService = termAndConditionService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> findAllTermsAndConditions() throws Exception {
        Collection<TermAndConditionDTO> response = termAndConditionService.findAllTermsAndConditions();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save/new")
    public ResponseEntity<?> saveTermAndCondition(@RequestBody TermAndConditionDTO termAndConditionToSave) throws Exception {
        TermAndConditionDTO response = termAndConditionService.saveTermAndCondition(termAndConditionToSave);
        return ResponseEntity.ok(response);
    }
}
