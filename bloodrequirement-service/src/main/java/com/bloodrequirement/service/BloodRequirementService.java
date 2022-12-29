package com.bloodrequirement.service;

import com.bloodrequirement.entity.BloodRequirement;

import java.util.List;

public interface BloodRequirementService {

    public BloodRequirement saveBloodRequirement(BloodRequirement bloodRequirement);

    public List<BloodRequirement> getAllBloodRequirements();

    public Integer deleteByBloodRequirementId(Integer id);
}
