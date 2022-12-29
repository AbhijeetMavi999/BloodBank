package com.blooddonate.repository;

import com.blooddonate.entity.BloodDonation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BloodDonationRepositoryTest {

    @Autowired
    private BloodDonationRepository bloodDonationRepository;

    @DisplayName("JUnit test for donate the blood")
    @Test
    public void givenDonateBlood_whenSave_thenReturnBloodDonation() {

        BloodDonation bloodDonation = new BloodDonation();
        bloodDonation.setState("Uttar Pradesh");
        bloodDonation.setArea("India Gate");
        bloodDonation.setPinCode(401418);
        bloodDonation.setBloodGroup("B+");
        bloodDonation.setCity("Meerut");
        bloodDonation.setHospitalName("Anand Nirogdham Hospital");

        BloodDonation saveBloodDonation = bloodDonationRepository.save(bloodDonation);

        Assertions.assertThat(saveBloodDonation).isNotNull();
        Assertions.assertThat(saveBloodDonation.getId()).isGreaterThan(0);
    }
}
