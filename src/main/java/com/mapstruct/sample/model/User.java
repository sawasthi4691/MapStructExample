package com.mapstruct.sample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate dob;
    private long mobile;
    private Address address;
}
