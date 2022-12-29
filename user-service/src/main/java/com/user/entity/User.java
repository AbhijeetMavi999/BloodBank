package com.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
//@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]+$", message = "firstname must be string")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]+$", message = "lastname must be string")
    private String lastName;

    @NotNull
    @Min(18)
    @Max(55)
    private Integer age;

    @NotNull
    private String gender;

    @NotNull
    private Long contactNumber;

    @Email
    private String email;

    @NotNull
    @Size(min = 8, max = 30)
    private String password;

    @NotNull
    private Integer weight;

    @NotNull
    private String state;

    @NotNull
    private String area;

    @NotNull
    private Integer pinCode;

    @NotNull
    private String bloodGroup;
}
