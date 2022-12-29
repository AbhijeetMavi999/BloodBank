package com.bloodrequirement.service.impl;

import com.bloodrequirement.entity.BloodRequirement;
import com.bloodrequirement.exception.BloodRequirementNotFound;
import com.bloodrequirement.repository.BloodRequirementRepository;
import com.bloodrequirement.service.BloodRequirementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class BloodRequirementServiceImpl implements BloodRequirementService {

    @Autowired
    private BloodRequirementRepository bloodRequirementRepository;

    @Override
    public BloodRequirement saveBloodRequirement(BloodRequirement bloodRequirement) {
        log.info("saveBloodRequirement() method of BloodRequirementService is called");
        BloodRequirement savedBloodRequirement = bloodRequirementRepository.save(bloodRequirement);
        return savedBloodRequirement;
    }

    @Override
    public List<BloodRequirement> getAllBloodRequirements() {
        log.info("getAllBloodRequirements() method of BloodRequirementService is called");
        List<BloodRequirement> bloodRequirements = bloodRequirementRepository.findAll();
        if(bloodRequirements == null) {
            log.warn("There is no Blood Requirement");
            throw new BloodRequirementNotFound("There is no Blood Requirement");
        }
        return bloodRequirements;
    }

    @Transactional
    @Override
    public Integer deleteByBloodRequirementId(Integer id) {
        log.info("deleteById() method of BloodRequirementService is called");
        Integer bloodRequirement = bloodRequirementRepository.deleteByBloodRequirementId(id);
        return bloodRequirement;
    }
}
