package com.blooddonate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BloodDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String state;
    private String area;
    private Integer pinCode;
    private String bloodGroup;
    private String city;
    private String hospitalName;
}
