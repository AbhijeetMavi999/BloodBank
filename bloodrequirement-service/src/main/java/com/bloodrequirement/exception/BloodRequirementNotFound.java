package com.bloodrequirement.exception;

public class BloodRequirementNotFound extends RuntimeException{

    public BloodRequirementNotFound() {
    }

    public BloodRequirementNotFound(String message) {
        super(message);
    }
}
