package com.mapstruct.sample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String city;
    private String state;
    private String line1;
    private String line2;
    private int pincode;

}
