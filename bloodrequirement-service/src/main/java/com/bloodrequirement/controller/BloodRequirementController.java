package com.bloodrequirement.controller;

import com.bloodrequirement.entity.BloodRequirement;
import com.bloodrequirement.service.BloodRequirementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bloodrequirement")
@CrossOrigin(origins = "http://localhost:4200")
public class BloodRequirementController {

    @Autowired
    private BloodRequirementService bloodRequirementService;

    @PostMapping("/save")
    public ResponseEntity<BloodRequirement> saveBloodRequirement(@RequestBody BloodRequirement bloodRequirement) {
        log.info("saveBloodRequiremen() method of BloodRequirementController is called");
        BloodRequirement savedBloodRequirement = bloodRequirementService.saveBloodRequirement(bloodRequirement);
        return new ResponseEntity<>(savedBloodRequirement, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BloodRequirement>> getAllBloodRequirements() {
        log.info("getAllBloodRequirements() method of BloodRequirementController is called");
        List<BloodRequirement> bloodRequirements = bloodRequirementService.getAllBloodRequirements();
        return new ResponseEntity<>(bloodRequirements, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bloodRequirementId}")
    public ResponseEntity<Integer> deleteByBloodRequirementId(@PathVariable("bloodRequirementId") Integer bloodRequirementId) {
        log.info("deleteById() method of BloodRequirementController is called");
        Integer bloodRequirement = bloodRequirementService.deleteByBloodRequirementId(bloodRequirementId);
        return new ResponseEntity<>(bloodRequirement, HttpStatus.OK);
    }
}
