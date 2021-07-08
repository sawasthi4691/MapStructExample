package com.mapstruct.sample.controller;

import com.mapstruct.sample.model.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @PostMapping("/home")
    public String getHomePage(@RequestBody Login login){
        return "Home Page";
    }
}
