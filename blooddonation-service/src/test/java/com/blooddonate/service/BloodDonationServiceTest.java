package com.blooddonate.service;

import com.blooddonate.entity.BloodDonation;
import com.blooddonate.repository.BloodDonationRepository;
import com.blooddonate.service.impl.BloodDonationServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BloodDonationServiceTest {

    @Mock
    private BloodDonationRepository bloodDonationRepository;

    @InjectMocks
    private BloodDonationServiceImpl bloodDonationService;

    @DisplayName("JUnit test for donateBlood() method of Service")
    @Test
    public void givenBlood_whenSave_thenReturnDonatedBlood() {

        BloodDonation bloodDonation = BloodDonation.builder()
                .state("Uttar Pradesh")
                .area("NCR")
                .pinCode(567821)
                .bloodGroup("A-")
                .city("Ghaziabad")
                .hospitalName("Neutrima Hospital")
                .build();

        BDDMockito.given(bloodDonationRepository.save(bloodDonation)).willReturn(bloodDonation);

        BloodDonation donatedBlood =  bloodDonationService.donateBlood(bloodDonation);

        Assertions.assertThat(donatedBlood).isNotNull();
        Assertions.assertThat(donatedBlood.getBloodGroup()).isEqualTo("A-");
    }
}
