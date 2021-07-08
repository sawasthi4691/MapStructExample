package com.mapstruct.sample.controller;

import com.mapstruct.sample.Dto.AddressDto;
import com.mapstruct.sample.Dto.AddressDto1;
import com.mapstruct.sample.Dto.UserDto;
import com.mapstruct.sample.mapper.UserMapper;
import com.mapstruct.sample.model.Address;
import com.mapstruct.sample.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * With all values provided.
     * @param user
     * @return
     */
    @PostMapping("/home/user")
    private ResponseEntity getUser(@RequestBody @Valid User user){
        UserDto userDto = userMapper.userToUserDto(user);
        System.out.println(userDto.toString());
        return ResponseEntity.accepted().body(userDto);
    }

    /**
     * With all values provided.
     * But ignore address value when passed from request.
     * @param user
     * @return
     */
    @PostMapping("/home/user1")
    private ResponseEntity getUserWithoutAddress(@RequestBody @Valid User user){
        UserDto userDto = userMapper.userToUserDtowithoutAddress(user);
        System.out.println(userDto.toString());
        return ResponseEntity.accepted().body(userDto);
    }


    /**
     * With all values provided.
     * Calculate Age.
     * @param user
     * @return
     */
    @PostMapping("/home/user2")
    private ResponseEntity getUserCalculateAge(@RequestBody @Valid User user){
        UserDto userDto = userMapper.userToUserDto1(user);
        System.out.println(userDto.toString());
        return ResponseEntity.accepted().body(userDto);
    }

    /**
     * with all values
     * @param address
     * @return
     */
    @PostMapping("/home/address")
    private ResponseEntity getAddress(@RequestBody @Valid Address address){
        AddressDto addressDto = userMapper.addressToAddressDto(address);
        System.out.println(addressDto.toString());
        return ResponseEntity.accepted().body(addressDto);
    }


    /**
     * with all values
     * @param address
     * @return
     */
    @PostMapping("/home/address1")
    private ResponseEntity getAddress1(@RequestBody @Valid Address address){
        AddressDto1 addressDto = userMapper.addressToAddressDto1(address);
        System.out.println(addressDto.toString());
        return ResponseEntity.accepted().body(addressDto);
    }

    /**
     * with all values
     * @param address
     * @return
     */
    @PostMapping("/home/address2")
    private ResponseEntity getAddress2(@RequestBody @Valid List<Address> address){
        List<AddressDto> addressDto = userMapper.addressToAddressDTOs(address);
        addressDto.stream().forEach(addressDto1 -> System.out.println(addressDto1));
        return ResponseEntity.accepted().body(addressDto);
    }
}
