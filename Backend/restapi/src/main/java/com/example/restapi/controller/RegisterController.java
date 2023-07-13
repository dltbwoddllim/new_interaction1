package com.example.restapi.controller;

import com.example.restapi.data.DTO.registerDto;
import com.example.restapi.data.entity.UserInfoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class RegisterController {


    @PostMapping("/register")
    public void registercontroller(@RequestBody registerDto registerDto) {

    }
}
