package com.mapstruct.sample.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto1 {

    private String city1;
    private String state1;
    private String line1;
    private String line2;
    private int pincode1;

}
