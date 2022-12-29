package com.bloodrequirement.repository;

import com.bloodrequirement.entity.BloodRequirement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class BloodRequirementRepositoryTest {

    @Autowired
    private BloodRequirementRepository bloodRequirementRepository;

    private BloodRequirement bloodRequirement;

    @BeforeEach
    public void setup() {
        bloodRequirement = BloodRequirement.builder()
                .state("Uttar Pradesh")
                .area("Near Noida")
                .pinCode(235072)
                .bloodGroup("B+")
                .build();
    }

    @DisplayName("JUnit test for save blood requirement")
    @Test
    public void givenBloodRequirement_whenSave_thenReturnBloodRequirement() {

        BloodRequirement savedBloodRequirement = bloodRequirementRepository.save(bloodRequirement);

        Assertions.assertThat(savedBloodRequirement).isNotNull();
        Assertions.assertThat(savedBloodRequirement.getBloodRequirementId()).isGreaterThan(0);
    }

    @DisplayName("JUnit test for get all blood requirement")
    @Test
    public void givenBloodRequirements_whenFindBloodRequirements_thenReturnBloodRequirements() {

        BloodRequirement bloodRequirement1 = new BloodRequirement();
        bloodRequirement1.setState("Haryana");
        bloodRequirement1.setArea("Near Faridabad");
        bloodRequirement1.setPinCode(250151);
        bloodRequirement1.setBloodGroup("AB-");


        bloodRequirementRepository.save(bloodRequirement);
        bloodRequirementRepository.save(bloodRequirement1);

        List<BloodRequirement> bloodRequirementList = bloodRequirementRepository.findAll();

        Assertions.assertThat(bloodRequirementList).isNotNull();
        Assertions.assertThat(bloodRequirementList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for delete by blood requirement Id")
    @Test
    public void givenId_whenDeletedById_thenReturnNumberOfRecordDeleted() {

        bloodRequirementRepository.save(bloodRequirement);

        Integer deletedRecord = bloodRequirementRepository.deleteByBloodRequirementId(
                bloodRequirement.getBloodRequirementId());

        Assertions.assertThat(deletedRecord).isNotNull();
        Assertions.assertThat(deletedRecord).isEqualTo(1);
    }
}
