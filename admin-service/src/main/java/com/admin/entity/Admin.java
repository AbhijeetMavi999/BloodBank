package com.admin.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Admin {

    @Id
    private String adminId;
    private String adminPassword;
}
