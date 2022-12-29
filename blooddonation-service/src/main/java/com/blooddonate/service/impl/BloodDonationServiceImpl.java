package com.blooddonate.service.impl;

import com.blooddonate.entity.BloodDonation;
import com.blooddonate.exception.BloodDonationNotFound;
import com.blooddonate.repository.BloodDonationRepository;
import com.blooddonate.service.BloodDonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BloodDonationServiceImpl implements BloodDonationService {

    @Autowired
    private BloodDonationRepository bloodDonationRepository;

    @Override
    public BloodDonation donateBlood(BloodDonation bloodDonation) {
        log.info("donateBlood() method of BloodDonationService is called");
        BloodDonation bloodDonated = bloodDonationRepository.save(bloodDonation);
        if(bloodDonated == null) {
            log.warn("No one donated the blood yet");
            throw new BloodDonationNotFound("No one donated the blood yet");
        }
        return bloodDonated;
    }
}
