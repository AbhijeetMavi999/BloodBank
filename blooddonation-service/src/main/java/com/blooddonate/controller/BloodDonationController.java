package com.blooddonate.controller;

import com.blooddonate.entity.BloodDonation;
import com.blooddonate.service.BloodDonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/donateblood")
@CrossOrigin(origins = "http://localhost:4200")
public class BloodDonationController {

    @Autowired
    private BloodDonationService bloodDonationService;

    @PostMapping("/save")
    public ResponseEntity<BloodDonation> donateBlood(@RequestBody BloodDonation bloodDonation) {
        log.info("donateBlood() method of BloodDonationController is called");
        BloodDonation bloodDonated = bloodDonationService.donateBlood(bloodDonation);
        return new ResponseEntity<>(bloodDonated, HttpStatus.OK);
    }
}
