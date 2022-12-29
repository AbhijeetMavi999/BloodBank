package com.bloodrequirement.service;

import com.bloodrequirement.entity.BloodRequirement;
import com.bloodrequirement.repository.BloodRequirementRepository;
import com.bloodrequirement.service.impl.BloodRequirementServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BloodRequirementServiceTest {

    @Mock
    private BloodRequirementRepository bloodRequirementRepository;

    @InjectMocks
    private BloodRequirementServiceImpl bloodRequirementService;

    private BloodRequirement bloodRequirement;

    @BeforeEach
    public void setup() {
        bloodRequirement = BloodRequirement.builder()
                .state("Uttar Pradesh")
                .area("Ganga Nagar")
                .pinCode(235460)
                .bloodGroup("AB-")
                .build();
    }

    @DisplayName("JUnit test for save blood requirement service")
    @Test
    public void givenBloodRequirement_whenSave_thenReturnBloodRequirement() {

        BDDMockito.given(bloodRequirementRepository.save(bloodRequirement)).willReturn(bloodRequirement);

        BloodRequirement saved = bloodRequirementService.saveBloodRequirement(bloodRequirement);

        Assertions.assertThat(saved).isNotNull();
    }

    @DisplayName("JUnit test for get all blood requirement")
    @Test
    public void givenBloodRequirements_whenFindAll_thenReturnBloodRequirements() {

        BloodRequirement bloodRequirement1 = BloodRequirement.builder()
                .state("Uttar Pradesh")
                .area("Ganga Nagar")
                .pinCode(235460)
                .bloodGroup("AB-")
                .build();

        BDDMockito.given(bloodRequirementRepository.findAll()).willReturn(List.of(bloodRequirement, bloodRequirement1));

        List<BloodRequirement> bloodRequirementList = bloodRequirementService.getAllBloodRequirements();

        Assertions.assertThat(bloodRequirementList).isNotNull();
        Assertions.assertThat(bloodRequirementList.size()).isEqualTo(2);
    }
}
