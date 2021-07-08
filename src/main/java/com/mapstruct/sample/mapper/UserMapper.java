package com.mapstruct.sample.mapper;


import com.mapstruct.sample.Dto.AddressDto;
import com.mapstruct.sample.Dto.AddressDto1;
import com.mapstruct.sample.Dto.UserDto;
import com.mapstruct.sample.model.Address;
import com.mapstruct.sample.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;


@Mapper(componentModel =  "spring" ,
        imports = {Period.class,LocalDate.class})
public interface UserMapper {

    //with all user values
    UserDto userToUserDto(User user);

    //ignore address value when it is passed from request.
    @Mapping(target = "address" , ignore = true)
    UserDto userToUserDtowithoutAddress(User user);


    //with all user values and calculate age.
    // if the value passed in age variable, then its get overridden.
    // below one is called Java expression.
   // @Mapping(target = "age" , expression = "java( Period.between(user.getDob(),LocalDate.now()).getYears() )")

    //this is called using default function of interface, if complicated logic need to be added.
    @Mapping(target = "age" , expression = "java(birthDatetoAge(user))" , dependsOn = "dob")
    UserDto userToUserDto1(User user);

    default int birthDatetoAge(User user){
        Period period = Period.between(user.getDob(),LocalDate.now());
        return period.getYears();
    }

    //with all address values
    AddressDto addressToAddressDto(Address address);

    //with all address values store in  dto which have variable different
    @Mapping(target = "city1" , source ="city", defaultValue = "city1")
    @Mapping(target = "state1" , source ="state")
    @Mapping(target = "pincode1" , source ="pincode")
    AddressDto1 addressToAddressDto1(Address address);

    //Will take List
    List<AddressDto> addressToAddressDTOs(List<Address> addressList);

    //check UserMappingImpl.class created inside target folder.
    @Mapping(target = "firstName",ignore = true)
    @Mapping(target = "lastName" , ignore = true)
    public void update(@MappingTarget  User user, UserDto userDto);
}
