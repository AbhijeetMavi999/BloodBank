package com.bloodrequirement.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BloodRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bloodRequirementId;

    @NotNull
    private String state;

    @NotNull
    private String area;

    @NotNull
    private Integer pinCode;

    @NotNull
    private String bloodGroup;
}
