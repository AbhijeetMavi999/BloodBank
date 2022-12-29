package com.bloodrequirement.repository;

import com.bloodrequirement.entity.BloodRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequirementRepository extends JpaRepository<BloodRequirement, Integer> {

    Integer deleteByBloodRequirementId(Integer id);
}
