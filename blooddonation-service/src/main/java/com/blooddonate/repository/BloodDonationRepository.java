package com.blooddonate.repository;

import com.blooddonate.entity.BloodDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodDonationRepository extends JpaRepository<BloodDonation, Integer> {

}
