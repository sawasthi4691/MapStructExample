package com.mapstruct.sample.Dto;

import com.mapstruct.sample.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate dob;
    private long mobile;
    private Address address;
}
