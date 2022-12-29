package com.blooddonate.exception;

public class BloodDonationNotFound extends RuntimeException {

    public BloodDonationNotFound() {
    }

    public BloodDonationNotFound(String message) {
        super(message);
    }
}
